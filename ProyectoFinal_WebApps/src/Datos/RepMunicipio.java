package Datos;

import Blog.Municipio;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepMunicipio extends BaseDAO<Municipio> {

    private List<Municipio> municipios = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Municipio> buscar() throws DAOException {
        return municipios;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Municipio entidad) throws DAOException {
        municipios.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Municipio entidad) throws DAOException {
        municipios.get(id).setId(entidad.getId());
        municipios.get(id).setNombre(entidad.getNombre());
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
    public Municipio buscar(int id) throws DAOException {
        return municipios.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Municipio entidad) throws DAOException {
        municipios.remove(entidad);
    }

}
