package com.example.speciesaplication.species.controller.imp;


import com.example.speciesaplication.animalClass.service.AnimalClassService;
import com.example.speciesaplication.species.controller.api.SpeciesController;
import com.example.speciesaplication.species.dto.GetMultipleSpeciesResponse;
import com.example.speciesaplication.species.dto.GetSpeciesResponse;
import com.example.speciesaplication.species.dto.PatchSpeciesRequest;
import com.example.speciesaplication.species.dto.PutSpeciesRequest;
import com.example.speciesaplication.species.functions.MultipleSpeciesToResponseFunction;
import com.example.speciesaplication.species.functions.RequestToSpeciesFunction;
import com.example.speciesaplication.species.functions.SpeciesToResponseFunction;
import com.example.speciesaplication.species.functions.UpdateSpeciesWithRequestFunction;
import com.example.speciesaplication.species.service.SpeciesService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class SpeciesDefaultController implements SpeciesController {

    private final SpeciesService service;
    private final AnimalClassService animalClassService;
    private final SpeciesToResponseFunction speciesToResponseFunction;
    private final MultipleSpeciesToResponseFunction multipleSpeciesToResponseFunction;
    private final RequestToSpeciesFunction requestToSpeciesFunction;
    private final UpdateSpeciesWithRequestFunction updateSpeciesWithRequestFunction;

    public SpeciesDefaultController(SpeciesService service, AnimalClassService animalClassService, SpeciesToResponseFunction speciesToResponseFunction, MultipleSpeciesToResponseFunction multipleSpeciesToResponseFunction, RequestToSpeciesFunction requestToSpeciesFunction, UpdateSpeciesWithRequestFunction updateSpeciesWithRequestFunction) {
        this.service = service;
        this.animalClassService = animalClassService;
        this.speciesToResponseFunction = speciesToResponseFunction;
        this.multipleSpeciesToResponseFunction = multipleSpeciesToResponseFunction;
        this.requestToSpeciesFunction = requestToSpeciesFunction;
        this.updateSpeciesWithRequestFunction = updateSpeciesWithRequestFunction;
    }

    @Override
    public GetMultipleSpeciesResponse getMultipleSpecies() {
        return multipleSpeciesToResponseFunction.apply(service.findAll());
    }

    @Override
    public GetMultipleSpeciesResponse getClassSpecies(String name) {
        return service.getSpeciesByClass(name)
                .map(multipleSpeciesToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetSpeciesResponse getSpecies(String name) {
        return service.findByName(name)
                .map(speciesToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putSpecies(String name, PutSpeciesRequest request) {
        animalClassService.findByName(request.getAnimalClass()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        service.create(requestToSpeciesFunction.apply(name, request));
    }

    @Override
    public void updateSpecies(String name, PatchSpeciesRequest request) {
        service.create(updateSpeciesWithRequestFunction.apply(service.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                request));
    }

    @Override
    public void deleteSpecies(String name) {
        service.findByName(name)
                .ifPresentOrElse(
                        species -> service.delete(name),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
