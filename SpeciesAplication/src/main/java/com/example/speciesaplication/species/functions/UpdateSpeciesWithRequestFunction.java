package com.example.speciesaplication.species.functions;


import com.example.speciesaplication.species.dto.PatchSpeciesRequest;
import com.example.speciesaplication.species.entity.Species;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateSpeciesWithRequestFunction implements BiFunction<Species, PatchSpeciesRequest, Species> {
    @Override
    public Species apply(Species species, PatchSpeciesRequest patchSpeciesRequest) {
        return Species.builder()
                .uuid(species.getUuid())
                .name(species.getName())
                .status(patchSpeciesRequest.getStatus())
                .animalClass(species.getAnimalClass())
                .build();
    }
}
