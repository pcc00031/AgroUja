/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ComentarioDao;

import daw.agrouja.model.Comentario;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface ComentarioDAO {
    // Metodos de busqueda general

    public Comentario buscaId(Integer id);

    public List<Comentario> buscaTodos();

    // Metodos de edicion general
    public boolean crea(Comentario c);
}
