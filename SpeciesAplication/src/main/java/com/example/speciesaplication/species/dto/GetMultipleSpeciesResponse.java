package com.example.speciesaplication.species.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMultipleSpeciesResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Species
    {
        private UUID id;
        private String name;
        private String status;
        private String animalClass;
    }
    @Singular("MultipleSpecies")
    private List<Species> species;
}
