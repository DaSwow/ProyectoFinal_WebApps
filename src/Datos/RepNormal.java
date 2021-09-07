package Datos;

import Blog.Normal;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class RepNormal extends BaseDAO<Normal> {

    private List<Normal> normales = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Normal> buscar() throws DAOException {
        return normales;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Normal entidad) throws DAOException {
        normales.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Normal entidad) throws DAOException {
        normales.get(id).setAvatar(entidad.getAvatar());
        normales.get(id).setCiudad(entidad.getCiudad());
        normales.get(id).setComentario(entidad.getComentario());
        normales.get(id).setContrasena(entidad.getContrasena());
        normales.get(id).setCorreo(entidad.getCorreo());
        normales.get(id).setFechaNacimiento(entidad.getFechaNacimiento());
        normales.get(id).setGenero(entidad.getGenero());
        normales.get(id).setNombreCompleto(entidad.getNombreCompleto());
        normales.get(id).setTelefono(entidad.getTelefono());
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
    public Normal buscar(int id) throws DAOException {
        return normales.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Normal entidad) throws DAOException {
        normales.remove(entidad);
    }

}
