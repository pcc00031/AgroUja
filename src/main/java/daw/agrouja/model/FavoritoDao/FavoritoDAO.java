/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.FavoritoDao;

import daw.agrouja.model.Comentario;
import daw.agrouja.model.Favorito;
import daw.agrouja.model.Usuario;
import java.util.List;

/**
 *
 * @author Equipo
 */
public interface FavoritoDAO {
    
     public Favorito buscaId(Integer id);

     public List<Favorito> buscaTodos();
     
     public boolean anade(Favorito fav);
     
      public void borra(Integer idprod, Integer idUsuario);
      
    
}
