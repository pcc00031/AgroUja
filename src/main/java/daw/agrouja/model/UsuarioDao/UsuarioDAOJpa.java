/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Formulario;
import daw.agrouja.model.Producto;
import daw.agrouja.model.Usuario;
import daw.agrouja.qualifiers.DAOJpa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@RequestScoped
@DAOJpa
@Transactional

public class UsuarioDAOJpa implements UsuarioDAO, Serializable {

    private static final Logger logger = Logger.getLogger(UsuarioDAOJpa.class.getName());

    @PersistenceContext
    private EntityManager em;

    public UsuarioDAOJpa() {
    }

    @Override
    public Usuario buscaId(Integer id) {
        Usuario u = null;
        try {
            u = em.find(Usuario.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }

    @Override
    public List<Usuario> buscaTodos() {
        List<Usuario> lu = null;
        try {
            Query q = em.createQuery("Select u from Usuario u", Usuario.class);
            lu = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lu;
    }

    @Override
    public boolean crea(Usuario u) {
        boolean creado = false;
        try {
            em.persist(u);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public boolean borra(Integer id) {
        boolean borrado = false;
        List<Producto> lp;
        try {
            Usuario u = null;
            u = em.find(Usuario.class, id);
            Query q = em.createQuery("Select p from Usuario u, Producto p where u.id=:idu AND p.idUsuario=:idu", Producto.class);
            q.setParameter("idu", id);
            lp = q.getResultList();
            for (int i = 0; i < lp.size(); i++) {
                em.remove(lp.get(i));
            }
            em.remove(u);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

    @Override
    public boolean guarda(Usuario u) {
        boolean guardado = false;
        try {
            System.out.println(u.getNombre());
            em.merge(u);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return guardado;
    }

    @Override
    public Usuario buscaPorNombre(String nombre) {
        Usuario u = null;
        try {
            Query q = em.createQuery("Select u from Usuario u where u.nickname=:nombre", Usuario.class).setParameter("nombre", nombre);
            u = (Usuario) q.getSingleResult();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return u;
    }

    @Override
    public List<Producto> buscaProductos(Usuario u) {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p, Usuario us where p.idUsuario=:u AND p.idUsuario=us.id", Producto.class).setParameter("u", u.getId());
            if (q.getResultList() != null) {
                lp = q.getResultList();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public List<Producto> buscaProductosFavs(Usuario u) {
        List<Producto> lc = new ArrayList<>();
        try {
            Query q = em.createQuery("Select p from Producto p, Usuario u, Favorito f where f.id_usuario=:uid AND f.id_usuario=u.id AND f.id_producto=p.id", 
                    Producto.class);
            q.setParameter("uid", u.getId());
            lc = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

    @Override
    public List<Formulario> buscaFormularios(Usuario u) {
        List<Formulario> lf = null;
        try {
            Query q = em.createQuery("Select f from Formulario f, Usuario usu where f.idUsuario=:u AND f.idUsuario=usu.id", Producto.class).setParameter("u", u.getId());
            if (q.getResultList() != null) {
                lf = q.getResultList();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lf;
    }

    @Override
    public void addFav(Usuario u) {
        try {
            em.merge(u);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public List<Comentario> buscaComentarios(Usuario u) {
        List<Comentario> lc = null;
        try {
            Query q = em.createQuery("Select c from Comentario c, Usuario us where c.id_usuario=:u AND c.id_usuario=us.id", Comentario.class).setParameter("u", u.getId());
            if (q.getResultList() != null) {
                lc = q.getResultList();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lc;
    }

}
