package com.gregorhue.theblog.config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 * Created by gregorhue on 16.11.2020.
 */

@DatabaseIdentityStoreDefinition(
		dataSourceLookup = "jdbc/__default",
		callerQuery = "select u.PASSWORD from USER u where u.DELETED_TS is null and u.USERNAME = ?",
		groupsQuery = "select r.NAME from USER_ROLE ur JOIN USER u ON ur.USER_ID = u.ID JOIN ROLE r ON ur.ROLE_ID = r.ID where u.USERNAME = ?"
		)

@CustomFormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(
				loginPage = "/index.xhtml",
				errorPage = "",
				useForwardToLogin = false
				)
		)
@ApplicationScoped
public class SecurityConfigBean {

}
