/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.usuario;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "usuarioCtrl")
@ViewScoped
public class usuarioController implements Serializable {

    private final Logger logger = Logger.getLogger(usuarioController.class.getName());

   @Inject        
    private usuarioDao usuarioDao;
    private usuario Usuario;
    private List<usuario> usuarios;
   

    public usuarioController() {
    }

    @PostConstruct
    public void init() {
        setUsuario(new usuario());
        usuarios = usuarioDao.buscaTodos();
    }

   
    
    public List<usuario> getUsuarios() {
        return usuarioDao.buscaTodos();
    }

    public void recupera() {
        setUsuario(usuarioDao.buscaId(getUsuario().getId()));
        if (getUsuario() == null) {            
           /* fc.addMessage(null, new FacesMessage("El usuario indicado no existe"));*/
        }
    }

    
    public String crea() {
        getUsuario().setId(0);
        usuarioDao.crea(getUsuario());
        return "visualiza?faces-redirect=true&id=" + getUsuario().getId();
    }

    
    public String guarda() {

        usuarioDao.guarda(getUsuario());
        return "visualiza?faces-redirect=true&id=" + getUsuario().getId();
    }

    /**
     * @return the Usuario
     */
    public usuario getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(usuario Usuario) {
        this.Usuario = Usuario;
    }
}