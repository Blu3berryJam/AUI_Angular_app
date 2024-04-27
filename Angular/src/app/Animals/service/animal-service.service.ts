import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Animals} from "../model/animals";
import {AnimalsDetails} from "../model/animals-details";
import {AnimalsForm} from "../model/animals-form";
import {AnimalsPutForm} from "../model/animal-putform";

@Injectable({
  providedIn: 'root'
})
export class AnimalServiceService {

  constructor(private http: HttpClient) {

  }
  getAnimals(): Observable<Animals> {
    return this.http.get<Animals>('/api/animalClasses');
  }
  getAnimal(name: string): Observable<AnimalsDetails> {
    return this.http.get<AnimalsDetails>('/api/animalClasses/' + name);
  }
  putAnimal(request: AnimalsPutForm): Observable<any> {
    return this.http.put('/api/animalClasses/' + request.name, request);
  }
  patchAnimal(name: string, request: AnimalsForm): Observable<any> {
    return this.http.patch('/api/animalClasses/' + name, request);
  }
  deleteAnimal(name: string): Observable<any> {
    return this.http.delete('/api/animalClasses/' + name);
  }
}
