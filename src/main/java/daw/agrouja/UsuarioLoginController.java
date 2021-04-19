/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
//        AuthenticationParameters ap=new AuthenticationParameters();
//        Credential cred=new UsernamePasswordCredential(username, password);
//        ap.credential(credentials).newAuthentication(true);
//        
//        HttpServletResponse resp=(HttpServletResponse)ec.getResponse();
//        
//        if(sc.authenticate(req, resp, ap)==AuthenticationStatus.SUCCESS) {
//            if(req.isUserInRole("ADMINISTRADORES")) {
//                view="/admin/index?faces-redirect=true";
//            }   else {
//                view="/cliente/index?faces-redirect=true";
//            }
//            logger.log(Level.INFO, "Usuario autenticado");
//        }   else {
//            fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de autenticación", ""));
//            logger.log(Level.WARNING, "Error de autenticación");
//        }
        return view;
    }
    
}
