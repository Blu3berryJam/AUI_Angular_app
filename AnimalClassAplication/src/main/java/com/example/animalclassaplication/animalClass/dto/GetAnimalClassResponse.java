package com.example.animalclassaplication.animalClass.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAnimalClassResponse {
    private UUID id;
    private String name;
    private int nrOfSpecies;
}
