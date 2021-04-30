package daw.agrouja.controller;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.ComentarioDao.ComentarioDAO;
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

@Named("comentCtrl")
@ViewScoped
public class ComentarioController implements Serializable {

    private static final Logger log = Logger.getLogger(ProductosController.class.getName());
    @Inject
    @DAOJpa
    private ComentarioDAO comentariosDAO;
    @Inject
    private Principal principal;
    private Comentario comentario;
    private List<Comentario> comentarios;
    @Inject
    @DAOJpa
    private UsuarioDAO usu;
    @Inject
    @DAOJpa
    private ProductosDAO prod;

    /* INICIALIZADORES , GETTERS Y SETTERS */
    public ComentarioController() {
    }

    @PostConstruct
    public void init() {
        comentario = new Comentario();
        comentarios = comentariosDAO.buscaTodos();
    }

    public ComentarioDAO getComentariosDAO() {
        return comentariosDAO;
    }

    public void setComentariosDAO(ComentarioDAO comentariosDAO) {
        this.comentariosDAO = comentariosDAO;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /* METODOS PRINCIPALES */
    public void recupera() {
        log.log(Level.INFO, "Recuperando comentario: {0}", comentario.getId_comentario());
        comentario = comentariosDAO.buscaId(comentario.getId_comentario());
    }

//    public String edita() {
//        recupera();
//        log.log(Level.INFO, "Editando comentario: {0}", comentario.getId_comentario());
//        return "editar?faces-redirect=true&id=" + comentario.getId_comentario();
//    }
    public String crea(Producto p) {
        comentario.setId_usuario(usu.buscaPorNombre(principal.getName()).getId());
        comentario.setUsu(usu.buscaPorNombre(principal.getName()).getNickname());
        comentario.setNombreProd(p.getNombre());
        comentario.setId_producto(p.getId());
        p.getComentarios().add(comentario);
        comentariosDAO.crea(comentario);
        prod.agregarComent(p);
        return "visualizar?faces-redirect=true&id=" + comentario.getId_producto();
    }

}
