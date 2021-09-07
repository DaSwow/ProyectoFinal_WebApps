package Datos;

import Blog.Usuario;
import Exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class RepUsuario extends BaseDAO<Usuario> {

    private List<Usuario> usuarios = new ArrayList<>();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido recuperar los datos de la base de datos
     */
    @Override
    public List<Usuario> buscar() throws DAOException {
        return usuarios;
    }

    /**
     *
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se haya
     * podido insertar los datos a la base de datos
     */
    @Override
    public void guardar(Usuario entidad) throws DAOException {
        usuarios.add(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     * @throws DAOException Regresa una excepcion en caso de que no se hayan
     * podido actualizar los datos de la base de datos
     */
    @Override
    public void actualizar(int id, Usuario entidad) throws DAOException {
        usuarios.get(id).setAvatar(entidad.getAvatar());
        usuarios.get(id).setCiudad(entidad.getCiudad());
        usuarios.get(id).setContrasena(entidad.getContrasena());
        usuarios.get(id).setCorreo(entidad.getCorreo());
        usuarios.get(id).setFechaNacimiento(entidad.getFechaNacimiento());
        usuarios.get(id).setGenero(entidad.getGenero());
        usuarios.get(id).setNombreCompleto(entidad.getNombreCompleto());
        usuarios.get(id).setTelefono(entidad.getTelefono());
        usuarios.get(id).setComun(entidad.getComun());
        usuarios.get(id).setMunicipio(entidad.getMunicipio());
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
    public Usuario buscar(int id) throws DAOException {
        return usuarios.get(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @throws DAOException Regresa una excepcion en caso de que ocurriera un
     * error al intentar eliminar una entidad en la base de datos
     */
    @Override
    public void eliminar(Usuario entidad) throws DAOException {
        usuarios.remove(entidad);
    }

}
