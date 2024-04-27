package com.example.speciesaplication.species.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutSpeciesRequest {
    private String name;
    private String status;
    private String animalClass;
}
