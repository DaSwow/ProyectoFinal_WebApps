package Datos;

import Blog.Normal;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
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

//    private List<Normal> normales = new ArrayList<>();
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
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido actualizar los datos de la base de datos
     */
    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar consultar la base de datos
     */
    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

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

    @Override
    public Normal buscar(ObjectId id) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }

    public Normal buscarPorCorreo(String correo) {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo", correo);
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }

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
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static String generateStrongPasswordHash(String password) {
        try {
            int iterations = 1000;
            char[] chars = password.toCharArray();
            byte[] salt = getSalt();

            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = skf.generateSecret(spec).getEncoded();
            return iterations + ":" + toHex(salt) + ":" + toHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
        }
        return null;
    }

    /**
     *
     * @return @throws NoSuchAlgorithmException
     */
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        System.out.println("Generated salt: " + Arrays.toString(salt));
        return salt;
    }

    /**
     *
     * @param array
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
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

    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Normal> coleccion = bd.getCollection("usuarios", Normal.class);
        return coleccion;
    }

}
