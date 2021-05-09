package daw.agrouja.model.ProductoDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Producto;
import daw.agrouja.model.Usuario;
import java.util.List;

public interface ProductosDAO {

    // Metodos de busqueda general
    public Producto buscaId(Integer id);

    public List<Producto> buscaTodos();

    // Metodos de edicion general
    public boolean crea(Producto p);

    public void borra(Producto p);

    public boolean edita(Producto p);

    // Metodos de busqueda especifica
    public List<Producto> buscarNombre(String nombre);

    public List<Producto> buscarMarca(String marca);

    public List<Producto> buscarCategoria(String categoria);

    public List<Producto> buscarEstado(String estado);

    public List<Producto> buscarPub(String pub);

    public Boolean comprobarUsu(Producto p, Usuario u);

    public Boolean comprobarFav(Producto p, Usuario u);

    public List<Comentario> buscaComents(Producto p);

}
