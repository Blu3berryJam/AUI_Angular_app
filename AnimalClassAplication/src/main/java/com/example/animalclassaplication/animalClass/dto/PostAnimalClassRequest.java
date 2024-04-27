package com.example.animalclassaplication.animalClass.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostAnimalClassRequest {
    private String name;
}
