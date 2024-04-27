package com.example.speciesaplication.species.controller.api;


import com.example.speciesaplication.species.dto.GetMultipleSpeciesResponse;
import com.example.speciesaplication.species.dto.GetSpeciesResponse;
import com.example.speciesaplication.species.dto.PatchSpeciesRequest;
import com.example.speciesaplication.species.dto.PutSpeciesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


public interface SpeciesController {
    @GetMapping("api/species")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMultipleSpeciesResponse getMultipleSpecies();

    @GetMapping("api/animalClasses/{name}/species")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMultipleSpeciesResponse getClassSpecies(
            @PathVariable("name")
            String name
    );

    @GetMapping("api/species/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetSpeciesResponse getSpecies(
            @PathVariable("name")
            String name
    );


    @PutMapping("api/species/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    void putSpecies(
            @PathVariable("name")
            String name,
            @RequestBody
            PutSpeciesRequest request
    );

    @PatchMapping("api/species/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void updateSpecies(
            @PathVariable("name")
            String name,
            @RequestBody
            PatchSpeciesRequest request
    );


    @DeleteMapping("api/species/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    void deleteSpecies(
            @PathVariable("name")
            String name
    );
}
