package Fabrica;

import Datos.*;
import Blog.Post;
import Exceptions.DAOException;
import java.util.List;

/**
 *
 * @author
 */
public class ctlPost {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Post> buscar() {
        return datos.buscaPost();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Post entidad) {
        datos.guardarPost(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Post entidad) {
        datos.actualizarPost(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Post buscar(int id) {
        return datos.buscarPost(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Post entidad) {
        datos.actualizarPost(0, entidad);
    }

}
