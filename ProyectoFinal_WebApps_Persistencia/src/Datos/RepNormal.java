package Datos;

import Blog.Normal;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class RepNormal extends BaseDAO<Normal> {

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido recuperar los datos de la base de datos
     */
    @Override
    public List<Normal> buscar() throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        FindIterable<Normal> usuarios = coleccion.find();
        ArrayList<Normal> listaUsuarios = new ArrayList();
        return usuarios.into(listaUsuarios);
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Normal entidad) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        coleccion.insertOne(entidad);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param id
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

    /**
     *
     * @param entidad
     * @throws DAOException
     */
    @Override
    public void actualizar(Normal entidad) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id", entidad.getId());

        Document datosActualizados = new Document("$set",
                new Document("nombreCompleto", entidad.getNombreCompleto())
                        .append("contrasenia", entidad.getContrasena())
                        .append("genero", entidad.getGenero())
                        .append("fechaNacimiento", entidad.getFechaNacimiento())
                        .append("telefono", entidad.getTelefono())
                        .append("correo", entidad.getCorreo())
                        .append("ciudad", entidad.getCiudad())
                        .append("avatar", entidad.getAvatar()));
        coleccion.findOneAndUpdate(filtroActualizacion, datosActualizados);
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public Normal buscar(ObjectId id) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }

    /**
     *
     * @param correo
     * @return
     */
    public Normal buscarPorCorreo(String correo) {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo", correo);
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }

    /**
     *
     * @param correo
     * @param contra
     * @return
     */
    public Normal buscarPorCorreoyContra(String correo, String contra) {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo", correo);

        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);

        Normal usuario = usuarios.first();
        if (usuario != null) {
            if (validatePassword(contra, usuario.getContrasena())) {
                return usuario;
            }
        }
        return null;
    }

    /**
     *
     * @param originalPassword
     * @param storedPassword
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static boolean validatePassword(String originalPassword, String storedPassword) {
        try {
            String[] parts = storedPassword.split(":");
            int iterations = Integer.parseInt(parts[0]);

            byte[] salt = fromHex(parts[1]);
            byte[] hash = fromHex(parts[2]);

            PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(),
                    salt, iterations, hash.length * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] testHash = skf.generateSecret(spec).getEncoded();

            int diff = hash.length ^ testHash.length;
            for (int i = 0; i < hash.length && i < testHash.length; i++) {
                diff |= hash[i] ^ testHash[i];
            }
            return diff == 0;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RepNormal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     * @param hex
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    /**
     *
     * @return
     */
    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Normal> coleccion = bd.getCollection("usuarios", Normal.class);
        return coleccion;
    }

}
