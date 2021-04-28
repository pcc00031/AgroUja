package daw.agrouja.controller;

import daw.agrouja.model.Producto;
import daw.agrouja.model.ProductoDao.ProductosDAO;
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

@Named("prodCtrl")
@ViewScoped
public class ProductosController implements Serializable {

    private static final Logger log = Logger.getLogger(ProductosController.class.getName());
    @Inject
    @DAOJpa
    private ProductosDAO productosDAO;
    @Inject
    private Principal principal;
    private List<Producto> subProductos;
    private Producto producto;
    private List<Producto> productos;
    private UsuarioController usu;

    /* INICIALIZADORES , GETTERS Y SETTERS */
    public ProductosController() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
        productos = productosDAO.buscaTodos();
        subProductos = productosDAO.buscaTodosSub();
    }

    public List<Producto> getSubProductos() {
        return subProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public List<Producto> getProductos() {
        return productosDAO.buscaTodos();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /* METODOS PRINCIPALES */
    public void recupera() {
        log.log(Level.INFO, "Recuperando producto: {0}", producto.getId());
        producto = productosDAO.buscaId(producto.getId());
    }

    public String visualiza(Integer id) {
        recupera(id);
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String edita() {
        recupera();
        log.log(Level.INFO, "Editando producto: {0}", producto.getId());
        return "editar?faces-redirect=true&id=" + producto.getId();
    }

    public String crea() {        
        log.log(Level.INFO, "Creando producto: {0}", producto.getId());
        productosDAO.crea(producto);
        //producto.setIdUsuario(usu.usuId(principal.getName()));
  
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String borrar() {
        recupera();
        log.log(Level.INFO, "Borrando producto: {0}", producto.getId());
        productosDAO.borra(producto);
        return "index?faces-redirect=true";
    }

    public void recupera(Integer id) {
//        log.info("Recuperando producto: " + producto.getId());
        producto = productosDAO.buscaId(id);
    }

    public String editar() {
        productosDAO.edita(producto);
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String addComent() {
        log.log(Level.INFO, "Agregando comentario: {0} al producto-{1}", new Object[]{producto.getComentario(), producto.getId()});
        productosDAO.agregarComent(producto, producto.getComentario());
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String buscarNombre() {
        if (producto.getBuscaNomb().contentEquals("")) {
            producto.setBuscaNomb("xxx");
        }
        log.log(Level.INFO, "Buscando producto que contiene: {0}", producto.getBuscaNomb());
        productosDAO.buscarNombre(producto.getBuscaNomb());
        subProductos = productosDAO.buscaTodosSub();
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

    public String buscarCategoria() {
        if (producto.getBuscaCat().contentEquals("")) {
            producto.setBuscaCat("xxx");
        }
        log.log(Level.INFO, "Buscando producto con categoria: {0}", producto.getBuscaCat());
        productosDAO.buscarCategoria(producto.getBuscaCat());
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

    public String buscarMarca() {
        if (producto.getBuscaMarca().contentEquals("") || producto.getBuscaMarca().contentEquals("Otra")) {
            producto.setBuscaMarca("xxx");
        }
        log.log(Level.INFO, "Buscando producto con marca: {0}", producto.getBuscaMarca());
        productosDAO.buscarMarca(producto.getBuscaMarca());
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

    /* public boolean equivalente(String user) {
        boolean equiv = false;
//        Usuario u = usuarioDAO.buscaId(producto.getId());
        if (u.getNickname().equals(user)) {
            equiv = true;
            return equiv;
        } else {
            return equiv;
        }
    }*/
    
    public Integer getUsu(){
        return usu.usuId("pcc00031");
    }
}
