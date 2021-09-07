package Fabrica;

import Datos.*;
import Blog.Municipio;
import java.util.List;

/**
 *
 * @author
 */
public class ctlMunicipio {

    /**
     * Atributo instancia de la fachada de datos
     */
    private final iDatos datos = new FachadaDatos();

    /**
     *
     * @return Regresa todos los datos que se hayan encontrado en la base de
     * datos
     */
    public List<Municipio> buscar() {
        return datos.buscaMunicipio();
    }

    /**
     *
     * @param entidad
     */
    public void guardar(Municipio entidad) {
        datos.guardarMunicipio(entidad);
    }

    /**
     *
     * @param id
     * @param entidad
     */
    public void actualizar(int id, Municipio entidad) {
        datos.actualizarMunicipio(id, entidad);
    }

    /**
     * Realiza una consulta por ID en la base de datos
     *
     * @param id Recibe el ID de la entidad la cual se esta buscando en la base
     * de datos
     * @return Regresa la entidad encontrada con el mismo ID del parametro
     */
    public Municipio buscar(int id) {
        return datos.buscarMunicipio(id);
    }

    /**
     * Busca y elimina una entidad en la base de datos
     *
     * @param entidad
     */
    public void eliminar(Municipio entidad) {
        datos.eliminarMunicipio(entidad);
    }

}
