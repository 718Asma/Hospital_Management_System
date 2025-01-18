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

@Path("/billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Service {

    @Autowired
    private BillingRepository billingRepository;

    @GET
    public List<Billing> getAllEntities() {
        return billingRepository.findAll();
    }

    @POST
    public Billing createEntity(Billing entity) {
        return billingRepository.save(entity);
    }

    @GET
    @Path("/{id}")
    public Billing getEntityById(@PathParam("id") String id) {
        return billingRepository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
    }

    @DELETE
    @Path("/{id}")
    public void deleteEntity(@PathParam("id") String id) {
        billingRepository.deleteById(id);
    }
}
