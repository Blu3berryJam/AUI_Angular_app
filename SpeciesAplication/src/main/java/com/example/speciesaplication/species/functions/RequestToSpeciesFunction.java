package com.example.speciesaplication.species.functions;


import com.example.speciesaplication.animalClass.entity.AnimalClass;
import com.example.speciesaplication.animalClass.service.AnimalClassService;
import com.example.speciesaplication.species.dto.PutSpeciesRequest;
import com.example.speciesaplication.species.entity.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToSpeciesFunction implements BiFunction<String, PutSpeciesRequest, Species> {
    private final AnimalClassService animalClassService;

    @Autowired
    public RequestToSpeciesFunction(AnimalClassService animalClassService) {
        this.animalClassService = animalClassService;
    }

    @Override
    public Species apply(String name, PutSpeciesRequest putSpeciesRequest) {
        Optional<AnimalClass> tak = animalClassService.findByName(putSpeciesRequest.getAnimalClass());
        if(tak.isPresent()) {
            return Species.builder()
                    .uuid(UUID.randomUUID())
                    .name(name)
                    .status(putSpeciesRequest.getStatus())
                    .animalClass(tak.get())
                    .build();
        }
        else
            return null;
    }
}
