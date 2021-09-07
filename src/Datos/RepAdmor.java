package Datos;

import Blog.Admor;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepAdmor extends BaseDAO<Admor> {

    private List<Admor> admors = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Admor> buscar() throws DAOException {
        return admors;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Admor entidad) throws DAOException {
        admors.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Admor entidad) throws DAOException {
        admors.get(id).setAnclado(entidad.getAnclado());
        admors.get(id).setAvatar(entidad.getAvatar());
        admors.get(id).setCiudad(entidad.getCiudad());
        admors.get(id).setContrasena(entidad.getContrasena());
        admors.get(id).setCorreo(entidad.getCorreo());
        admors.get(id).setFechaNacimiento(entidad.getFechaNacimiento());
        admors.get(id).setGenero(entidad.getGenero());
        admors.get(id).setNombreCompleto(entidad.getNombreCompleto());
        admors.get(id).setTelefono(entidad.getTelefono());
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
    public Admor buscar(int id) throws DAOException {
        return admors.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Admor entidad) throws DAOException {
        admors.remove(entidad);
    }

}
