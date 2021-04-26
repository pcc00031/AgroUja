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
    private String id_usuario = null;

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

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

}
