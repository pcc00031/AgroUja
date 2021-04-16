/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ContactoDao;

import daw.agrouja.model.Formulario;
import daw.agrouja.qualifiers.DAOJpa;
import java.util.ArrayList;
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
 * @author Carlos
 */

@RequestScoped
@DAOJpa
@Transactional
public class FormulariosDAOJpa implements FormulariosDAO{
    private final Logger logger = Logger.getLogger(FormulariosDAOJpa.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Formulario buscaEmail (String email){
        Formulario f=null;
        try{
            f=em.find(Formulario.class, email);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No existe el email", e);
        }
        return f;
    }
    
    @Override
    public List<Formulario> buscaTodos(){
        List<Formulario> ff=null;
        try{
            Query q = em.createQuery("Select f from Formulario f", Formulario.class);
            ff=q.getResultList();
        } catch (Exception e){
            logger.log(Level.SEVERE, "No se pueden recuperar los formularios", e);
            ff=new ArrayList<>();
        }
        return ff;
    }
    
    @Override
    public boolean crea (Formulario f){
        boolean creado = false;
        try{
            em.persist(f);
            creado = true;
        } catch (Exception e){
            logger.log(Level.SEVERE, "No se ha podido crear el formulario", e);
        }
        return creado;
    }
}
