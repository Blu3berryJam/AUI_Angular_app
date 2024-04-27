import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {AnimalsDetails} from "../../model/animals-details";
import {Species} from "../../../Species/model/species";
import {AnimalServiceService} from "../../service/animal-service.service";
import {SpeciesService} from "../../../Species/service/species.service";
import {SingleSpecies} from "../../../Species/model/singleSpecies";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-animal-view',
  standalone: true,
  imports: [
    RouterLink,
    NgIf,
    NgForOf
  ],
  templateUrl: './animal-view.component.html',
  styleUrl: './animal-view.component.css'
})
export class AnimalViewComponent implements OnInit {

  /**
   * Single animal class.
   */
  animal: AnimalsDetails | undefined;
  species: Species | undefined;
  /**
   *
   * @param service animal class service
   * @param speciesService
   * @param route activated route
   * @param router router
   */
  constructor(private service: AnimalServiceService, private speciesService: SpeciesService,private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getAnimal(params['name']).subscribe(animal => this.animal = animal);
      this.speciesService.getClassSpecies(params['name']).subscribe(species => this.species = species)
    });
  }
  onDelete(species: SingleSpecies): void {
    this.speciesService.deleteSpecies(species.name).subscribe(() => this.ngOnInit());
  }
}
