/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.formularioController1;

import daw.agrouja.formulario1.Formulario;
import daw.agrouja.formulariosDAO1.FormulariosDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */

@Named("ctrlFormulario")
@ViewScoped
public class FormularioController implements Serializable {
    
    private final Logger logger = Logger.getLogger(FormularioController.class.getName());
    

    
    private boolean bar=false;
    private int contador = 1;
    
    @Inject 
    private FormulariosDAO formulariosDAO;
    
    private Formulario formulario;
    
    List<Formulario> formularios;
    
    public FormularioController(){   
    }
    
    @PostConstruct
    private void init (){
        formulario=new Formulario();
        formularios=formulariosDAO.buscaTodos();
    }
    
    public Formulario getFormulario(){
        return formulario;
    }
    
    public void setFormulario(Formulario formulario){
        this.formulario=formulario;
    }
    
    public List<Formulario> getFormularios(){
        logger.info("Buscando formularios");
        return formularios;
    }
    
    public String contForm(){
        return "Formulario"+contador++;
    }
    
    public void crea(){
        logger.info("Guardando formulario");
        formulariosDAO.crea(formulario);
    }
    
    public void recupera(){
        logger.info("Recuperando formulario "+formulario.getEmail());
        formulario=formulariosDAO.buscaEmail(formulario.getEmail());

    }
    
    public void recupera(String email){
        formulario = formulariosDAO.buscaEmail(email);
    }
    
    public int isContador(){
        return contador;
    }
    
    public void foo(){
        bar=!bar;
    }
    
    public boolean isBar(){
        return bar;
    }
    
    public void setBar(boolean bar){
        this.bar=bar;
    }       
}
