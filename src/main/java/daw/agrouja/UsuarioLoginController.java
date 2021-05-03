/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja;

import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Jesus
 */
@ViewScoped @Named
public class UsuarioLoginController implements Serializable{
    @Inject FacesContext fc;
    @Inject SecurityContext sc;
    @Inject ExternalContext ec;
    @Inject HttpServletRequest req;
    
    private String username;
    
    @NotEmpty(message="Introduzca una clave válida")
    private String password;
    
    public UsuarioLoginController() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String login) {
        this.username=login;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password=password;
    }
    
    public String login() {
        String view="";
        return view;
    }
    
}
