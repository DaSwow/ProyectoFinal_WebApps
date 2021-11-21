/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author valdez
 */
public class Comentario {

    private ObjectId id;
    private String autor;
    private ObjectId idPublicacion;
    private Date fechaHora;
    private String contenido;

    /**
     * 
     */
    public Comentario() {
    }

    
    /**
     * 
     * @param fechaHora
     * @param contenido 
     */
    public Comentario(ObjectId idPublicacion, String autor, Date fechaHora, String contenido) {
        this.idPublicacion=idPublicacion;
        this.autor=autor;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
    }

    public ObjectId getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(ObjectId idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    
    
    /**
     * 
     * @return 
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * 
     * @param fechaHora 
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    
    
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.fechaHora);
        hash = 71 * hash + Objects.hashCode(this.contenido);
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
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
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
        return "Comentario{" + "fechaHora=" + fechaHora + ", contenido=" + contenido + '}';
    }

}
