package com.example.animalclassaplication.animalClass.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchAnimalClassRequest {
    private int nrOfSpecies;
}
