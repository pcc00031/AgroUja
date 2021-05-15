/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.controller;


import daw.agrouja.model.Favorito;
import daw.agrouja.model.FavoritoDao.FavoritoDAO;
import daw.agrouja.model.Producto;
import daw.agrouja.model.ProductoDao.ProductosDAO;
import daw.agrouja.model.UsuarioDao.UsuarioDAO;
import daw.agrouja.qualifiers.DAOJpa;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Equipo
 */
@Named("favCtrl")
@ViewScoped
public class FavoritoController implements Serializable{
    
    private static final Logger log = Logger.getLogger(ProductosController.class.getName());
    @Inject
    @DAOJpa
    private FavoritoDAO favoritosDAO;
    @Inject
    private Principal principal;
    private Favorito favorito;
    private List<Favorito> favoritos;
    @Inject
    @DAOJpa
    private UsuarioDAO usu;
    @Inject
    @DAOJpa
    private ProductosDAO prod;
    
    
    public FavoritoController(){
        
    }
    
    @PostConstruct
    public void init() {
        setFavorito(new Favorito());
        setFavoritos(getFavoritosDAO().buscaTodos());
    }

    /**
     * @return the favoritosDAO
     */
    public FavoritoDAO getFavoritosDAO() {
        return favoritosDAO;
    }

    /**
     * @param favoritosDAO the favoritosDAO to set
     */
    public void setFavoritosDAO(FavoritoDAO favoritosDAO) {
        this.favoritosDAO = favoritosDAO;
    }

    /**
     * @return the favorito
     */
    public Favorito getFavorito() {
        return favorito;
    }

    /**
     * @param favorito the favorito to set
     */
    public void setFavorito(Favorito favorito) {
        this.favorito = favorito;
    }

    /**
     * @return the favoritos
     */
    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    /**
     * @param favoritos the favoritos to set
     */
    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }
    
    
     public void recupera() {
        log.log(Level.INFO, "Recuperando Producto Favorito: {0}", favorito.getId_Favorito());
        favorito = favoritosDAO.buscaId(favorito.getId_Favorito());
    }

    public void recupera(Integer id) {
        log.log(Level.INFO, "Recuperando comentario ... ");
        favorito = favoritosDAO.buscaId(id);
    }


    public String anade(Producto p) {
        log.log(Level.INFO, "Anadiendo producto favorito: {0}", favorito.getId_Favorito());
        favorito.setId_usuario(usu.buscaPorNombre(principal.getName()).getId());
        favorito.setId_producto(p.getId());
        favoritosDAO.anade(favorito);
        return "visualizar?faces-redirect=true&id=" + favorito.getId_producto();
    }

    public String borrar(Integer id) {
        log.log(Level.INFO, "Eliminando producto de favoritos: {0}", favorito.getId_Favorito());
        favoritosDAO.borra(id,usu.buscaPorNombre(principal.getName()).getId());
        return "/productos/visualizar?faces-redirect=true&id=" + id;
    }
    
   public Boolean comprobarUsufav(Producto p) {
       
       return (favoritosDAO.comprobarUsufav(usu.buscaPorNombre(principal.getName()),p));
    }
    
}
