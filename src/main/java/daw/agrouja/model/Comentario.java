package daw.agrouja.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comentario;

    @Size(max = 250,
            message = "La descripción no debe ser superior a (max)")
    private String descripcion = "";

    // Claves foraneas
    private Usuario id_usuario = null;
    private Producto id_producto = null;

    /* CONSTRUCTORES */
    public Comentario() {
        id_comentario = 0;
    }

    public Comentario(String desc, Integer id_comentario, Usuario id_usuario, Producto id_producto) {
        this.descripcion = desc;
        this.id_comentario = id_comentario;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Comentario(Comentario com) {
        this.id_comentario = com.id_comentario;
        this.id_usuario = com.id_usuario;
        this.id_producto = com.id_producto;
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

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

}
