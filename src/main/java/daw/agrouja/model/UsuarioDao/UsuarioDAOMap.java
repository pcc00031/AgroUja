/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

import daw.agrouja.qualifiers.DAOMap;
import daw.agrouja.model.Usuario;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class UsuarioDAOMap implements UsuarioDAO,Serializable{
    
    
     private final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());

    
    private EntityManager em;
   
    private Map<Integer, Usuario> Usuario = null;
    private int idUser = 1;
    
    public UsuarioDAOMap() {
         if (Usuario == null) {
            Usuario = new HashMap<>();
     
            Usuario.put(idUser, new Usuario (idUser++, "Cristian", "Muñoz Partido","M", "cmp00070", "Uja123", "cmp00070@red.ujaen.es", "12/10/1995", "123456789012", "Calle Isla Formentera 16", 657603197));
            Usuario.put(idUser, new Usuario (idUser++, "Jesus", "Garcia Rodriguez","M","jgr00059", "Uja123", "jgr00059@red.ujaen.es", "09/10/1998", "123456789012", "Avenida de las migaldias", 659603185));
            Usuario.put(idUser, new Usuario (idUser++, "Manuel", "Garcia Marquez","M", "mgm00020", "Uja123", "mgm00020@red.ujaen.es", "04/02/1996", "123456789012", "Calle Galicia 26", 624387129));
            Usuario.put(idUser, new Usuario (idUser++, "María", "Lozano Mesa","F","mlm00028", "Uja123", "mlm00028@red.ujaen.es", "03/12/1994", "123456789012", "Calle Comunidad de Navarra 4", 626284512));
           

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

    

    /** Sample nativeQuery metho
     * @param u
     * @return */
  

   
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

}
    

