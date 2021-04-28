package daw.agrouja.model.ProductoDao;

import daw.agrouja.model.Producto;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DAOMap
public class ProductosDAOMap implements ProductosDAO, Serializable {

    private Map<Integer, Producto> productos = null;
    private Map<Integer, Producto> subProductos = null;
    private Integer idProducto = 1;

    public ProductosDAOMap() {
        productos = new HashMap<>();
        subProductos = new HashMap<>();
        if (productos == null) {
            productos.put(idProducto, new Producto(idProducto++, "Azada", "La mejor azada", "AgroUja", "azada.png", "Nuevo", "Maquinaria", "Venta", true, 50.7));
            productos.put(idProducto, new Producto(idProducto++, "Mejor aceite", "El mejor aceite del mundo", "AgroUja", "mejoraceite.jpg", "Nuevo", "Comestible", "Venta", true, 50.7));

        }
    }

    @Override
    public boolean agregarComent(Producto p, String coment) {
        System.out.println(p.getId());
        productos.get(p.getId()).addComent(coment);

        return true;
    }

    @Override
    public Producto buscaId(Integer id) {
        return new Producto(productos.get(id));
    }

    @Override
    public List<Producto> buscaTodos() {
        return productos.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscaTodosSub() {
        return subProductos.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Producto p) {
        Producto np = new Producto(p);
        np.setId(idProducto);
        productos.put(idProducto, np);
        p.setId(idProducto);
        idProducto++;
        return true;
    }

    @Override
    public void borra(Producto p) {
        productos.remove(p.getId());
    }

    @Override
    public boolean edita(Producto p) {
        boolean result = false;
        if (productos.containsKey(p.getId())) {
            productos.replace(p.getId(), p);
            result = true;
        }
        return result;
    }

    @Override
    public void buscarNombre(String nombre) {
        subProductos.clear();
        productos.entrySet().stream().filter(entry -> (entry.getValue().getNombre().toLowerCase().contains(nombre))).forEachOrdered(entry -> {
            subProductos.put(entry.getKey(), entry.getValue());
        });
       
    }

    @Override
    public void buscarMarca(String marca) {
        subProductos.clear();
        if (marca.contentEquals("Otra")) {
            productos.entrySet().stream().filter(entry -> (!entry.getValue().getMarca().contentEquals("AgroUja"))).forEachOrdered(entry -> {
                subProductos.put(entry.getKey(), entry.getValue());
            });
        } else {
            productos.entrySet().stream().filter(entry -> (entry.getValue().getMarca().contentEquals(marca))).forEachOrdered(entry -> {
                subProductos.put(entry.getKey(), entry.getValue());
            });
        }
    }

    @Override
    public void buscarCategoria(String categoria) {
        subProductos.clear();
        if (categoria.contentEquals("Otra")) {
            productos.entrySet().stream().filter(entry -> (!entry.getValue().getCategoria().contentEquals("Comestible") && !entry.getValue().getCategoria().contentEquals("Maquinaria"))).forEachOrdered(entry -> {
                subProductos.put(entry.getKey(), entry.getValue());
            });
        } else {
            productos.entrySet().stream().filter(entry -> (entry.getValue().getCategoria().contentEquals(categoria))).forEachOrdered(entry -> {
                subProductos.put(entry.getKey(), entry.getValue());
            });
        }
        
    }

}
