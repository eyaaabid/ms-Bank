package com.sid.msbanque;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.sid.msbanque.web.CompteRestJaxRSAPI;

@AutoConfiguration
public class MyConfig {
	
	@Bean
	public ResourceConfig resourceConfig() {
		ResourceConfig jerseyServlet =new ResourceConfig();
		jerseyServlet.register(CompteRestJaxRSAPI.class);
		
		return jerseyServlet;
		
	}

}
