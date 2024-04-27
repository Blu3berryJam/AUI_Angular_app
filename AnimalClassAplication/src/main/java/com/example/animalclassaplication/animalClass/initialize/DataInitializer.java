package com.example.animalclassaplication.animalClass.initialize;


import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import com.example.animalclassaplication.animalClass.service.AnimalClassService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements InitializingBean {

    private final AnimalClassService animalClassService;

    @Autowired
    public DataInitializer(AnimalClassService animalClassService) {
        this.animalClassService = animalClassService;
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        // Inicjalizacja przykładowych danych dla AnimalClass
        AnimalClass mammals = animalClassService.createAnimalClass("Mammals", 5413);
        AnimalClass reptiles = animalClassService.createAnimalClass("Reptiles", 3200);
    }
}
