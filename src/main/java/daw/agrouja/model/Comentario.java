package daw.agrouja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comentario;

    @Size(max = 250,
            message = "La descripción no debe ser superior a (max)")
    private String descripcion = "";
    private String usu = "";
    private String nombreProd = "";
    // Claves foraneas
    private Integer id_usuario = 0;
    private Integer id_producto = 0;

    /* CONSTRUCTORES */
    public Comentario() {
        id_comentario = 0;
    }

    public Comentario(String desc) {
        this.descripcion = desc;
    }

    public Comentario(Comentario com) {
        this.id_comentario = com.id_comentario;
        this.id_usuario = com.id_usuario;

        this.descripcion = com.descripcion;
    }

    /* GETTERS Y SETTERS */
    public Integer getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Integer id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

}
