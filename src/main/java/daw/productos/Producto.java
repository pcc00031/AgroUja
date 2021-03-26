package daw.productos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * @author Pedro
 */
@Entity()
public class Producto implements Serializable {

//TODO imagen
//TODO agregar mas productos
//TODO buscar por categori
//TODO buscar por marca
//TODO comparar producto
    
    @Id
    private Integer id;

    @Size(min = 2, max = 25,
            message = "La longitud del nombre debe estar entre {min} y {max} caracteres")
    private String nombre;

    @Size(max = 250,
            message = "La descripción no debe ser superior a (max)")
    private String descripcion = "Sin descripción";
    private String marca;
    private String imagen;
    private String estado; //> Nuevo / usado
    private String categoria;
    private String ventAlq; //> Venta / Alquiler
    private boolean destacado;

    @Min(0)
    @Positive(message = "El precio no puede ser negativo")
    private double precio;

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

}
