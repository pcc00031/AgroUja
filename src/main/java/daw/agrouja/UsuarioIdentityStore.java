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

    //@Inject @DAOJpa
    private final Map<String, String> credenciales;

    public UsuarioIdentityStore() {
        credenciales = new HashMap<>();
        credenciales.put("jgr00059", "jesus");
        credenciales.put("pcc00031", "pedro");
        credenciales.put("cmp00070", "cristian");
        credenciales.put("cga00037", "carlos");
    }

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        String username = usernamePasswordCredential.getCaller();
        String password = usernamePasswordCredential.getPasswordAsString();

        credenciales.put(username, password);

        String validPassword = credenciales.get(username);
        if (validPassword != null && validPassword.equals(password)) {
            Set<String> roles = new HashSet<>(Arrays.asList("USUARIOS"));
            return new CredentialValidationResult(username, roles);
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}
