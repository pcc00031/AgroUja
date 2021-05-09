/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.FavoritoDao;


import daw.agrouja.model.Favorito;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Equipo
 */

@ApplicationScoped
@DAOMap
public class FavoritoDAOMap implements FavoritoDAO, Serializable {
    
    

    @Override
    public Favorito buscaId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Favorito> buscaTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean anade(Favorito fav) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void borra(Integer idprod, Integer idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
    
}
