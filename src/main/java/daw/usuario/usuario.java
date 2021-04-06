/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author Equipo
 */
@Entity()
public class Usuario implements Serializable {


   
    @Id
    private int id;
    
    private String Nombre;
    private String Apellidos;
    private String usuario;
    @Size(min = 8,max =20, message = "{La contraseña debe tener como mínimo 8 cáracteres y 20 como máximo}" )
    private String Contraseña;
    private String Sexo;
    private String Correo; 
    private String fnac;
    private String tarjeta;
    private String direccion;
    private int telef;

    
    public Usuario() {
       id=0;
    }

   
    public Usuario(int _id, String _Nombre,  String _Apellidos,String _Sexo, String _usuario, String _Contraseña, String _Correo , String _fnac,String _tarjeta, String _direccion, int _telef) {
        id= _id;
        Nombre = _Nombre;
        Apellidos = _Apellidos;
        usuario=_usuario;
        Contraseña = _Contraseña;
        Correo = _Correo;
        Sexo=_Sexo;
        fnac = _fnac;
        tarjeta= _tarjeta;
        direccion = _direccion;
        telef = _telef;
    }

    
    public Usuario(Usuario u) {
         id= u.id;
        Nombre = u.Nombre;
        Apellidos = u.Apellidos;
        usuario=u.usuario;
        Contraseña = u.Contraseña;
        Sexo= u.Sexo;
        Correo = u.Correo;
        fnac = u.fnac;
        tarjeta= u.tarjeta;
        direccion = u.direccion;
        telef = u.telef;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * @return the Correo
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     * @param Correo the Correo to set
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    /**
     * @return the fnac
     */
    public String getFnac() {
        return fnac;
    }

    /**
     * @param fnac the fnac to set
     */
    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    /**
     * @return the tarjeta
     */
    public String getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telef
     */
    public int getTelef() {
        return telef;
    }

    /**
     * @param telef the telef to set
     */
    public void setTelef(int telef) {
        this.telef = telef;
    }

    /**
     * @return the Sexo
     */
    public String getSexo() {
        return Sexo;
    }

    /**
     * @param Sexo the Sexo to set
     */
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
}