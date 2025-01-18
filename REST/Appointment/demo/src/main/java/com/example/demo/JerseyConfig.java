package com.example.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Service.class);

        // Alternatively, scan an entire package for resources
        // packages("com.example.demo.resources");
    }
}