/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

/**
 *
 * @author Equipo
 */
import daw.agrouja.model.Comentario;
import daw.agrouja.model.Formulario;
import daw.agrouja.model.Producto;
import daw.agrouja.model.Usuario;
import java.util.List;

public interface UsuarioDAO {

    public Usuario buscaId(Integer id);

    public List<Usuario> buscaTodos();

    public boolean crea(Usuario u);

    public boolean borra(Integer id);

    public boolean guarda(Usuario u);
    
    public Usuario buscaPorNombre(String nombre);

    public List<Producto> buscaProductos(Usuario u);

    public List<Producto> buscaProductosFavs(Usuario u);

    public List<Comentario> buscaComentarios(Usuario u);
    
    public List<Formulario> buscaFormularios(Usuario u);
    
    public void addFav(Usuario u);

}
