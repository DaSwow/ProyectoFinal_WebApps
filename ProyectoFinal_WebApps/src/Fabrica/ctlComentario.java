package Fabrica;

import Datos.*;
import Blog.Comentario;
import java.util.List;

/**
 *
 * @author
 */
public class ctlComentario {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Comentario> buscar() {
        return datos.buscaComentario();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Comentario entidad) {
        datos.guardarComentario(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Comentario entidad) {
        datos.actualizarComentario(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Comentario buscar(int id) {
        return datos.buscarComentario(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Comentario entidad) {
        datos.eliminarComentario(entidad);
    }

}
