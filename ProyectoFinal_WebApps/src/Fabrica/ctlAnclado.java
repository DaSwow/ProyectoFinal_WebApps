package Fabrica;

import Datos.*;
import Blog.Anclado;
import java.util.List;

/**
 *
 * @author
 */
public class ctlAnclado {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Anclado> buscar() {
        return datos.buscaAnclado();
    }

    /**
     *
     * @param entidad Recibe un nuevo animal con los datos a agregar a la base
     * de datos
     */
    public void guardar(Anclado entidad) {
        datos.guardarAnclado(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Anclado entidad) {
        datos.actualizarAnclado(id, entidad);
    }

    /**
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Anclado buscar(int id) {
        return datos.buscarAnclado(id);
    }

    /**
     *
     * @param entidad
     */
    public void eliminar(Anclado entidad) {
        datos.eliminarAnclado(entidad);
    }
}
