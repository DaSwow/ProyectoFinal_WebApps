/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author valdez
 */
public class Comun extends Post {

    private List<Comentario> comentarios;

    /**
     *
     */
    public Comun() {
    }

    /**
     *
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     */
    public Comun(Date fechaHoraCreacion, String titulo, String contenido) {
        super(fechaHoraCreacion, titulo, contenido);
    }

    /**
     *
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     * @param fechaHoraEdicion
     */
    public Comun(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    /**
     *
     * @param autor
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     * @param fechaHoraEdicion
     */
    public Comun(ObjectId autor, String nombreAutor, Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        super(autor, nombreAutor, fechaHoraCreacion, titulo, contenido, fechaHoraEdicion);
    }

    /**
     *
     * @return
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     *
     * @param comentarios
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     *
     * @return
     */
    @Override
    public Date getFechaHoraCreacion() {
        return super.getFechaHoraCreacion();
    }

    /**
     *
     * @param fechaHoraCreacion
     */
    @Override
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        super.setFechaHoraCreacion(fechaHoraCreacion);
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitulo() {
        return super.getTitulo();
    }

    /**
     *
     * @param titulo
     */
    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
    }

    /**
     *
     * @return
     */
    @Override
    public String getContenido() {
        return super.getContenido();
    }

    /**
     *
     * @param contenido
     */
    @Override
    public void setContenido(String contenido) {
        super.setContenido(contenido);
    }

    /**
     *
     * @return
     */
    @Override
    public Date getFechaHoraEdicion() {
        return super.getFechaHoraEdicion();
    }

    /**
     *
     * @param fechaHoraEdicion
     */
    @Override
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        super.setFechaHoraEdicion(fechaHoraEdicion);
    }

}
