package com.example.animalgateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnimalgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimalgatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${animalClassMeneger.species.url}") String speciesUrl,
            @Value("${animalClassMeneger.animalClass.url}") String animalClassUrl,
            @Value("${animalClassMeneger.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("animalClasses", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/animalClasses/{name}",
                                "/api/animalClasses"
                        )
                        .uri(animalClassUrl)
                )
                .route("species", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/species",
                                "/api/species/**",
                                "/api/animalClasses/{name}/species",
                                "/api/animalClasses/{name}/species/**"
                        )
                        .uri(speciesUrl)
                )
                .build();
    }
}
