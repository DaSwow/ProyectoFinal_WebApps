package Datos;

import Exceptions.DAOException;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @param <T>
 */
public abstract class BaseDAO<T> {

    private final String SERVIDOR = "localhost";
    private final int PUERTO = 27017;

    protected MongoDatabase getDatabase() {

        try {
            // CONFIGURACIÓN PARA QUE MONGO HAGA EL MAPEO DE POJOS AUTOMATICAMENTE
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    pojoCodecRegistry);

            // OBJETO QUE EMPAQUETA UNA CADENA DE CONEXION
            ConnectionString cadenaConexion = new ConnectionString("mongodb://" + SERVIDOR + "/" + PUERTO);

            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry).build();

            MongoClient servidor = (MongoClient) MongoClients.create(clientSettings);

            MongoDatabase bd = servidor.getDatabase("proyecto_web");
            return bd;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }

    }

    /**
     * Realiza una consulta en la base de datos
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido recuperar los datos de la base de datos
     */
    public abstract List<T> buscar() throws DAOException;

    /**
     * Inserta nuevos datos en la base de datos
     *
     * @param entidad Recibe una entidad con los datos a agregar a la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se haya podido insertar los datos a la base de datos
     */
    public abstract void guardar(T entidad) throws DAOException;

    /**
     * Actualiza los datos de una entidad existente en la base de datos
     *
     * @param id
     * @param entidad Recibe una entidad con datos actualizados de una entidad existente en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan podido actualizar los datos de la base de datos
     */
    public abstract void actualizar(T entidad) throws DAOException;

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar consultar la base de datos
     */
    public abstract T buscar(ObjectId id) throws DAOException;

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un error al intentar eliminar una entidad en la base de datos
     */
    public abstract void eliminar(ObjectId id) throws DAOException;

    public abstract MongoCollection getColeccion();
}
