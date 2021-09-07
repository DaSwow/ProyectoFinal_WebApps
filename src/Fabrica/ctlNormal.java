package Fabrica;

import Datos.*;
import Blog.Normal;
import java.util.List;

/**
 *
 * @author
 */
public class ctlNormal {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Normal> buscar() {
        return datos.buscaNormal();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Normal entidad) {
        datos.guardarNormal(entidad);
    }

    /**
     *
     * @param id
     * @param entidad Recibe un animal con datos actualizados de un animal
     * existente en la base de datos
     */
    public void actualizar(int id, Normal entidad) {
        datos.actualizarNormal(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Normal buscar(int id) {
        return datos.buscarNormal(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Normal entidad) {
        datos.eliminarNormal(entidad);
    }

}
