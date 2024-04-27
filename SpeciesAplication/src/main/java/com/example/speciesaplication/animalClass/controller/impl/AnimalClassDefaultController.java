package com.example.speciesaplication.animalClass.controller.impl;


import com.example.speciesaplication.animalClass.controller.api.AnimalClassController;
import com.example.speciesaplication.animalClass.dto.PutAnimalClassRequest;
import com.example.speciesaplication.animalClass.functions.RequestToAnimalClassFunction;
import com.example.speciesaplication.animalClass.service.AnimalClassService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AnimalClassDefaultController implements AnimalClassController {

    private final AnimalClassService service;
    private final RequestToAnimalClassFunction requestToAnimalClassFunction;

    @Autowired
    public AnimalClassDefaultController(AnimalClassService service, RequestToAnimalClassFunction requestToAnimalClassFunction) {
        this.service = service;
        this.requestToAnimalClassFunction = requestToAnimalClassFunction;
    }


    @Override
    public void putAnimalClass(PutAnimalClassRequest request) {
        service.create(requestToAnimalClassFunction.apply(request));
    }

    @Override
    public void deleteAnimalClass(String name) {
        service.findByName(name)
                .ifPresentOrElse(
                        animalClass -> service.delete(name),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
