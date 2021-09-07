/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author valdez
 */
public class Post {

    private Date fechaHoraCreacion;
    private String titulo;
    private String contenido;
    private Date fechaHoraEdicion;

    /**
     *
     */
    public Post() {
    }

    /**
     *
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     */
    public Post(Date fechaHoraCreacion, String titulo, String contenido) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    /**
     *
     * @param fechaHoraCreacion
     * @param titulo
     * @param contenido
     * @param fechaHoraEdicion
     */
    public Post(Date fechaHoraCreacion, String titulo, String contenido, Date fechaHoraEdicion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     *
     * @return
     */
    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     *
     * @param fechaHoraCreacion
     */
    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getContenido() {
        return contenido;
    }

    /**
     *
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     *
     * @return
     */
    public Date getFechaHoraEdicion() {
        return fechaHoraEdicion;
    }

    /**
     *
     * @param fechaHoraEdicion
     */
    public void setFechaHoraEdicion(Date fechaHoraEdicion) {
        this.fechaHoraEdicion = fechaHoraEdicion;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.fechaHoraCreacion);
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.contenido);
        hash = 59 * hash + Objects.hashCode(this.fechaHoraEdicion);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraCreacion, other.fechaHoraCreacion)) {
            return false;
        }
        if (!Objects.equals(this.fechaHoraEdicion, other.fechaHoraEdicion)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Post{" + "fechaHoraCreacion=" + fechaHoraCreacion + ", titulo=" + titulo + ", contenido=" + contenido + ", fechaHoraEdicion=" + fechaHoraEdicion + '}';
    }

}
