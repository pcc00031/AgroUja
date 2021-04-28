/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.controller;

import daw.agrouja.model.Producto;
import daw.agrouja.qualifiers.DAOJpa;
import daw.agrouja.model.Usuario;
import daw.agrouja.model.UsuarioDao.UsuarioDAO;
import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named(value = "usuarioCtrl")
@ViewScoped
public class UsuarioController implements Serializable {

    private static final Logger logger = Logger.getLogger(UsuarioController.class.getName());

    @Inject
    HttpServletRequest request;
    @Inject
    @DAOJpa
    private UsuarioDAO usuarioDao;
    @Inject
    private Principal principal;
    private Usuario Usuario;
    private List<Usuario> usuarios;

    public UsuarioController() {
    }

    @PostConstruct
    public void init() {
        Usuario = new Usuario();
        usuarios = usuarioDao.buscaTodos();
        //recupera2(1);
        //Usuario.setProductos(usuarioDao.buscaProductos(Usuario));
    }

    public List<Usuario> getUsuarios() {
        return usuarioDao.buscaTodos();
    }

    public void recupera() {
        logger.log(Level.INFO, "Recuperando Usuario: {0}", Usuario.getId());
        Usuario = usuarioDao.buscaId(Usuario.getId());
    }

    public void recupera2(Integer id) {
        Usuario = usuarioDao.buscaId(id);
    }

    public String muestra(int id) {
        recupera2(id);
        return "usuario/mostrar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String guarda() {
        usuarioDao.guarda(Usuario);
        return "mostrar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String edita() {
        recupera();
        return "editar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String crea() {
        usuarioDao.crea(Usuario);
        logger.log(Level.INFO, "Creando Usuario: {0}", Usuario.getId());

        return "usuario/mostrar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String borrar() {
        recupera();
        logger.log(Level.INFO, "Borrando Usuario: {0}", Usuario.getId());
        usuarioDao.borra(Usuario);
        return "/index?faces-redirect=true";
    }

    /**
     * @return the Usuario
     */
    public Usuario getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String logout() throws ServletException {
        request.logout();
        request.getSession().invalidate();
        return "/index?faces-redirect=true";
    }

    public Integer usuId(String usu) {
        Usuario = usuarioDao.buscaPorNombre(usu);
        return Usuario.getId();
    }

    public String usuNick(int usu) {
        Usuario = usuarioDao.buscaId(usu);
        return Usuario.getNickname();
    }

    public List<Producto> buscaProductos() {
        Usuario = usuarioDao.buscaPorNombre(principal.getName());
        return usuarioDao.buscaProductos(Usuario);
    }

    public List<Producto> buscaProdsFavs() {
        Usuario = usuarioDao.buscaPorNombre(principal.getName());
        return usuarioDao.buscaProductosFavs(Usuario);
    }

    public String usuAvatar(String u) {
        Usuario = usuarioDao.buscaPorNombre(u);
        return Usuario.getAvatar();
    }

    public void addFav(Producto p, String u) {
        Usuario = usuarioDao.buscaPorNombre(u);
        logger.log(Level.INFO, "A\u00f1adiendo a favoritos producto-{0} a: {1}", new Object[]{p.getId(), Usuario.getNickname()});
        Usuario.getProdsFavs().add(p);
        System.out.println(Usuario.getProdsFavs().size());
    }

}
