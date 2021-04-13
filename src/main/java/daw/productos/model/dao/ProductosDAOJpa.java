package daw.productos.model.dao;

import daw.productos.model.Producto;
import daw.productos.qualifiers.DAOJpa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ProductosDAOJpa
        implements ProductosDAO, Serializable {

    private final Logger logger = Logger.getLogger(ProductosDAOJpa.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ProductosDAOJpa() {
    }

    @Override
    public Producto buscaId(Integer id) {
        Producto p = null;
        try {
            p = em.find(Producto.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        };
        return p;
    }

    @Override
    public List<Producto> buscaTodos() {
        List<Producto> lp = null;
        try {
            Query q = em.createQuery("Select p from Producto p", Producto.class);
            lp = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public boolean crea(Producto p) {
        boolean creado = false;
        try {
            em.persist(p);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    @Override
    public void borra(Producto p) {
        try {
            p = em.find(Producto.class, p.getId());
            em.remove(p);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public boolean agregarComent(Producto p, String coment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> buscaTodosSub() {
        List<Producto> lsp = null;
        return lsp;
    }

    @Override
    public boolean edita(Producto p) { //FIXME
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarNombre(String nombre) {//FIXME
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Integer, Producto> getSubProductos() {//FIXME
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarMarca(String marca) {//FIXME
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarCategoria(String categoria) {//FIXME
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
