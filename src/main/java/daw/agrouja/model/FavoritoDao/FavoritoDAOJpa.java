/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.FavoritoDao;

import daw.agrouja.model.Favorito;
import daw.agrouja.model.Producto;
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

/**
 *
 * @author Equipo
 */
@RequestScoped
@DAOJpa
@Transactional

public class FavoritoDAOJpa implements FavoritoDAO, Serializable {

    private static final Logger logger = Logger.getLogger(FavoritoDAOJpa.class.getName());

    @PersistenceContext(unitName = "agroPU")
    private EntityManager em;

    public FavoritoDAOJpa() {
    }

    @Override
    public Favorito buscaId(Integer id) {
        Favorito fav = null;
        try {
            fav = em.find(Favorito.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return fav;
    }

    @Override
    public List<Favorito> buscaTodos() {
        List<Favorito> lfav = null;
        try {
            Query q = em.createQuery("Select fav from Favorito fav", Favorito.class);
            lfav = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lfav;
    }

    @Override
    public boolean anade(Favorito fav) {
        boolean anadido = false;
        try {
            em.persist(fav);
            anadido = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return anadido;
    }

    @Override
    public void borra(Integer idprod, Integer idUsuario) {
        try {

            Query q = em.createQuery("Select fav from Favorito fav where :idprod=fav.id_producto AND :idUsu=fav.id_usuario", Favorito.class);
            
            q.setParameter("idprod",idprod );
            q.setParameter("idUsu",idUsuario );
            em.remove(q.getSingleResult());

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    @Override
    public Boolean comprobarUsufav(Usuario u, Producto p) {
        Boolean coincide = false;
        List<Favorito> favo =null;
        try {
             Query q = em.createQuery("Select f from Favorito f, Usuario u, Producto p where f.id_usuario=:uid AND f.id_usuario=u.id AND f.id_producto=p.id AND f.id_producto=:prodId", 
                    Favorito.class);
            q.setParameter("uid", u.getId());
            q.setParameter("prodId", p.getId());
            favo=q.getResultList();
            System.out.println(favo.size());
            if (q.getSingleResult() != null) {
                coincide = true;
                return coincide;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return coincide;
    }
    
}
