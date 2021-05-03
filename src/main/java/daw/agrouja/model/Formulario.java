/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author Carlos
 */
@Entity()
public class Formulario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min = 3, max = 50,
            message = "La longitud del email debe estar entre {min} y {max} caracteres")
    private String email = "";
    @Size(min = 2, max = 50,
            message = "La longitud del nombre debe estar entre {min} y {max} caracteres")
    private String nombre = "";
    @Size(min = 9, max = 9,
            message = "La longitud del telefono debe ser de {min} caracteres")
    private String telefono = "";
    private String pais = "";
    @Size(min = 2, max = 25,
            message = "La longitud del asunto debe estar entre {min} y {max} caracteres")
    private String asunto = "";
    @Size(min = 5, max = 500,
            message = "La longitud del mensaje debe estar entre {min} y {max} caracteres")
    private String mensaje = "";
    
    // Claves foraneas
    private Integer idUsuario = 0; 

    public Formulario(Integer id, String email, String nombre, String telefono, String pais,
            String asunto, String mensaje) {
        this.id=id;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pais = pais;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Formulario(Integer id) {
        this.id = id;
    }

    public Formulario(Formulario f) {
        this.id=f.id;
        this.email = f.email;
        this.nombre = f.nombre;
        this.telefono = f.telefono;
        this.pais = f.pais;
        this.asunto = f.asunto;
        this.mensaje = f.mensaje;
    }

    public Formulario() {
        this.id=0;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
