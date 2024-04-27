package com.example.speciesaplication.species.functions;


import com.example.speciesaplication.species.dto.GetSpeciesResponse;
import com.example.speciesaplication.species.entity.Species;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SpeciesToResponseFunction implements Function<Species, GetSpeciesResponse> {
    @Override
    public GetSpeciesResponse apply(Species species) {
        return GetSpeciesResponse.builder()
                .id(species.getUuid())
                .name(species.getName())
                .status(species.getStatus())
                .animalClass(GetSpeciesResponse.AnimalClass.builder()
                        .name(species.getAnimalClass().getName())
                        .build())
                .build();
    }
}
