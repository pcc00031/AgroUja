/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Formulario;
import daw.agrouja.model.Producto;
import daw.agrouja.qualifiers.DAOMap;
import daw.agrouja.model.Usuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Equipo
 */
@ApplicationScoped
@DAOMap

public class UsuarioDAOMap implements UsuarioDAO, Serializable {

    private Map<Integer, Usuario> Usuario = null;
    private int idUser = 1;

    public UsuarioDAOMap() {
        if (Usuario == null) {
            Usuario = new HashMap<>();
        }
    }

    @Override
    public Usuario buscaId(Integer id) {
        return new Usuario(Usuario.get(id));
    }

    @Override
    public List<Usuario> buscaTodos() {
        return Usuario.values().stream().collect(Collectors.toList());
    }

    /**
     * Sample nativeQuery metho
     *
     * @param u
     * @return
     */
    @Override
    public boolean crea(Usuario u) {
        Usuario nu = new Usuario(u);
        nu.setId(idUser);
        Usuario.put(idUser, nu);
        u.setId(idUser);
        idUser++;
        return true;
    }

    @Override
    public boolean guarda(Usuario u) {
        boolean result = false;
        if (Usuario.containsKey(u.getId())) {
            Usuario.replace(u.getId(), u);
            result = true;
        }
        return result;
    }
    
   
@Override
    public boolean borra(Integer id) {
        boolean result=false;
        if (Usuario.containsKey(id)) {
            Usuario.remove(id);
            result = true;
        }
        return result;
    }
    

    @Override
    public Usuario buscaPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscaProductos(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscaProductosFavs(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formulario> buscaFormularios(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFav(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> buscaComentarios(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
