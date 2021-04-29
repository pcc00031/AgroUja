package daw.agrouja.model.ProductoDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Producto;
import java.util.List;

public interface ProductosDAO {

    // Metodos de busqueda general
    public Producto buscaId(Integer id);

    public List<Producto> buscaTodos();

    public List<Producto> buscaTodosSub();

    // Metodos de edicion general
    public boolean crea(Producto p);

    public void borra(Producto p);

    public boolean edita(Producto p);

    public boolean agregarComent(Producto p);

    // Metodos de busqueda especifica
    public void buscarNombre(String nombre);

    public List<Producto> buscarMarca(String marca);

    public List<Producto> buscarCategoria(String categoria);

    public List<Producto> buscarEstado(String estado);

}
