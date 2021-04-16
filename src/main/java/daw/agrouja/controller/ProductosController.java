package daw.agrouja.controller;

import daw.agrouja.model.Producto;
import daw.agrouja.model.ProductoDao.ProductosDAO;
import daw.agrouja.qualifiers.DAOJpa;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("prodCtrl")
@ViewScoped
public class ProductosController implements Serializable {

    private final Logger log = Logger.getLogger(ProductosController.class.getName());
    @Inject
    @DAOJpa
    //@DAOMap
    private ProductosDAO productosDAO;
    private List<Producto> subProductos;
    private Producto producto;
    private List<Producto> productos;

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
        log.info("Recuperando producto: " + producto.getId());
        producto = productosDAO.buscaId(producto.getId());
    }

    public String visualiza(Integer id) {
        recupera(id);
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String edita() {
        recupera();
        return "editar?faces-redirect=true&id=" + producto.getId();
    }

    public String crea() {
        log.info("Creando producto: " + producto.getId());
        productosDAO.crea(producto);
        recupera(producto.getId());
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String borrar() {
        recupera();
        log.info("Borrando producto: " + producto.getId());
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
        log.info("Agregando comentario: " + producto.getComentario() + " al producto-" + producto.getId());
        productosDAO.agregarComent(producto, producto.getComentario());
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String buscarNombre() {
        if (producto.getBuscaNomb().contentEquals("")) {
            producto.setBuscaNomb("xxx");
        }
        log.info("Buscando producto que contiene: " + producto.getBuscaNomb());
        productosDAO.buscarNombre(producto.getBuscaNomb());
                subProductos = productosDAO.buscaTodosSub();
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

    public String buscarCategoria() {
        if (producto.getBuscaCat().contentEquals("")) {
            producto.setBuscaCat("xxx");
        }
        log.info("Buscando producto con categoria: " + producto.getBuscaCat());
        productosDAO.buscarCategoria(producto.getBuscaCat());
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

    public String buscarMarca() {
        if (producto.getBuscaMarca().contentEquals("") || producto.getBuscaMarca().contentEquals("Otra")) {
            producto.setBuscaMarca("xxx");
        }
        log.info("Buscando producto con marca: " + producto.getBuscaMarca());
        productosDAO.buscarMarca(producto.getBuscaMarca());
        System.out.println(subProductos.size());
        return "index?faces-redirect=true";
    }

}
