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

@Path("/doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Service {

    @Autowired
    private DoctorRepository doctorRepository;

    @GET
    public List<Doctor> getAllEntities() {
        return doctorRepository.findAll();
    }

    @POST
    public Doctor createEntity(Doctor entity) {
        return doctorRepository.save(entity);
    }

    @GET
    @Path("/{id}")
    public Doctor getEntityById(@PathParam("id") String id) {
        return doctorRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
    }

    @DELETE
    @Path("/{id}")
    public void deleteEntity(@PathParam("id") String id) {
        doctorRepository.deleteById(id);
    }
}
