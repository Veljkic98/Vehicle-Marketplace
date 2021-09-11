import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthUser } from '../model/authUser.model';

const REST_ENDPOINT = {
  GET: '/authenticated-users',
};

@Injectable({
  providedIn: 'root'
})
export class AuthUserService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getOne(id: number) {
    return this.http.get<AuthUser>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }
}
