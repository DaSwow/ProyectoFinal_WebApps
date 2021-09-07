package Datos;

import Exceptions.DAOException;
import java.util.List;

/**
 *
 * @param <T>
 */
public abstract class BaseDAO<T> {

    /**
     * Realiza una consulta en la base de datos
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    public abstract List<T> buscar() throws DAOException;

    /**
     * Inserta nuevos datos en la base de datos
     *
     * @param entidad Recibe una entidad con los datos a agregar a la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    public abstract void guardar(T entidad) throws DAOException;

    /**
     * Actualiza los datos de una entidad existente en la base de datos
     *
     * @param id
     * @param entidad Recibe una entidad con datos actualizados de una entidad
     * existente en la base de datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    public abstract void actualizar(int id, T entidad) throws DAOException;

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar consultar la base de datos
     */
    public abstract T buscar(int id) throws DAOException;

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    public abstract void eliminar(T entidad) throws DAOException;

}
