/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Equipo
 */

@ApplicationScoped
public class usuarioDao implements  Serializable {

    private final Logger logger = Logger.getLogger(usuarioDao.class.getName());

    
    private EntityManager em;
   
    private Map<Integer, usuario> Usuario = null;
    private int idUser = 1;
    
    public usuarioDao() {
         if (Usuario == null) {
            Usuario = new HashMap<>();
     
            Usuario.put(idUser, new usuario (idUser++, "Cristian", "Muñoz Partido","M", "cmp00070", "Uja123", "cmp00070@red.ujaen.es", "12/10/1995", "123456789012", "Calle Isla Formentera 16", 657603197));
            Usuario.put(idUser, new usuario (idUser++, "Jesus", "Garcia Rodriguez","M","jgr00059", "Uja123", "jgr00059@red.ujaen.es", "09/10/1998", "123456789012", "Avenida de las migaldias", 659603185));
            Usuario.put(idUser, new usuario (idUser++, "Manuel", "Garcia Marquez","M", "mgm00020", "Uja123", "mgm00020@red.ujaen.es", "04/02/1996", "123456789012", "Calle Galicia 26", 624387129));
            Usuario.put(idUser, new usuario (idUser++, "María", "Lozano Mesa","F","mlm00028", "Uja123", "mlm00028@red.ujaen.es", "03/12/1994", "123456789012", "Calle Comunidad de Navarra 4", 626284512));
           

        }
    }
    

    
    public usuario buscaId(Integer id) {
        usuario u=null;
        try {
            u=em.find(usuario.class, id);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return u;
    }
    
   
    public List<usuario> buscaTodos() {
        List<usuario> lu = null;
        try {
            Query q = em.createQuery("Select c from usuario c", usuario.class);
            lu = q.getResultList();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lu;
    }

    

    /** Sample nativeQuery metho
     * @param u
     * @return */
  

   
    public boolean crea(usuario u) {
        boolean creado = false;
        try {
            em.persist(u);
            creado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return creado;
    }

    
    public boolean guarda(usuario u) {
        boolean guardado = false;
        try {
            u = em.merge(u);
            guardado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return guardado;
    }

    
    public boolean borra(Integer id) {
        boolean borrado = false;
        try {
            usuario u = null;
            u = em.find(usuario.class, id);
            em.remove(u);
            borrado = true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return borrado;
    }

}
