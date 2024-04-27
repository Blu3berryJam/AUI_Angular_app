package com.example.speciesaplication.animalClass.controller.api;


import com.example.speciesaplication.animalClass.dto.PutAnimalClassRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
public interface AnimalClassController {
    @PostMapping("api/animalClasses/")
    @ResponseStatus(HttpStatus.CREATED)
    void putAnimalClass(
            @RequestBody
            PutAnimalClassRequest request
    );

    @DeleteMapping("api/animalClasses/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteAnimalClass(
            @PathVariable("name")
            String name
    );

}
