import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { VehicleReq } from '../model/VehicleReq.model';
import { VehicleRes } from '../model/vehicleRes.model';

const REST_ENDPOINT = {
  GET: '/vehicles',
  POST: '/vehicles',
};

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getOne(id: number) {
    return this.http.get<VehicleRes>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }

  getAll() {
    return this.http.get<VehicleRes[]>(`${environment.apiUrl}${REST_ENDPOINT.GET}`).toPromise();
  }

  post(vehicle: VehicleReq) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

    return this.http.post<VehicleRes>(`${environment.apiUrl}${REST_ENDPOINT.POST}`, vehicle, {headers: headers});

  }
}
