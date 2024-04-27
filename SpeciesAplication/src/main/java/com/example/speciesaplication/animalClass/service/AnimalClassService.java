package com.example.speciesaplication.animalClass.service;


import com.example.speciesaplication.animalClass.entity.AnimalClass;
import com.example.speciesaplication.animalClass.repository.AnimalClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalClassService {

    private final AnimalClassRepository animalClassRepository;

    @Autowired
    public AnimalClassService(AnimalClassRepository animalClassRepository) {
        this.animalClassRepository = animalClassRepository;
    }

    public Optional<AnimalClass> findByName(String name){
        return animalClassRepository.findByName(name);
    }
    public List<AnimalClass> findAll() {
        return animalClassRepository.findAll();
    }

    public void create(AnimalClass animalClass){
        Optional<AnimalClass> a = animalClassRepository.findByName(animalClass.getName());
        if(a.isPresent()){
        }
        else {animalClassRepository.save(animalClass);}

    }
    public void delete(String name){
        Optional<AnimalClass> todelete = animalClassRepository.findByName(name);
        if(todelete.isPresent()){
            animalClassRepository.delete(todelete.get());
        }
    }
}
