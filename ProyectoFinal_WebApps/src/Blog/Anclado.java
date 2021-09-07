/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Date;

/**
 *
 * @author valdez
 */
public class Anclado extends Post {

    /**
     *
     */
    public Anclado() {
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
