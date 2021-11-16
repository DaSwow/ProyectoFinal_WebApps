package Datos;

import Blog.Anclado;
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
public class RepAnclado extends BaseDAO<Anclado> {

//    private List<Anclado> anclados = new ArrayList<>();
    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido recuperar los datos de la base de datos
     */
    @Override
    public List<Anclado> buscar() throws DAOException {
        MongoCollection<Anclado> coleccion = this.getColeccion();
        FindIterable<Anclado> posts = coleccion.find();
        ArrayList<Anclado> listaPosts = new ArrayList();
        return posts.into(listaPosts);
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Anclado entidad) throws DAOException {
        MongoCollection<Anclado> coleccion = this.getColeccion();
        coleccion.insertOne(entidad);
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(Anclado entidad) throws DAOException {
        MongoCollection<Anclado> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id", entidad.getId());

        Document datosActualizados = new Document("$set",
                 new Document("autor", entidad.getAutor())
                        .append("contenido", entidad.getContenido())
                        .append("fechaHoraCreacion", entidad.getFechaHoraCreacion())
                        .append("fechaHoraEdicion", entidad.getFechaHoraEdicion())
                        .append("titulo", entidad.getTitulo()));
        coleccion.findOneAndUpdate(filtroActualizacion, datosActualizados);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar consultar la base de datos
     */
    @Override
    public Anclado buscar(ObjectId id) throws DAOException {
        MongoCollection<Anclado> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Anclado> posts = coleccion.find(filtroBusqueda);
        Anclado post = posts.first();
        return post;
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Anclado> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Anclado> coleccion = bd.getCollection("Anclados", Anclado.class);
        return coleccion;
    }
}
