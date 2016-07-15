package com.project.resources.write;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.hibernate.bdo.EmployeeBDO;

@Path("/write/employee")
public class EmployeeWriteResource {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeWriteResource.class);
	EmployeeBDO employeeBDO=new EmployeeBDO();
	
	/* add employee */
	@POST
	@Path("/create")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String jsonString) {
		try {
			System.out.println("create");
			String responseData = employeeBDO.create(jsonString);			
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			logger.trace(ex.getMessage());
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}
	
	/*update employee*/
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(String jsonString) {
		try {
			System.out.println("IN update method:: "+jsonString);
			String responseData = employeeBDO.update(jsonString);
			System.out.println("after  update method:: "+jsonString);
			return Response.ok(responseData).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
	
}
