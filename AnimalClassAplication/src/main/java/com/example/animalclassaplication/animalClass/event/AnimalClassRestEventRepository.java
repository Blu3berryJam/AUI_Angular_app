package com.example.animalclassaplication.animalClass.event;

import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import com.example.animalclassaplication.animalClass.functions.AnimalClassToRequestFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;



@Repository
public class AnimalClassRestEventRepository implements AnimalClassEventRepository{
    private final RestTemplate restTemplate;
    private final AnimalClassToRequestFunction animalClassToRequestFunction;
    @Autowired
    public AnimalClassRestEventRepository(RestTemplate template,AnimalClassToRequestFunction function){
        this.restTemplate = template;
        this.animalClassToRequestFunction = function;
    }

    @Override
    public void delete(String name) {
        restTemplate.delete("/api/animalClasses/{name}",name);
    }

    @Override
    public void save(AnimalClass animalClass) {
        restTemplate.postForLocation("/api/animalClasses/", animalClassToRequestFunction.apply(animalClass));
    }
}
