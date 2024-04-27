package com.example.animalclassaplication.animalClass.controller.impl;


import com.example.animalclassaplication.animalClass.controller.api.AnimalClassController;
import com.example.animalclassaplication.animalClass.dto.GetAnimalClassResponse;
import com.example.animalclassaplication.animalClass.dto.GetAnimalClassesResponse;
import com.example.animalclassaplication.animalClass.dto.PatchAnimalClassRequest;
import com.example.animalclassaplication.animalClass.dto.PutAnimalClassRequest;
import com.example.animalclassaplication.animalClass.functions.AnimalClassToResponseFunction;
import com.example.animalclassaplication.animalClass.functions.AnimalClassesToResponseFunction;
import com.example.animalclassaplication.animalClass.functions.RequestToAnimalClassFunction;
import com.example.animalclassaplication.animalClass.functions.UpdateAnimalClassWithRequestFunction;
import com.example.animalclassaplication.animalClass.service.AnimalClassService;
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
    private final AnimalClassToResponseFunction classToResponseFunction;
    private final AnimalClassesToResponseFunction classesToResponseFunction;
    private final RequestToAnimalClassFunction requestToAnimalClassFunction;
    private final UpdateAnimalClassWithRequestFunction updateAnimalClassWithRequestFunction;

    @Autowired
    public AnimalClassDefaultController(AnimalClassService service, AnimalClassToResponseFunction classToResponseFunction, AnimalClassesToResponseFunction classesToResponseFunction, RequestToAnimalClassFunction requestToAnimalClassFunction, UpdateAnimalClassWithRequestFunction updateAnimalClassWithRequestFunction) {
        this.service = service;
        this.classToResponseFunction = classToResponseFunction;
        this.classesToResponseFunction = classesToResponseFunction;
        this.requestToAnimalClassFunction = requestToAnimalClassFunction;
        this.updateAnimalClassWithRequestFunction = updateAnimalClassWithRequestFunction;
    }


    @Override
    public GetAnimalClassesResponse getAnimalClasses() {
        return classesToResponseFunction.apply(service.findAll());
    }

    @Override
    public GetAnimalClassResponse getAnimalClass(String name) {
        return service.findByName(name)
                .map(classToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putAnimalClass(String name, PutAnimalClassRequest request) {
        service.create(requestToAnimalClassFunction.apply(name, request));
    }

    @Override
    public void updateAnimalClass(String name, PatchAnimalClassRequest request) {
        service.update(updateAnimalClassWithRequestFunction.apply(service.findByName(name)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                request));

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
