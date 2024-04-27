import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AlimalListComponent} from "./Animals/view/alimal-list/alimal-list.component";
import {AnimalEditComponent} from "./Animals/view/animal-edit/animal-edit.component";
import {AnimalPutComponent} from "./Animals/view/animal-put/animal-put.component";
import {AnimalViewComponent} from "./Animals/view/animal-view/animal-view.component";
import {SpeciesListComponent} from "./Species/view/species-list/species-list.component";
import {SpeciesEditComponent} from "./Species/view/species-edit/species-edit.component";
import {SpeciesPutComponent} from "./Species/view/species-put/species-put.component";
import {SpeciesViewComponent} from "./Species/view/species-view/species-view.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: AlimalListComponent,
    path: "animalClasses"
  },
  {
    component: AnimalEditComponent,
    path: "animalClasses/:name/edit"
  },
  {
    component: AnimalPutComponent,
    path: "animalClasses/create"
  },
  {
    component: AnimalViewComponent,
    path: "animalClasses/:name"
  },
  {
    component: SpeciesListComponent,
    path: "species"
  },
  {
    component: SpeciesEditComponent,
    path: "species/:name/edit"
  },
  {
    component: SpeciesPutComponent,
    path: "species/create"
  },
  {
    component: SpeciesViewComponent,
    path: "species/:name"
  },

];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
