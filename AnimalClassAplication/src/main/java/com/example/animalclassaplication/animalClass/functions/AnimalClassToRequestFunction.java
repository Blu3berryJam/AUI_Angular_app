package com.example.animalclassaplication.animalClass.functions;

import com.example.animalclassaplication.animalClass.dto.PostAnimalClassRequest;
import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AnimalClassToRequestFunction implements Function<AnimalClass, PostAnimalClassRequest>{
    @Override
    public PostAnimalClassRequest apply(AnimalClass animalClass) {
        return PostAnimalClassRequest
                .builder()
                .name(animalClass.getName())
                .build();
    }

}
