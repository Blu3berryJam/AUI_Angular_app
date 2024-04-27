package com.example.animalclassaplication.animalClass.entity;


import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AnimalClass implements Serializable {
    @Id
    private UUID uuid;
    @Column(unique = true, name = "animal_class_name")
    String name; //name of animal class
    @Column(name = "approximate_number_of_known_species")
    int nrOfSpecies; //approximate number of known species


    @Override
    public String toString() {
        return name + " (" +
                "number of species=" + nrOfSpecies +
                ")";
    }
}
