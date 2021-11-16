package Datos.WIP;

//package Datos;
//
//import Blog.Usuario;
//import Exceptions.DAOException;
//import com.mongodb.client.MongoCollection;
//import java.util.ArrayList;
//import java.util.List;
//import org.bson.types.ObjectId;
//
///**
// *
// * @author 
// */
//public class RepUsuario extends BaseDAO<Usuario> {
//
//    private List<Usuario> usuarios = new ArrayList<>();
//
//    /**
//     *
//     * @return Regresa todos los datos que se hayan encontrado en la base de
//     * datos
//     * @throws DAOException Regresa una excepcion en caso de que no se hayan
//     * podido recuperar los datos de la base de datos
//     */
//    @Override
//    public List<Usuario> buscar() throws DAOException {
//        return usuarios;
//    }
//
//    /**
//     *
//     * @param entidad
//     * @throws DAOException Regresa una excepcion en caso de que no se haya
//     * podido insertar los datos a la base de datos
//     */
//    @Override
//    public void guardar(Usuario entidad) throws DAOException {
//        usuarios.add(entidad);
//    }
//
//    /**
//     *
//     * @param id
//     * @param entidad
//     * @throws DAOException Regresa una excepcion en caso de que no se hayan
//     * podido actualizar los datos de la base de datos
//     */
//
//
//    /**
//     * Realiza una consulta por ID en la base de datos
//     *
//     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
//     * de datos
//     * @return Regresa la entidad encontrada con el mismo ID del parametro
//     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
//     * error al intentar consultar la base de datos
//     */
//
//
//    /**
//     * Busca y elimina una entidad en la base de datos
//     *
//     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
//     * error al intentar eliminar una entidad en la base de datos
//     */
//    @Override
//    public void eliminar(ObjectId id) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void actualizar(Usuario entidad) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Usuario buscar(ObjectId id) throws DAOException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public MongoCollection getColeccion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
