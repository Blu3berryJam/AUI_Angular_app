package com.example.animalclassaplication.animalClass.functions;


import com.example.animalclassaplication.animalClass.dto.GetAnimalClassesResponse;
import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class AnimalClassesToResponseFunction implements Function<List<AnimalClass>, GetAnimalClassesResponse> {
    @Override
    public GetAnimalClassesResponse apply(List<AnimalClass> animalClasses) {
        return GetAnimalClassesResponse.builder()
                .animalClasses(animalClasses.stream()
                        .map(animalClass -> GetAnimalClassesResponse.AnimalClass.builder()
                                .id(animalClass.getUuid())
                                .name(animalClass.getName())
                                .nrOfSpecies(animalClass.getNrOfSpecies())
                                .build())
                        .toList())
                .build();
    }
}
