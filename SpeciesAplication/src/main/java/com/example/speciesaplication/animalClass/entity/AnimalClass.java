package com.example.speciesaplication.animalClass.entity;


import com.example.speciesaplication.species.entity.Species;
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

    @OneToMany(mappedBy = "animalClass", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Species> species; //list of animals

    public void add(Species animal){
        try {
            this.species.add(animal);
        }catch(Exception e){
            this.species = new ArrayList<>();
            this.species.add(animal);
        } //if list exist add new animal to list, else create list and then add animal

    }
}
