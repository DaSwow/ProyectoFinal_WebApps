/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Objects;
import javax.imageio.ImageIO;
import org.bson.types.ObjectId;

/**
 *
 * @author valdez
 */
public class Usuario {

    private ObjectId id;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private byte[] avatar;
    private String ciudad;
    private Date fechaNacimiento;
    private String genero;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param nombreCompleto
     * @param correo
     * @param contrasena
     * @param telefono
     * @param avatar
     * @param ciudad
     * @param fechaNacimiento
     * @param genero
     */
    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, String ciudad, Date fechaNacimiento, String genero, byte[] avatar) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.avatar = avatar;
    }

    /**
     *
     * @return
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     *
     * @param nombreCompleto
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public byte[] getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     */
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

//    /**
//     * 
//     * @return 
//     */
//    public Municipio getMunicipio() {
//        return municipio;
//    }
//
//    /**
//     * 
//     * @param municipio 
//     */
//    public void setMunicipio(Municipio municipio) {
//        this.municipio = municipio;
//    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
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
        return "Usuario{" + "nombreCompleto=" + nombreCompleto + ", correo=" + correo + ", contrasena=" + contrasena + ", telefono=" + telefono + ", avatar=" + avatar + ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + '}';
    }


    
}
