package Datos;

import Blog.Comentario;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase repositorio de especies
 *
 * @author
 */
public class RepComentario extends BaseDAO<Comentario> {

    private List<Comentario> comentarios = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Comentario> buscar() throws DAOException {
        return comentarios;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Comentario entidad) throws DAOException {
        comentarios.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Comentario entidad) throws DAOException {
        comentarios.get(id).setContenido(entidad.getContenido());
        comentarios.get(id).setFechaHora(entidad.getFechaHora());
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar consultar la base de datos
     */
    @Override
    public Comentario buscar(int id) throws DAOException {
        return comentarios.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Comentario entidad) throws DAOException {
        comentarios.remove(entidad);
    }

}
