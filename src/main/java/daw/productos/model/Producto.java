package daw.productos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author Pedro
 */
@Entity()
public class Producto implements Serializable {

//FIXME imagen
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, max = 25,
            message = "La longitud del nombre debe estar entre {min} y {max} caracteres")
    private String nombre;

    @Size(max = 250,
            message = "La descripción no debe ser superior a (max)")
    private String descripcion = "Sin descripción";

    @Size(min = 2, max = 10,
            message = "La longitud de la marca debe estar entre {min} y {max} caracteres")
    private String marca;

    private String imagen;

    private String estado; //> Nuevo / usado

    @Size(min = 2, max = 10,
            message = "La longitud de la categoría debe estar entre {min} y {max} caracteres")
    private String categoria;

    private String ventAlq; //> Venta / Alquiler
    private boolean destacado;

    private Integer rating = 0;
    private List<String> comentarios = null;

    @Positive(message = "El precio no puede ser negativo o cero")
    private double precio = 0;

    /* CONSTRUCTORES */
    /**
     * @brief Constructor por defecto
     */
    public Producto() {
        id = 0;
    }

    /**
     * @brief Constructor parametrizado
     * @param id
     * @param nombre
     * @param descripcion
     * @param marca
     * @param imagen
     * @param estado
     * @param categoria
     * @param ventAlq
     * @param destacado
     * @param precio
     */
    public Producto(Integer id, String nombre, String descripcion, String marca, String imagen, String estado, String categoria, String ventAlq, boolean destacado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.imagen = imagen;
        this.estado = estado;
        this.categoria = categoria;
        this.ventAlq = ventAlq;
        this.destacado = destacado;
        this.precio = precio;
        this.comentarios = new ArrayList<String>();
    }

    /**
     * @brief Constructor copia
     * @param p
     */
    public Producto(Producto p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.descripcion = p.descripcion;
        this.marca = p.marca;
        this.imagen = p.imagen;
        this.estado = p.estado;
        this.categoria = p.categoria;
        this.ventAlq = p.ventAlq;
        this.destacado = p.destacado;
        this.precio = p.precio;
        this.comentarios = p.comentarios;
        this.rating = p.rating;
    }

    /* GETTERS Y SETTERS */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVentAlq() {
        return ventAlq;
    }

    public void setVentAlq(String ventAlq) {
        this.ventAlq = ventAlq;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void addComent(String comentario) {
        this.comentarios.add(comentario);
    }

}
