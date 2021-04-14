/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.usuario.dao;

/**
 *
 * @author Equipo
 */


import daw.usuario.user.Usuario;
import daw.productos.model.Producto;
import java.util.List;


public interface UsuarioDAO {


    public Usuario buscaId(int id);

    public List<Usuario> buscaTodos();

    public boolean crea(Usuario u);

    public void borra(Usuario u);

    public boolean guarda(Usuario u);

    
}

