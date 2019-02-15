package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;

@Path("/classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomService service;
	
	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllClassrooms();
	}
	
	@Path("/getAClassroom")
	@GET
	@Produces({ "application/json" })
	public String getAClassroom(Long id) {
		return service.getAClassroom(id);
	}
	
	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/deleteClassroom")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(Long id) { 
		return service.deleteClassroom(id);
	}
	
	@Path("/updateClassroom")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(Long id, String classroom) { 
		return service.updateClassroom(id, classroom);
	}

}
