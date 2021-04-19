/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.agrouja;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import org.glassfish.soteria.identitystores.annotation.Credentials;
import org.glassfish.soteria.identitystores.annotation.EmbeddedIdentityStoreDefinition;

/**
 *
 * @author Jesus
 */
@EmbeddedIdentityStoreDefinition({
        @Credentials(callerName="admin", password="admin", groups={"ADMINISTRADORES"}),
        @Credentials(callerName="jesus", password="jesus", groups={"USUARIOS"})
    })
    /**@BasicAuthenticationMechanismDefinition*/
    @FormAuthenticationMechanismDefinition(
        loginToContinue=@LoginToContinue(
            loginPage="/login.jsf",
            errorPage="/login.jsf?error",
            useForwardToLogin=false
        )
    )
    /**@CustomFormAuthenticacionMechanismDefinition(
        loginToContinue=@LoginToContinue(
            loginPage="/customlogin.jsf",
            errorPage="",
            useForwardToLogin=false*/
    @ApplicationScoped
    @FacesConfig
public class AppConfig {
    
}
