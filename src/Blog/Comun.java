/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Date;
import java.util.List;

/**
 *
 * @author valdez
 */
public class Comun extends Post {

    private Usuario usuario;
    private List<Comentario> comentario;

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * 
     * @return 
     */
    public List<Comentario> getComentario() {
        return comentario;
    }

    /**
     * 
     * @param comentario 
     */
    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
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
