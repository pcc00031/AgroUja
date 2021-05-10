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

/**
 *
 * @author Equipo
 */

@Entity
public class Favorito implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Favorito;
    
   
    // Claves foraneas
    private Integer id_usuario = 0;
    private Integer id_producto = 0;

    
    
     public Favorito() {
        this.id_Favorito = 0;
    }

   
    public Favorito (Favorito Fav) {
        this.id_Favorito = Fav.id_Favorito;
        this.id_usuario = Fav.id_usuario;
        this.id_producto= Fav.id_producto;

    }
    
    
    /**
     * @return the id_Favorito
     */
    public Integer getId_Favorito() {
        return id_Favorito;
    }

    /**
     * @param id_Favorito the id_Favorito to set
     */
    public void setId_Favorito(Integer id_Favorito) {
        this.id_Favorito = id_Favorito;
    }

    /**
     * @return the usu
     */
    

    /**
     * @return the nombreProd
     */
    

    /**
     * @return the id_usuario
     */
    public Integer getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_producto
     */
    public Integer getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }
    
}
