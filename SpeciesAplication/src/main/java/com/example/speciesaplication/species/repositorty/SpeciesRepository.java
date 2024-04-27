package com.example.speciesaplication.species.repositorty;


import com.example.speciesaplication.animalClass.entity.AnimalClass;
import com.example.speciesaplication.species.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, UUID> {
    List<Species> findByStatus(String status);
    @Query("select u from Species u where u.name = :name and u.status = :status")
    Optional<Species> find(
            @Param("name") String name,
            @Param("status") String status
    );
    Optional<Species> findByName(String name);

    List<Species> findSpeciesByAnimalClass(AnimalClass animalClass);
}
