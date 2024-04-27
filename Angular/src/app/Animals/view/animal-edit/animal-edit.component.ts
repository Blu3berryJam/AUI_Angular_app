import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AnimalsForm} from "../../model/animals-form";
import {AnimalServiceService} from "../../service/animal-service.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-animal-edit',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './animal-edit.component.html',
  styleUrl: './animal-edit.component.css'
})
export class AnimalEditComponent implements OnInit {

  name: string | undefined;


  class: AnimalsForm | undefined;


  original: AnimalsForm | undefined;


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
    this.route.params.subscribe(params => {
      this.service.getAnimal(params['name'])
        .subscribe(animal => {
          this.name = animal.name;
          this.class = {
            nrOfSpecies: animal.nrOfSpecies
          };
          this.original = {...this.class};
        });
    });
  }


  onSubmit(): void {
    this.service.patchAnimal(this.name!, this.class!)
      .subscribe(() => this.router.navigate(['/animalClasses']));
  }

}

