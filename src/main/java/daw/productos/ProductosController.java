package daw.productos;

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
    private ProductosDAO productosDAO;
    private Producto producto;
    private List<Producto> productos;

    /* INICIALIZADOES , GETTERS Y SETTERS */
    public ProductosController() {
    }

    @PostConstruct
    public void init() {
        producto = new Producto();
        productos = productosDAO.buscaTodos();
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
    
    public String editar(){
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
        return "index?faces-redirect";
    }

    public void recupera(Integer id) {
        log.info("Recuperando producto: " + producto.getId());
        producto = productosDAO.buscaId(id);
    }

}
