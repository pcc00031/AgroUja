/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import daw.agrouja.model.UsuarioDao.UsuarioDAOJpa;
import daw.agrouja.model.Usuario;
import daw.agrouja.model.UsuarioDao.UsuarioDAO;
import daw.agrouja.qualifiers.DAOJpa;
import javax.inject.Inject;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author Jesus
 */
@ApplicationScoped

public class UsuarioIdentityStore implements IdentityStore {

    @Inject
    @DAOJpa
    private UsuarioDAO usuarioDAO;

    public UsuarioIdentityStore() {
    }

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        String username = usernamePasswordCredential.getCaller();
        String password = usernamePasswordCredential.getPasswordAsString();
        Usuario usuarioEnc = usuarioDAO.buscaPorNombre(username);

        if (usuarioEnc != null && usuarioEnc.getPassword().equals(password)) {
            Set<String> roles = new HashSet<>(Arrays.asList("USUARIOS"));
            return new CredentialValidationResult(username, roles);
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}
