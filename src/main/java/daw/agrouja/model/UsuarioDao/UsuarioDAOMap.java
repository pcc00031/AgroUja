/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

import daw.agrouja.UsuarioIdentityStore;
import daw.agrouja.model.Producto;
import daw.agrouja.qualifiers.DAOMap;
import daw.agrouja.model.Usuario;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Equipo
 */
@ApplicationScoped
@DAOMap

public class UsuarioDAOMap implements UsuarioDAO, Serializable {

    private final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());
    private String[] credentials = null;
    private EntityManager em;

    private Map<Integer, Usuario> Usuario = null;
    private int idUser = 1;
    private UsuarioIdentityStore credenciales;

    public UsuarioDAOMap() {
        if (Usuario == null) {
            Usuario = new HashMap<>();
        }
    }

    @Override
    public Usuario buscaId(int id) {
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
            Usuario nu = new Usuario(u);
            Usuario.replace(u.getId(), u);
            result = true;
        }
        return result;
    }

    @Override
    public void borra(Usuario u) {
        Usuario.remove(u.getId());
    }

    @Override
    public Usuario buscaPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscaProductos(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
