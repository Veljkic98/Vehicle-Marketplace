import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Model } from '../model/model.model';

const REST_ENDPOINT = {
  GET: '/models',
  GET_BY_MODEL: '/models/by-make',
  MAKES_PER_PAGE: 3
};

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(makeId: number): Observable<Model[]> {
    return this.http.get<Model[]>(`${environment.apiUrl}${REST_ENDPOINT.GET_BY_MODEL}/${makeId}`);
  }
}
