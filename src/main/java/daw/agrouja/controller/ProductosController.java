package daw.agrouja.controller;

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

@Named("prodCtrl")
@ViewScoped
public class ProductosController implements Serializable {

    private static final Logger log = Logger.getLogger(ProductosController.class.getName());
    @Inject
    @DAOJpa
    private ProductosDAO productosDAO;
    @Inject
    private Principal principal;
    private List<Producto> prodsEnc;
    private Producto producto;
    private List<Producto> productos;
    @Inject
    @DAOJpa
    private UsuarioDAO usu;

    /* INICIALIZADORES , GETTERS Y SETTERS */
    public ProductosController() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
        productos = productosDAO.buscaTodos();
        prodsEnc = productosDAO.buscaTodosSub();
    }

    public List<Producto> getProdsEnc() {
        return prodsEnc;
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
        return "/productos/visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String edita() {
        recupera();
        log.log(Level.INFO, "Editando producto: {0}", producto.getId());
        return "editar?faces-redirect=true&id=" + producto.getId();
    }

    public String crea() {
        producto.setIdUsuario(usu.buscaPorNombre(principal.getName()).getId());
        if (productosDAO.crea(producto)) {
            return "visualizar?faces-redirect=true&id=" + producto.getId();
        } else {
            return "/index";
        }
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

    public String buscarNombre() {
        if (producto.getBuscaNomb().contentEquals("")) {
            producto.setBuscaNomb("xxx");
        }
        log.log(Level.INFO, "Buscando producto que contiene: {0}", producto.getBuscaNomb());
        productosDAO.buscarNombre(producto.getBuscaNomb());
        return "index?faces-redirect";
    }

    public List<Producto> buscarCategoria() {
        if (producto.getBuscaCat().contentEquals("")) {
            producto.setBuscaCat("xxx");
        }
        log.log(Level.INFO, "Buscando producto con categoria: {0}", producto.getBuscaCat());
        return productosDAO.buscarCategoria(producto.getBuscaCat());
    }

    public List<Producto> buscarMarca() {
        if (producto.getBuscaMarca().contentEquals("") || producto.getBuscaMarca().contentEquals("Otra")) {
            producto.setBuscaMarca("xxx");
        }
        log.log(Level.INFO, "Buscando producto con marca: {0}", producto.getBuscaMarca());
        return productosDAO.buscarMarca(producto.getBuscaMarca());
    }

    public List<Producto> buscarEstado() {
        if (producto.getBuscaEst().contentEquals("")) {
            producto.setBuscaEst("xxx");
        } else {
        }
        log.log(Level.INFO, "Buscando producto en: {0}", producto.getBuscaEst());
        return productosDAO.buscarEstado(producto.getBuscaEst());
    }

    public String getUsu() {
        return usu.buscaId(producto.getIdUsuario()).getNickname();
    }
    //TODO Buscar por marca, estado, categoria
    //TODO Comprobar usuario para editar/borrar producto
//    public Boolean comprobarUsu{
//        return true;
//    }
}
