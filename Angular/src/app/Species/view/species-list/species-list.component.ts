import {Component, OnInit} from '@angular/core';
import {SpeciesService} from "../../service/species.service";
import {Species} from "../../model/species";
import {SingleSpecies} from "../../model/singleSpecies";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-species-list',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './species-list.component.html',
  styleUrl: './species-list.component.css'
})
export class SpeciesListComponent implements OnInit{


  constructor(private service: SpeciesService) {
  }


  species: Species | undefined;

  ngOnInit(): void {
    this.service.getSpecies().subscribe(species => this.species = species);
  }


  onDelete(s: SingleSpecies): void {
    this.service.deleteSpecies(s.name).subscribe(() => this.ngOnInit());
  }

}
