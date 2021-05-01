/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.ContactoDao;

import daw.agrouja.model.Formulario;
import daw.agrouja.qualifiers.DAOMap;
import java.io.Serializable;
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
public class FormulariosDAOMap implements FormulariosDAO, Serializable{
    private Map<Integer, Formulario> formularios=null;
    
     private Integer idForm = 1;
    
    public FormulariosDAOMap(){
        if (formularios==null){
            formularios=new HashMap<>();
            formularios.put(idForm, new Formulario(idForm++, "aloha@yopmail.com", "Oha", "123456789", "Albania", "Pala rota", "Mi pala está rota"));
        }
    }

    @Override
    public List<Formulario> buscaTodos(){
        return formularios.values().stream().collect(Collectors.toList());
    }
    
    @Override
    public Formulario buscaId(Integer id){
        return new Formulario(formularios.get(id)); //Tenemos que crear el constructor de copia en la clase libro
    }
    
    public int numFormularios(){
        return formularios.size();
    }

    @Override
    public boolean crea(Formulario f) {
        formularios.put(idForm, new Formulario(f));
        f.setId(idForm);
        idForm++;
        return true;
    }
    
    @Override
    public boolean borra(Integer id) {
        boolean result=false;
        if(formularios.containsKey(id)){
            formularios.remove(id);
            result = true;
        }
        return result;
    }
}
