package Fabrica;

import Datos.*;
import Blog.Estado;
import java.util.List;

/**
 *
 *
 * @author
 */
public class ctlEstado {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Estado> buscar() {
        return datos.buscaEstado();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Estado entidad) {
        datos.guardarEstado(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Estado entidad) {
        datos.actualizarEstado(id, entidad);
    }

    /**
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Estado buscar(int id) {
        return datos.buscarEstado(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     */
    public void eliminar(Estado entidad) {
        datos.eliminarEstado(entidad);
    }

}
