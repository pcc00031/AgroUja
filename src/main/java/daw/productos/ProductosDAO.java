package daw.productos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author Pedro
 */
@ApplicationScoped
public class ProductosDAO {

    private final Logger log = Logger.getLogger(ProductosDAO.class.getName());
    private Map<Integer, Producto> productos = null;
    private boolean destacadoSi = true;
    private boolean destacadoNo = false;
    private Integer idProducto = 1;

    public ProductosDAO() {
        if (productos == null) {
            productos = new HashMap<>();
            productos.put(idProducto, new Producto(idProducto++, "Aceite", "El mejor aceite", "AgroUja", "aceite.png", "Nuevo", "Comestible", "Venta", destacadoSi, 10.4));
            productos.put(idProducto, new Producto(idProducto++, "Pala", "La mejor pala", "AgroUja", "pala.png", "Nuevo", "Herramienta", "Venta", destacadoSi, 5.7));
            productos.put(idProducto, new Producto(idProducto++, "Tractor", "El mejor tractor", "AgroUja", "tractor.png", "Nuevo", "Herramienta", "Venta", destacadoSi, 50000.7));
        }
    }

    public Producto buscaId(Integer id) {
        return new Producto(productos.get(id));
    }

    public List<Producto> buscaTodos() {
        return productos.values().stream().collect(Collectors.toList());
    }

    public boolean crea(Producto p) {
        Producto np = new Producto(p);
        np.setId(idProducto);
        productos.put(idProducto, np);
        p.setId(idProducto);
        idProducto++;
        return true;
    }

    public void borra(Producto p) {
        productos.remove(p.getId());
    }
}
