package com.example.animalclassaplication.animalClass.event;

import com.example.animalclassaplication.animalClass.entity.AnimalClass;

import java.util.UUID;

public interface AnimalClassEventRepository {
    void delete(String name);
    void save(AnimalClass animalClass);
}
