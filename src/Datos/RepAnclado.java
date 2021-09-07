package Datos;

import Blog.Anclado;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepAnclado extends BaseDAO<Anclado> {

    private List<Anclado> anclados = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Anclado> buscar() throws DAOException {
        return anclados;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Anclado entidad) throws DAOException {
        anclados.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Anclado entidad) throws DAOException {
        anclados.get(id).setContenido(entidad.getContenido());
        anclados.get(id).setFechaHoraCreacion(entidad.getFechaHoraCreacion());
        anclados.get(id).setFechaHoraEdicion(entidad.getFechaHoraEdicion());
        anclados.get(id).setTitulo(entidad.getTitulo());
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
    public Anclado buscar(int id) throws DAOException {
        return anclados.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Anclado entidad) throws DAOException {
        anclados.remove(entidad);
    }
}
