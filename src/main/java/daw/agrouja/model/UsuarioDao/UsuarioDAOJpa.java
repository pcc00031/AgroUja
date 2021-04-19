/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;


import daw.agrouja.model.Usuario;
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

public class UsuarioDAOJpa implements UsuarioDAO, Serializable {
        
   

    private final Logger logger = Logger.getLogger(UsuarioDAOJpa.class.getName());

    @PersistenceContext
    private EntityManager em;

    public UsuarioDAOJpa() {
    }

    @Override
    public Usuario buscaId(int id) {
        Usuario u = null;
        try {
            u = em.find(Usuario.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        };
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
    public void borra(Usuario u) {
        try {
            u = em.find(Usuario.class, u.getId());
            em.remove(u);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    @Override
    public boolean guarda(Usuario u) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
