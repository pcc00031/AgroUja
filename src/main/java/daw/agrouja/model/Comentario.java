package daw.agrouja.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_comentario;

    @Size(max = 250,
            message = "La descripción no debe ser superior a (max)")
    String descripcion = "";

    Integer id_cliente;
    Integer id_producto;

    /* CONSTRUCTORES */
    public Comentario() {
        id_comentario = 0;
    }

    public Comentario(Integer id_comentario, String descripcion, Integer id_cliente, Integer id_producto) {
        this.id_comentario = id_comentario;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.descripcion = descripcion;
    }

    public Comentario(Comentario com) {
        this.id_comentario = com.id_comentario;
        this.id_cliente = com.id_cliente;
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

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

}
