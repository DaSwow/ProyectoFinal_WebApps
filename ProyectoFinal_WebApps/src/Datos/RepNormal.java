package Datos;

import Blog.Normal;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class RepNormal extends BaseDAO<Normal> {

//    private List<Normal> normales = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
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
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
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
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */


    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar consultar la base de datos
     */


    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroEliminacion =new Document("_id",id);
        coleccion.deleteOne(filtroEliminacion);
    }

    @Override
    public void actualizar(Normal entidad) throws DAOException {
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id",entidad.getId());
        
        Document datosActualizados=new Document("$set"
                ,new Document("nombreCompleto",entidad.getNombreCompleto())
                        .append("contrasenia", entidad.getContrasena())
                        .append("genero", entidad.getGenero())
                        .append("fechaNacimiento", entidad.getFechaNacimiento())
                        .append("telefono", entidad.getTelefono())
                        .append("correo", entidad.getCorreo())
                        .append("ciudad", entidad.getCiudad())
                        .append("avatar", entidad.getAvatar()));
        coleccion.findOneAndUpdate(filtroActualizacion,datosActualizados);
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
        Document filtroBusqueda = new Document("correo",correo);        
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }
    
    
    public Normal buscarPorNombreyContra(String correo,String contra){
        MongoCollection<Normal> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("correo",correo);
        filtroBusqueda.append("contrasena", contra);
        FindIterable<Normal> usuarios = coleccion.find(filtroBusqueda);
        Normal usuario = usuarios.first();
        return usuario;
    }
    
    @Override
    public MongoCollection getColeccion() {
         MongoDatabase bd = this.getDatabase();
       MongoCollection<Normal> coleccion = bd.getCollection("usuarios", Normal.class);
       return coleccion;
    }

}
