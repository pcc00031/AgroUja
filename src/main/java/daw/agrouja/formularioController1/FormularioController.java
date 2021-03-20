/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.formularioController1;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Carlos
 */

@Named("ctrlFormulario")
@ViewScoped
@SessionScoped
public class FormularioController implements Serializable {
    
    private final Logger logger = Logger.getLogger(FormularioController.class.getName());
    
    private boolean bar=false;
    
    public FormularioController(){
        
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
