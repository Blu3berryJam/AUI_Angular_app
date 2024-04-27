package com.example.animalclassaplication.animalClass.functions;


import com.example.animalclassaplication.animalClass.dto.GetAnimalClassResponse;
import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AnimalClassToResponseFunction implements Function<AnimalClass, GetAnimalClassResponse> {
    @Override
    public GetAnimalClassResponse apply(AnimalClass animalClass) {
        return GetAnimalClassResponse.builder()
                .id(animalClass.getUuid())
                .name(animalClass.getName())
                .nrOfSpecies(animalClass.getNrOfSpecies())
                .build();
    }
}
