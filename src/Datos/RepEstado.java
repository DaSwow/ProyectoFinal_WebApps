package Datos;

import Blog.Estado;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepEstado extends BaseDAO<Estado> {

    private List<Estado> estados = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Estado> buscar() throws DAOException {
        return estados;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Estado entidad) throws DAOException {
        estados.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Estado entidad) throws DAOException {
        estados.get(id).setId(entidad.getId());
        estados.get(id).setMunicipio(entidad.getMunicipio());
        estados.get(id).setNombre(entidad.getNombre());
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
    public Estado buscar(int id) throws DAOException {
        return estados.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Estado entidad) throws DAOException {
        estados.remove(entidad);
    }

}
