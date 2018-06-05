package com.accen.app.emphierarchy;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author manasranjan
 * jersey configuration to scan end points
 *
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(ObjectMapper mapper) {
		packages("com.accen.app.resources");
	}
	
}