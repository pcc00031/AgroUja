/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja.model.UsuarioDao;

/**
 *
 * @author Equipo
 */
import daw.agrouja.model.Usuario;
import java.util.List;
import java.util.Map;

public interface UsuarioDAO {

    public Usuario buscaId(int id);

    public List<Usuario> buscaTodos();

    public boolean crea(Usuario u);

    public void borra(Usuario u);

    public boolean guarda(Usuario u);

    public Usuario buscaPorNombre(String nombre);

}
