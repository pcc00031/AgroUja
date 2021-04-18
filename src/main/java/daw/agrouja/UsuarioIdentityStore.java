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
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author Jesus
 */
public class UsuarioIdentityStore implements IdentityStore {
    private Map<String,String> credenciales;
    
    public UsuarioIdentityStore() {
        credenciales=new HashMap<>();
        credenciales.put("admin", "admin");
        credenciales.put("jesus", "jesus");
    }
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        String username=usernamePasswordCredential.getCaller();
        String password=usernamePasswordCredential.getPasswordAsString();
        
        String validPassword=credenciales.get(username);
        if(validPassword!=null&&validPassword.equals(password)) {
            Set<String> roles=new HashSet<>(Arrays.asList("USUARIOS"));
            return new CredentialValidationResult(username, roles);
        }
        return CredentialValidationResult.INVALID_RESULT;
    }
}
