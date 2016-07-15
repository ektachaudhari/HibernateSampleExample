package com.project.application;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class EmployeeApplication extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		System.out.println("in EmployeeApplication");
		Set<Class<?>> resources = new java.util.HashSet<>();
		resources.add(com.project.resources.write.EmployeeWriteResource.class);
		resources.add(com.project.resources.read.EmployeeReadResource.class);
		return resources;
		
	}
}
