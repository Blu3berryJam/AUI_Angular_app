import {Component, OnInit} from '@angular/core';
import {Animals} from "../../model/animals";
import {AnimalServiceService} from "../../service/animal-service.service";
import {Animal} from "../../model/animal";
import {RouterLink} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-alimal-list',
  standalone: true,
  imports: [
    RouterLink,
    NgIf,
    NgForOf
  ],
  templateUrl: './alimal-list.component.html',
  styleUrl: './alimal-list.component.css'
})
export class AlimalListComponent implements OnInit {

  /**
   * @param service fleets service
   */
  constructor(private service: AnimalServiceService) {
  }

  /**
   * Available fleets.
   */
  animals: Animals | undefined;

  ngOnInit(): void {
    this.service.getAnimals().subscribe(animals => this.animals = animals);
  }

  /**
   * Deletes selected animal class.
   *
   * @param animal
   */
  onDelete(animal: Animal): void {
    this.service.deleteAnimal(animal.name).subscribe(() => this.ngOnInit());
  }

}
