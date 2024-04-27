import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Species} from "../model/species";
import {SpeciesDetails} from "../model/species-details";
import {SpeciesForm} from "../model/species-form";
import {AnimalsForm} from "../../Animals/model/animals-form";
import {SpeciesPatchForm} from "../model/species-patch-form";

@Injectable({
  providedIn: 'root'
})
export class SpeciesService {

  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all species.
   *
   * @return list of species
   */
  getSpecies(): Observable<Species> {
    return this.http.get<Species>('/api/species');
  }

  /**
   * Fetches single species.
   *
   * @param name species name
   * @return single species
   */
  getSingleSpecies(name: string): Observable<SpeciesDetails> {
    return this.http.get<SpeciesDetails>('/api/species/' + name);
  }
  getClassSpecies(name: string): Observable<Species> {
    return this.http.get<Species>('/api/animalClasses/' + name + '/species');
  }

  /**
   * Removes single species.
   *
   * @param name species name
   */
  deleteSpecies(name: string): Observable<any> {
    return this.http.delete('/api/species/' + name);
  }
  patchSpecies(name: string, request: SpeciesPatchForm): Observable<any> {
    return this.http.patch('/api/species/' + name, request);
  }

  putSpecies(name: string, request: SpeciesForm): Observable<any> {
    return this.http.put('/api/species/' + name, request);
  }

}
