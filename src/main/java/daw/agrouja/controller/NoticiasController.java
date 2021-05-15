/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.controller;

import daw.agrouja.model.Noticia;
import daw.agrouja.model.NoticiasDAO.NoticiasDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */

@Named("ctrlNoticias")
@ViewScoped
public class NoticiasController implements Serializable{
    private final Logger logger = Logger.getLogger(NoticiasController.class.getName());
    
    @Inject 
    private NoticiasDAO noticiasDAO;
    
    @Inject
    FacesContext fc;
    //view-Model
    private Noticia noticia;
    
    List<Noticia> noticias;
    public NoticiasController(){}
    
    @PostConstruct
    private void init (){
        noticia=new Noticia();
        noticias=noticiasDAO.buscaTodos();
    }
    public Noticia getNoticia(){
        return noticia;
    }
    public void setNoticia(Noticia noticia){
        this.noticia=noticia;
    }
    public List<Noticia> getLibros(){
        logger.info("Buscando libros");
        return noticias;
    }
    
    public List<Noticia> getLibrosEnc(String titulo){
        noticias=noticiasDAO.busca(titulo);
        return noticias;
    }
    
    public String borra(String isbn){
        noticiasDAO.borra(isbn);
        return "index?faces-redirect=true&isbn=";
    }
    
    public String crea(){
        logger.info("Guardando libro");
        noticiasDAO.crea(noticia);
        return "detalle?faces-redirect=true&isbn="+noticia.getTitulo();
    }
    
}
