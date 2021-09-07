package Fabrica;

import Datos.*;
import Blog.Admor;
import java.util.List;

/**
 *
 *
 * @author
 */
public class ctlAdmor {

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
    public List<Admor> buscar() {
        return datos.buscaAdmor();
    }

    /**
     *
     *
     * @param entidad
     */
    public void guardar(Admor entidad) {
        datos.guardarAdmor(entidad);
    }

    /**
     *
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Admor entidad) {
        datos.actualizarAdmor(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Admor buscar(int id) {
        return datos.buscarAdmor(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Admor entidad) {
        datos.eliminarAdmor(entidad);
    }

}
