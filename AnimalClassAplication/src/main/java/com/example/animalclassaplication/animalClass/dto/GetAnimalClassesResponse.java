package com.example.animalclassaplication.animalClass.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAnimalClassesResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AnimalClass
    {
        private UUID id;
        private String name;
        private Integer nrOfSpecies;


    }
    @Singular
    private List<AnimalClass> animalClasses;
}
