package com.example.animalclassaplication.animalClass.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutAnimalClassRequest {
    private String name;
    private int nrOfSpecies;
}
