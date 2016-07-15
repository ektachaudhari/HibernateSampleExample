package com.project.resources.read;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.hibernate.bdo.EmployeeBDO;

@Path("/read/employee")
public class EmployeeReadResource {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeReadResource.class);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			//System.out.println("read/employee");
			String responseData = new EmployeeBDO().list();
			//System.out.println(responseData);
			return Response.ok(responseData).build();			
		} catch (Exception ex) {
			logger. trace(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
}
