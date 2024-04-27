package com.example.speciesaplication.species.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchSpeciesRequest {
    private String status;
}
