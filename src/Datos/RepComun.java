package Datos;

import Blog.Comun;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepComun extends BaseDAO<Comun> {

    private List<Comun> comunes = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Comun> buscar() throws DAOException {
        return comunes;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Comun entidad) throws DAOException {
        comunes.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Comun entidad) throws DAOException {
        comunes.get(id).setComentario(entidad.getComentario());
        comunes.get(id).setContenido(entidad.getContenido());
        comunes.get(id).setFechaHoraCreacion(entidad.getFechaHoraCreacion());
        comunes.get(id).setFechaHoraEdicion(entidad.getFechaHoraEdicion());
        comunes.get(id).setTitulo(entidad.getTitulo());
        comunes.get(id).setUsuario(entidad.getUsuario());
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
    public Comun buscar(int id) throws DAOException {
        return comunes.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Comun entidad) throws DAOException {
        comunes.remove(entidad);
    }
}
