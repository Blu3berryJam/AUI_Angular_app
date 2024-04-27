package com.example.animalclassaplication.animalClass.controller.api;


import com.example.animalclassaplication.animalClass.dto.GetAnimalClassResponse;
import com.example.animalclassaplication.animalClass.dto.GetAnimalClassesResponse;
import com.example.animalclassaplication.animalClass.dto.PatchAnimalClassRequest;
import com.example.animalclassaplication.animalClass.dto.PutAnimalClassRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
public interface AnimalClassController {
    @GetMapping("api/animalClasses")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAnimalClassesResponse getAnimalClasses();

    @GetMapping("api/animalClasses/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAnimalClassResponse getAnimalClass(
            @PathVariable("name")
            String name
    );

    @PutMapping("api/animalClasses/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAnimalClass(
            @PathVariable("name")
            String name,
            @RequestBody
            PutAnimalClassRequest request
    );

    @PatchMapping("api/animalClasses/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void updateAnimalClass(
            @PathVariable("name")
            String name,
            @RequestBody
            PatchAnimalClassRequest request
    );

    @DeleteMapping("api/animalClasses/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteAnimalClass(
            @PathVariable("name")
            String name
    );

}
