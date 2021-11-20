package Datos;

import Blog.Admor;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class RepAdmor extends BaseDAO<Admor> {

//    private List<Admor> admors = new ArrayList<>();
    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido recuperar los datos de la base de datos
     */
    @Override
    public List<Admor> buscar() throws DAOException {
        MongoCollection<Admor> coleccion = this.getColeccion();
        FindIterable<Admor> administradores = coleccion.find();
        ArrayList<Admor> listaAdmin = new ArrayList();
        return administradores.into(listaAdmin);
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Admor entidad) throws DAOException {
        MongoCollection<Admor> coleccion = this.getColeccion();
        coleccion.insertOne(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido actualizar los datos de la base de datos
     */
//    @Override
//    public void actualizar(int id, Admor entidad) throws DAOException {
//        admors.get(id).setAnclado(entidad.getAnclado());
//        admors.get(id).setAvatar(entidad.getAvatar());
//        admors.get(id).setCiudad(entidad.getCiudad());
//        admors.get(id).setContrasena(entidad.getContrasena());
//        admors.get(id).setCorreo(entidad.getCorreo());
//        admors.get(id).setFechaNacimiento(entidad.getFechaNacimiento());
//        admors.get(id).setGenero(entidad.getGenero());
//        admors.get(id).setNombreCompleto(entidad.getNombreCompleto());
//        admors.get(id).setTelefono(entidad.getTelefono());
//    }
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
     * @param id Recibe el ID de la entidad para borrarla
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Admor> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

    @Override
    public void actualizar(Admor entidad) throws DAOException {
        MongoCollection<Admor> coleccion = this.getColeccion();
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
    public Admor buscar(ObjectId id) throws DAOException {
        MongoCollection<Admor> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Admor> administradores = coleccion.find(filtroBusqueda);
        Admor admin = administradores.first();
        return admin;
    }

    public Admor buscarPorCorreo(String correo) {
        MongoCollection<Admor> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo", correo);
        FindIterable<Admor> admins = coleccion.find(filtroBusqueda);
        Admor admin = admins.first();
        return admin;
    }

    public Admor buscarPorNombreyContra(String correo, String contra) {
        MongoCollection<Admor> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo", correo);
        filtroBusqueda.append("contrasena", contra);
        FindIterable<Admor> administradores = coleccion.find(filtroBusqueda);
        Admor admin = administradores.first();
        return admin;
    }

    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Admor> coleccion = bd.getCollection("administradores", Admor.class);
        return coleccion;
    }

}