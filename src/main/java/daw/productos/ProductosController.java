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
    private List<Producto> subProductos;
    private Producto producto;
    private List<Producto> productos;
    private String busca;
    private String comentario;
    private String categoria;
    private String marca;
    private boolean mostrar = true;


    /* INICIALIZADOES , GETTERS Y SETTERS */
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

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public String getBusca() {
        return busca;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
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

    public String buscarNombre() {
        if (busca.contentEquals("")) {
            busca = "xxx";
        }
        log.info("Buscando producto que contiene: " + busca);
        productosDAO.buscarNombre(busca);
        setMostrar(false);
        System.out.println(mostrar);
        return "index?faces-redirect=true";
    }

    public String addComent() {
        recupera();
        log.info("Agregando comentario: " + comentario + " al producto-" + producto.getId());
        productosDAO.agregarComent(producto, comentario);
        return "visualizar?faces-redirect=true&id=" + producto.getId();
    }

    public String buscarCategoria() {
        if (categoria.contentEquals("")) {
            categoria = "xxx";
        }
        log.info("Buscando producto con categoria: " + categoria);
        productosDAO.buscarCategoria(categoria);
        mostrar = !mostrar;
        return "index?faces-redirect=true";
    }

    public String buscarMarca() {
        if (marca.contentEquals("")) {
            marca = "xxx";
        }
        log.info("Buscando producto con marca: " + marca);
        productosDAO.buscarMarca(marca);
        mostrar = !mostrar;
        return "index?faces-redirect=true";
    }

//  Metodo para ordenar
//    public void ordNombre() {
//        productos = productosDAO.ordenar();
//    }
}
