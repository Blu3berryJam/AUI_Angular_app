package com.example.speciesaplication.species.initialize;


import com.example.speciesaplication.animalClass.entity.AnimalClass;
import com.example.speciesaplication.animalClass.service.AnimalClassService;
import com.example.speciesaplication.species.service.SpeciesService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Initialize implements InitializingBean {

    private final AnimalClassService animalClassService;
    private final SpeciesService speciesService;

    @Autowired
    public Initialize(AnimalClassService animalClassService, SpeciesService speciesService) {
        this.animalClassService = animalClassService;
        this.speciesService = speciesService;
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        // Inicjalizacja przykładowych danych dla AnimalClass
        AnimalClass mammals = AnimalClass.builder().uuid(UUID.randomUUID()).name("Mammals").build();
        animalClassService.create(mammals);
        AnimalClass reptiles = AnimalClass.builder().uuid(UUID.randomUUID()).name("Reptiles").build();
        animalClassService.create(reptiles);

        // Inicjalizacja przykładowych danych dla Species
        speciesService.createSpecies("Lion", "Vulnerable", mammals);
        speciesService.createSpecies("Tiger", "Endangered", mammals);
        speciesService.createSpecies("Crocodile", "Least Concern", reptiles);
    }
}
