/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author valdez
 */
public class Municipio {

    private ObjectId id;
    private String nombre;

    /**
     *
     */
    public Municipio() {
    }

    /**
     *
     * @param id
     * @param nombre
     */
    public Municipio(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nombre);
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
        final Municipio other = (Municipio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
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
        return "Municipio{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
