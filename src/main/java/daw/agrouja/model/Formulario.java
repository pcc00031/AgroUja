/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Carlos
 */
@Entity
public class Formulario {

    @Id
    private String email = "";
    private String nombre = "";
    private String telefono = "";
    private String pais = "";
    private String asunto = "";
    private String mensaje = "";
    
    // Claves foraneas
    private String idUsuario; 

    public Formulario(String email, String nombre, String telefono, String pais,
            String asunto, String mensaje) {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pais = pais;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Formulario(String email) {
        this.email = email;
    }

    public Formulario(Formulario f) {
        this.email = f.email;
        this.nombre = f.nombre;
        this.telefono = f.telefono;
        this.pais = f.pais;
        this.asunto = f.asunto;
        this.mensaje = f.mensaje;
    }

    public Formulario() {
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
