import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {SpeciesDetails} from "../../model/species-details";
import {SpeciesService} from "../../service/species.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-species-view',
  standalone: true,
  imports: [
    NgIf,
    RouterLink
  ],
  templateUrl: './species-view.component.html',
  styleUrl: './species-view.component.css'
})
export class SpeciesViewComponent implements OnInit {


  species: SpeciesDetails | undefined;

  /**
   *
   * @param service species service
   * @param route activated route
   * @param router router
   */
  constructor(private service: SpeciesService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSingleSpecies(params['name'])
        .subscribe(species => this.species = species)
    });
  }
}
