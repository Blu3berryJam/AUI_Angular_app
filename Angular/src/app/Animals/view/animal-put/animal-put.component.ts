import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AnimalsForm} from "../../model/animals-form";
import {Animals} from "../../model/animals";
import {AnimalServiceService} from "../../service/animal-service.service";
import {AnimalsPutForm} from "../../model/animal-putform";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-animal-put',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './animal-put.component.html',
  styleUrl: './animal-put.component.css'
})
export class AnimalPutComponent implements OnInit {

  /**
   * Single fleet.
   */
  animal: AnimalsPutForm | undefined;
  animals: Animals | undefined;

  /**
   * @param service fleet service
   * @param route activated route
   * @param router router
   */
  constructor(
      private service: AnimalServiceService,
      private route: ActivatedRoute,
      private router: Router
  ) {
  }

  ngOnInit() {
    this.animal = {
      name: "enter name",
      nrOfSpecies: 0
    }
    this.service.getAnimals().subscribe(animals => this.animals = animals)
  }


  onSubmit(): void {


    this.service.putAnimal(this.animal!)
        .subscribe(() => this.router.navigate(['/animalClasses']));
  }

}

