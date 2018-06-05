package com.accen.app.emphierarchy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.SpringServletContainerInitializer;

/**
 * 
 * @author manasranjan
 * start of springboot with base package scanning
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.accen.app.*"})
@EntityScan(basePackages= {"com.accen.app.datamodel"})
public class EmpHierarchyApplication extends SpringServletContainerInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EmpHierarchyApplication.class, args);
	}
}
