package com.example.speciesaplication.species.functions;


import com.example.speciesaplication.species.dto.GetMultipleSpeciesResponse;
import com.example.speciesaplication.species.entity.Species;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MultipleSpeciesToResponseFunction implements Function<List<Species>, GetMultipleSpeciesResponse> {
    @Override
    public GetMultipleSpeciesResponse apply(List<Species> species) {
        return GetMultipleSpeciesResponse.builder()
                .species(species.stream()
                        .map(s -> GetMultipleSpeciesResponse.Species.builder()
                                .id(s.getUuid())
                                .name(s.getName())
                                .status(s.getStatus())
                                .animalClass(s.getAnimalClass().getName())
                                .build())
                        .toList())
                .build();
    }
}
