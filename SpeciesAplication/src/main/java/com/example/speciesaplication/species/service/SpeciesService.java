package com.example.speciesaplication.species.service;


import com.example.speciesaplication.animalClass.entity.AnimalClass;
import com.example.speciesaplication.animalClass.repository.AnimalClassRepository;
import com.example.speciesaplication.species.entity.Species;
import com.example.speciesaplication.species.repositorty.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpeciesService {

    private final SpeciesRepository speciesRepository;
    private final AnimalClassRepository animalClassRepository;

    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository, AnimalClassRepository animalClassRepository) {
        this.speciesRepository = speciesRepository;
        this.animalClassRepository = animalClassRepository;
    }

    public Species createSpecies(String name, String status, AnimalClass aClass) {
        Species species = Species.builder()
                .uuid(UUID.randomUUID())
                .name(name)
                .status(status)
                .animalClass(aClass)
                .build();
        return speciesRepository.save(species);
    }
    public void create(Species species){
        speciesRepository.save(species);
    }

    public List<Species> getSpeciesByStatus(String status) {
        return speciesRepository.findByStatus(status);
    }
    public Optional<List<Species>> getSpeciesByClass(String name) {
        return animalClassRepository.findByName(name)
                .map(speciesRepository::findSpeciesByAnimalClass);
    }
    public Optional<Species> findByName(String name){
        return speciesRepository.findByName(name);
    }
    public void delete(String name){
        Optional<Species> todelete = speciesRepository.findByName(name);
        if(todelete.isPresent()){
            speciesRepository.delete(todelete.get());
        }

    }
    public List<Species> findAll(){
        return speciesRepository.findAll();
    }
}
