package com.example.animalclassaplication.animalClass.repository;



import com.example.animalclassaplication.animalClass.entity.AnimalClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnimalClassRepository extends JpaRepository<AnimalClass, UUID> {
    Optional<AnimalClass> findByName(String name);

}
