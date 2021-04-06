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
public class UsuarioController implements Serializable {

    private final Logger logger = Logger.getLogger(UsuarioController.class.getName());

   @Inject        
    private UsuarioDao usuarioDao;
    private Usuario Usuario;
    private List<Usuario> usuarios;
   

    public UsuarioController() {
    }

    @PostConstruct
    public void init() {
        Usuario = new Usuario();
        usuarios = usuarioDao.buscaTodos();
    }

   
    
    public List<Usuario> getUsuarios() {
        return usuarioDao.buscaTodos();
    }

   
    
     public void recupera() {
        logger.info("Recuperando usuario: " + Usuario.getId());
        Usuario = usuarioDao.buscaId(Usuario.getId());
    }

     public void recupera2(int id) {
        Usuario = usuarioDao.buscaId(id);
    }
    public String muestra(int id) {
        recupera2(id);
        return "usuario/mostrar?faces-redirect=true&id=" + Usuario.getId();
    }
     public String guarda() {
        usuarioDao.guarda(Usuario);
        return "mostrar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String edita() {
        recupera();
        return "editar?faces-redirect=true&id=" + Usuario.getId();
    }

    public String crea() {
        logger.info("Creando Usuario: " + Usuario.getId());
        usuarioDao.crea(Usuario);
        return "mostrar?faces-redirect";
    }

    public String borrar() {
        recupera();
        logger.info("Borrando producto: " + Usuario.getId());
        usuarioDao.borra(Usuario);
        return "index?faces-redirect=true";
    }

    

    /**
     * @return the Usuario
     */
    public Usuario getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }
}