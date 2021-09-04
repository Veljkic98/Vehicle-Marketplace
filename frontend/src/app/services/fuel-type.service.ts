import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { FuelType } from '../model/fuelType.model';

const REST_ENDPOINT = {
  GET: '/fuel-types',
};

@Injectable({
  providedIn: 'root'
})
export class FuelTypeService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(): Observable<FuelType[]> {
    return this.http.get<FuelType[]>(`${environment.apiUrl}${REST_ENDPOINT.GET}`);
  }

  getOne(id: number) {
    return this.http.get<FuelType>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }
}
