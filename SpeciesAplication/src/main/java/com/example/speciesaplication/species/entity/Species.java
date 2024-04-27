package com.example.speciesaplication.species.entity;



import com.example.speciesaplication.animalClass.entity.AnimalClass;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "species")
public class Species implements Serializable {
    @Id
    private UUID uuid;
    @Column(unique = true, name = "species_name")
    String name; //species name
    @Column(name = "conservation_status")
    String status; //conservation status

    @ManyToOne
    @JoinColumn(name = "animalClass")
    private AnimalClass animalClass; //the class to which a species belongs


    @Override
    public String toString() {
        return this.name + " - " + this.status + "\nclass: " + this.animalClass.getName();
    }
}


