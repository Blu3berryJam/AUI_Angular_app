package com.example.speciesaplication.animalClass.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutAnimalClassRequest {
    private String name;
}
