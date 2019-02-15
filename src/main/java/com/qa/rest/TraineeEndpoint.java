package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;
import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeEndpoint {

	@Inject
	private TraineeService service;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}
	
	@Path("/getATrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getATrainee(@PathParam("id") Long id) {
		return service.getATrainee(id);
	}
	
	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}
	
	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) { 
		return service.deleteTrainee(id);
	}
	
	@Path("/updateTrainee/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Long id, String trainee) { 
		return service.updateTrainee(id, trainee);
	}
	
	public void setService(TraineeService service) {
		this.service = service;
	}

	
}
