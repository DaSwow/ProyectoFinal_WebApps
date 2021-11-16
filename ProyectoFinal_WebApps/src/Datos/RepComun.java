package Datos;

import Blog.Comun;
import Exceptions.DAOException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author
 */
public class RepComun extends BaseDAO<Comun> {

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido recuperar los datos de la base de datos
     */
    @Override
    public List<Comun> buscar() throws DAOException {
        MongoCollection<Comun> coleccion = this.getColeccion();
        FindIterable<Comun> posts = coleccion.find();
        List<Comun> listaPosts = new ArrayList<>();
        Iterator<Comun> it = posts.iterator();
        while (it.hasNext()) {
            listaPosts.add(it.next());
        }
        return listaPosts;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Comun entidad) throws DAOException {
        MongoCollection<Comun> coleccion = this.getColeccion();
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
        MongoCollection<Comun> coleccion = this.getColeccion();
        Document filtroEliminacion = new Document("_id", id);
        coleccion.deleteOne(filtroEliminacion);
    }

    /**
     *
     * @param entidad
     * @throws DAOException
     */
    @Override
    public void actualizar(Comun entidad) throws DAOException {
        MongoCollection<Comun> coleccion = this.getColeccion();
        Document filtroActualizacion = new Document("_id", entidad.getId());

        Document datosActualizados = new Document("$set",
                new Document("autor", entidad.getAutor())
                        .append("contenido", entidad.getContenido())
                        .append("fechaHoraCreacion", entidad.getFechaHoraCreacion())
                        .append("fechaHoraEdicion", entidad.getFechaHoraEdicion())
                        .append("titulo", entidad.getTitulo())
                        .append("correo", entidad.getComentarios()));
        coleccion.findOneAndUpdate(filtroActualizacion, datosActualizados);
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public Comun buscar(ObjectId id) throws DAOException {
        MongoCollection<Comun> coleccion = this.getColeccion();
        Document filtroBusqueda = new Document("_id", id);
        FindIterable<Comun> posts = coleccion.find(filtroBusqueda);
        Comun post = posts.first();
        return post;
    }

    /**
     *
     * @return
     */
    @Override
    public MongoCollection getColeccion() {
        MongoDatabase bd = this.getDatabase();
        MongoCollection<Comun> coleccion = bd.getCollection("post", Comun.class);
        return coleccion;
    }
}
