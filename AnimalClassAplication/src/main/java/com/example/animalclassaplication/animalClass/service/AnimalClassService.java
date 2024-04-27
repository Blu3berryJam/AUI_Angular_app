package com.example.animalclassaplication.animalClass.service;


import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import com.example.animalclassaplication.animalClass.event.AnimalClassRestEventRepository;
import com.example.animalclassaplication.animalClass.repository.AnimalClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalClassService {

    private final AnimalClassRepository animalClassRepository;

    private final AnimalClassRestEventRepository eventRepository;
    @Autowired
    public AnimalClassService(AnimalClassRepository animalClassRepository, AnimalClassRestEventRepository eventRepository) {
        this.animalClassRepository = animalClassRepository;
        this.eventRepository = eventRepository;
    }

    public AnimalClass createAnimalClass(String name, int nrOfSpecies) {
        AnimalClass animalClass = AnimalClass.builder()
                .uuid(UUID.randomUUID())
                .name(name)
                .nrOfSpecies(nrOfSpecies)
                .build();
        eventRepository.save(animalClass);
        return animalClassRepository.save(animalClass);
    }
    public Optional<AnimalClass> findByName(String name){
        return animalClassRepository.findByName(name);
    }
    public List<AnimalClass> findAll() {
        return animalClassRepository.findAll();
    }

    public void create(AnimalClass animalClass){
        animalClassRepository.save(animalClass);
        eventRepository.save(animalClass);
    }
    public void update(AnimalClass animalClass){
        animalClassRepository.save(animalClass);
    }
    public void delete(String name){
        Optional<AnimalClass> todelete = animalClassRepository.findByName(name);
        if(todelete.isPresent()){
            animalClassRepository.delete(todelete.get());
            eventRepository.delete(name);
        }
    }
}
