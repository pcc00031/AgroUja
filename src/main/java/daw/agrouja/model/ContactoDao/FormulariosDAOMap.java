/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ContactoDao;

import daw.agrouja.model.Formulario;
import daw.agrouja.qualifiers.DAOMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Carlos
 */

@ApplicationScoped      //Elegible for Dependency Injection
@DAOMap
public class FormulariosDAOMap implements FormulariosDAO{
    private Map<String, Formulario> formularios=null;
    
    public FormulariosDAOMap(){
        if (formularios==null){
            formularios=new HashMap<>();
            formularios.put("aloha@yopmail.com", new Formulario("aloha@yopmail.com", "Oha", "123456789", "Albania", "Pala rota", "Mi pala está rota"));
        }
    }

    @Override
    public List<Formulario> buscaTodos(){
        return formularios.values().stream().collect(Collectors.toList());
    }
    
    @Override
    public Formulario buscaEmail(String email){
        return new Formulario(formularios.get(email)); //Tenemos que crear el constructor de copia en la clase libro
    }
    
    public int numFormularios(){
        return formularios.size();
    }

    @Override
    public boolean crea(Formulario f) {
        
        formularios.put(f.getEmail(), new Formulario(f));
        return true;
    }
}
