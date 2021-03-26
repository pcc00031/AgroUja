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

    private Map<Integer, Producto> productos = null;
    private Map<Integer, Producto> subProductos = null;
    private final boolean destacadoSi = true;
    private final boolean destacadoNo = false;
    private Integer idProducto = 1;

    public ProductosDAO() {
        if (productos == null) {
            productos = new HashMap<>();
            subProductos = new HashMap<>();
            productos.put(idProducto, new Producto(idProducto++, "Aceite", "El mejor aceite", "AgroUja", "aceite.png", "Nuevo", "Comestible", "Venta", destacadoSi, 10.4));
            productos.put(idProducto, new Producto(idProducto++, "Pala", "La mejor pala", "AgroUja", "pala.png", "Nuevo", "Herramienta", "Venta", destacadoNo, 5.7));
            productos.put(idProducto, new Producto(idProducto++, "Tractor", "El mejor tractor", "AgroUja", "tractor.png", "Nuevo", "Herramienta", "Venta", destacadoSi, 50000.7));
        }

    }

    public Producto buscaId(Integer id) {
        return new Producto(productos.get(id));
    }

    public List<Producto> buscaTodos() {
        return productos.values().stream().collect(Collectors.toList());
    }

    public List<Producto> buscaTodosSub() {
        return subProductos.values().stream().collect(Collectors.toList());
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

    public boolean edita(Producto p) {
        boolean result = false;
        if (productos.containsKey(p.getId())) {
            Producto nc = new Producto(p);
            productos.replace(p.getId(), p);
            result = true;
        }
        return result;
    }

    public boolean buscarNombre(String nombre) {
        subProductos.clear();
        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            if (entry.getValue().getNombre().toLowerCase().contains(nombre)) {
                subProductos.put(entry.getKey(), entry.getValue());
            }
        }
        return true;
    }

    public Map<Integer, Producto> getSubProductos() {
        return subProductos;
    }

}
