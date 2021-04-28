package daw.agrouja.model.ProductoDao;

import daw.agrouja.model.Producto;
import daw.agrouja.qualifiers.DAOJpa;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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

    private static final Logger logger = Logger.getLogger(ProductosDAOJpa.class.getName());

    @PersistenceContext(unitName = "agroPU")
    private EntityManager em;
    private final Map<Integer, Producto> subProductos = new HashMap<>();

    public ProductosDAOJpa() {

        //subProductos.put(1, new Producto(1, "Azada", "La mejor azada", "AgroUja", "azada.png", "Nuevo", "Maquinaria", "Venta", true, 50.7));
    }

    @Override
    public Producto buscaId(Integer id) {
        Producto p = null;
        try {
            p = em.find(Producto.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
    public List<Producto> buscaTodosSub() {
        return subProductos.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean crea(Producto p) {
        boolean creado = false;
        try {
            // em.createQuery("SELECT u.id, u. FROM Usuario u JOIN c.id p", Usuario.class).setParameter("p", p);
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
        boolean add = false;
        try {
            em.find(Producto.class, p.getId()).addComent(coment);
            add = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return add;
    }

    @Override
    public boolean edita(Producto p) {
        boolean editado = false;
        try {
            em.merge(p);
            editado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return editado;
    }

    @Override
    public void buscarNombre(String nombre) {//FIXME buscar por nombre
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarMarca(String marca) {//FIXME buscar por marca
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarCategoria(String categoria) {//FIXME buscar por categoria
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
