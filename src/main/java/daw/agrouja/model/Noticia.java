/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model;

/**
 *
 * @author Carlos
 */
public class Noticia {
    private String titulo="";
    private String mensaje="";
    private String fecha="";
    
    public Noticia(String titulo, String mensaje, String fecha) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Noticia(String titulo) {
        this.titulo = titulo;
    }

    public Noticia(Noticia n) { 
        this.titulo = n.titulo;
        this.mensaje = n.mensaje;
        this.fecha = n.fecha;
    }
    
    public Noticia() {
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
