package daw.productos.model.dao;

import daw.productos.model.Producto;
import java.util.List;
import java.util.Map;

public interface ProductosDAO {

    public boolean agregarComent(Producto p, String coment);

    public Producto buscaId(Integer id);

    public List<Producto> buscaTodos();

    public List<Producto> buscaTodosSub();

    public boolean crea(Producto p);

    public void borra(Producto p);

    public boolean edita(Producto p);

    public boolean buscarNombre(String nombre);

    public Map<Integer, Producto> getSubProductos();

    public boolean buscarMarca(String marca);

    public boolean buscarCategoria(String categoria);

// Metodo para ordenar
//    public List<Producto> ordenar();
}
