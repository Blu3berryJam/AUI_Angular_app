package com.example.animalclassaplication.animalClass.functions;


import com.example.animalclassaplication.animalClass.dto.PatchAnimalClassRequest;
import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateAnimalClassWithRequestFunction implements BiFunction<AnimalClass, PatchAnimalClassRequest, AnimalClass> {
    @Override
    public AnimalClass apply(AnimalClass animalClass, PatchAnimalClassRequest patchAnimalClassRequest) {
        return AnimalClass.builder()
                .uuid(animalClass.getUuid())
                .name(animalClass.getName())
                .nrOfSpecies(patchAnimalClassRequest.getNrOfSpecies())
                .build();
    }
}
