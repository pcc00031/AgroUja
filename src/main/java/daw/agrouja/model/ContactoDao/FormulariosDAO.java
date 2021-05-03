/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ContactoDao;

import daw.agrouja.model.Formulario;
import java.util.List;

/**
 *
 * @author Carlos
 */

public interface FormulariosDAO { 
    public List<Formulario> buscaTodos();
    public Formulario buscaId(Integer Id);
    public boolean crea(Formulario f);
    public boolean borra(Integer id);
    public boolean editar(Formulario f);
}
