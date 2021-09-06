import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Location } from '../model/location.model';

const REST_ENDPOINT = {
  GET: '/locations',
};

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getOne(id: number) {
    return this.http.get<Location>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }

  getAll() {
    return this.http.get<Location[]>(`${environment.apiUrl}${REST_ENDPOINT.GET}`).toPromise();
  }
}
