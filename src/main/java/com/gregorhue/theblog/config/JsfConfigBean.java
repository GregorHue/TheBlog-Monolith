package com.gregorhue.theblog.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.inject.Named;

/* *
 * Created by gregorhue on 29.09.2020.
 */
@Named
@ApplicationScoped
@FacesConfig(version = Version.JSF_2_3)
public class JsfConfigBean {

	private String message = "Posts";

	public String getMessage() {
		return this.message;
	}
	
}
