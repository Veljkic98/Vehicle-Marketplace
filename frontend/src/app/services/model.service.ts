import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ModelRes } from '../model/modelRes.model';

const REST_ENDPOINT = {
  GET: '/models',
  GET_BY_MODEL: '/models/by-make',
};

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(makeId: number): Observable<ModelRes[]> {
    return this.http.get<ModelRes[]>(`${environment.apiUrl}${REST_ENDPOINT.GET_BY_MODEL}/${makeId}`);
  }

  getOne(id: number) {
    return this.http.get<ModelRes>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }
}
