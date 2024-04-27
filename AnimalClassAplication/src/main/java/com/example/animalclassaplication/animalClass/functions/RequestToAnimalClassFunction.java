package com.example.animalclassaplication.animalClass.functions;

import com.example.animalclassaplication.animalClass.dto.PutAnimalClassRequest;
import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToAnimalClassFunction implements BiFunction<String, PutAnimalClassRequest, AnimalClass> {
    @Override
    public AnimalClass apply(String name, PutAnimalClassRequest putAnimalClassRequest) {
        return AnimalClass.builder()
                .uuid(UUID.randomUUID())
                .name(name)
                .nrOfSpecies(putAnimalClassRequest.getNrOfSpecies())
                .build();
    }
}
