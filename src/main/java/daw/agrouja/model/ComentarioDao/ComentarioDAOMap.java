/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ComentarioDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Pedro
 */
@ApplicationScoped
@DAOMap
public class ComentarioDAOMap implements ComentarioDAO, Serializable{

    @Override
    public Comentario buscaId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comentario> buscaTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crea(Comentario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
