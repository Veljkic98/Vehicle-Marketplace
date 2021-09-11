import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { VehicleType } from '../model/vehicleType.model';

const REST_ENDPOINT = {
  GET: '/vehicle-types',
};

@Injectable({
  providedIn: 'root'
})
export class VehicleTypeService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(): Observable<VehicleType[]> {
    return this.http.get<VehicleType[]>(`${environment.apiUrl}${REST_ENDPOINT.GET}`);
  }

  getOne(id: number) {
    return this.http.get<VehicleType>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }
}
