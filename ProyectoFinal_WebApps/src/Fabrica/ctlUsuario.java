package Fabrica;

import Datos.*;
import Blog.Usuario;
import java.util.List;

/**
 *
 * @author
 */
public class ctlUsuario {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Usuario> buscar() {
        return datos.buscaUsuario();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Usuario entidad) {
        datos.guardarUsuario(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Usuario entidad) {
        datos.actualizarUsuario(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Usuario buscar(int id) {
        return datos.buscarUsuario(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Usuario entidad) {
        datos.eliminarUsuario(entidad);
    }

}
