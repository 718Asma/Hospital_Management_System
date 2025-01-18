package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/appointment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Service {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GET
    public List<Appointment> getAllEntities() {
        return appointmentRepository.findAll();
    }

    @POST
    public Appointment createEntity(Appointment entity) {
        return appointmentRepository.save(entity);
    }

    @GET
    @Path("/{id}")
    public Appointment getEntityById(@PathParam("id") String id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
    }

    @DELETE
    @Path("/{id}")
    public void deleteEntity(@PathParam("id") String id) {
        appointmentRepository.deleteById(id);
    }
}
