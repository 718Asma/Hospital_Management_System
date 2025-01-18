package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalyseRepository extends MongoRepository<Analyse, String> {

}