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
public class Normal extends Usuario {

    /**
     *
     */
    public Normal() {
    }

    /**
     * 
     * @param nombreCompleto
     * @param correo
     * @param contrasena
     * @param telefono
     * @param ciudad
     * @param fechaNacimiento
     * @param genero 
     * @param avatar
     */
    public Normal(String nombreCompleto, String correo, String contrasena, String telefono, String ciudad, Date fechaNacimiento, String genero, byte[] avatar) {
        super(nombreCompleto, correo, contrasena, telefono, ciudad, fechaNacimiento, genero, avatar);
    }

    /**
     *
     * @return
     */
    @Override
    public String getNombreCompleto() {
        return super.getNombreCompleto();
    }

    /**
     *
     * @param nombreCompleto
     */
    @Override
    public void setNombreCompleto(String nombreCompleto) {
        super.setNombreCompleto(nombreCompleto);
    }

    /**
     *
     * @return
     */
    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    /**
     *
     * @param correo
     */
    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    /**
     *
     * @return
     */
    @Override
    public String getContrasena() {
        return super.getContrasena();
    }

    /**
     *
     * @param contrasena
     */
    @Override
    public void setContrasena(String contrasena) {
        super.setContrasena(contrasena);
    }

    /**
     *
     * @return
     */
    @Override
    public String getTelefono() {
        return super.getTelefono();
    }

    /**
     *
     * @param telefono
     */
    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono);
    }

    /**
     *
     * @return
     */
    @Override
    public byte[] getAvatar() {
        return super.getAvatar();
    }

    /**
     *
     * @param avatar
     */
    @Override
    public void setAvatar(byte[] avatar) {
        super.setAvatar(avatar);
    }

    /**
     *
     * @return
     */
    @Override
    public String getCiudad() {
        return super.getCiudad();
    }

    /**
     *
     * @param ciudad
     */
    @Override
    public void setCiudad(String ciudad) {
        super.setCiudad(ciudad);
    }

    /**
     *
     * @return
     */
    @Override
    public Date getFechaNacimiento() {
        return super.getFechaNacimiento();
    }

    /**
     *
     * @param fechaNacimiento
     */
    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        super.setFechaNacimiento(fechaNacimiento);
    }

    /**
     *
     * @return
     */
    @Override
    public String getGenero() {
        return super.getGenero();
    }

    /**
     *
     * @param genero
     */
    @Override
    public void setGenero(String genero) {
        super.setGenero(genero);
    }

    
}
