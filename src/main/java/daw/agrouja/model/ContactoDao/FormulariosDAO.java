/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ContactoDao;

import daw.agrouja.model.Formulario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Carlos
 */

public interface FormulariosDAO { 
    public List<Formulario> buscaTodos();
    public Formulario buscaEmail(String email);
    public boolean crea(Formulario f);
    /*private Map<String, Formulario> formularios=null;
    
    public FormulariosDAO(){
        if (formularios==null){
            formularios=new HashMap<>();
            formularios.put("aloha@yopmail.com",new Formulario("Oha", "123456789", "aloha@yopmail.com", "Albania", "Pala rota", "Mi pala está rota"));
        }
    }

    public List<Formulario> buscaTodos(){
        return formularios.values().stream().collect(Collectors.toList());
    }
    
    public Formulario buscaEmail(String email){
        return new Formulario(formularios.get(email)); //Tenemos que crear el constructor de copia en la clase libro
    }
    
    public int numLibros(){
        return formularios.size();
    }

    public boolean crea(Formulario f) {
        
        formularios.put(f.getEmail(), new Formulario(f));
        return true;
    }*/
}
