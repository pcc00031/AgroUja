package daw.agrouja.model.ComentarioDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.qualifiers.DAOJpa;
import java.io.Serializable;
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
public class ComentarioDAOJpa implements ComentarioDAO, Serializable {

    private static final Logger logger = Logger.getLogger(ComentarioDAOJpa.class.getName());

    @PersistenceContext(unitName = "agroPU")
    private EntityManager em;

    public ComentarioDAOJpa() {
    }

    @Override
    public Comentario buscaId(Integer id) {
        Comentario c = null;
        try {
            c = em.find(Comentario.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return c;
    }

    @Override
    public List<Comentario> buscaTodos() {
        List<Comentario> lp = null;
        try {
            Query q = em.createQuery("Select c from Comentario c", Comentario.class);
            lp = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lp;
    }

    @Override
    public boolean crea(Comentario c) {
        boolean creado = false;
        try {
            em.persist(c);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

}
