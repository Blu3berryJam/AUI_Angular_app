package com.example.speciesaplication.animalClass.functions;


import com.example.speciesaplication.animalClass.dto.PutAnimalClassRequest;
import com.example.speciesaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToAnimalClassFunction implements Function<PutAnimalClassRequest, AnimalClass> {
    @Override
    public AnimalClass apply(PutAnimalClassRequest request) {
        return AnimalClass.builder()
                .uuid(UUID.randomUUID())
                .name(request.getName())
                .build();
    }
}
