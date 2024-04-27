import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {SpeciesPatchForm} from "../../model/species-patch-form";
import {Animals} from "../../../Animals/model/animals";
import {SpeciesService} from "../../service/species.service";
import {AnimalServiceService} from "../../../Animals/service/animal-service.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-species-edit',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './species-edit.component.html',
  styleUrl: './species-edit.component.css'
})
export class SpeciesEditComponent  implements OnInit {

  name: string | undefined;


  species: SpeciesPatchForm | undefined;

  original: SpeciesPatchForm | undefined;


  animals: Animals | undefined;


  constructor(
    private speciesService: SpeciesService,
    private animalService: AnimalServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.animalService.getAnimals()
        .subscribe(animals => this.animals = animals);

      this.speciesService.getSingleSpecies(params['name'])
        .subscribe(species => {
          this.name = species.name;
          this.species = {
            status: species.status,
          };
          this.original = {...this.species};
        });
    });
  }

  onSubmit(): void {
    this.speciesService.patchSpecies(this.name!, this.species!)
      .subscribe(() => this.router.navigate(['/species']));
  }

}

