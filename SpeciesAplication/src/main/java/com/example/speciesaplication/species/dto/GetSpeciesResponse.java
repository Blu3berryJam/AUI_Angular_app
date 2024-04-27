package com.example.speciesaplication.species.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetSpeciesResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AnimalClass {
        private String name;

    }
    private UUID id;
    private String name;
    private String status;
    private AnimalClass animalClass;
}
