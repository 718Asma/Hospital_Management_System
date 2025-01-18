package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingRepository extends MongoRepository<Billing, String> {

}