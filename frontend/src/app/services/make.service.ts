import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Make } from '../model/make.model';
import { Page } from '../model/page.model';

const REST_ENDPOINT = {
  GET_ALL: '/makes/by-page',
  GET: '/makes',
  MAKES_PER_PAGE: 800
};

@Injectable({
  providedIn: 'root'
})
export class MakeService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(page: number, size: number): Observable<Page<Make>> {
    return this.http.get<Page<Make>>(`${environment.apiUrl}${REST_ENDPOINT.GET_ALL}?page=${page}&size=${size}&sort=id,ASC`);
  }

  getOne(id: number) {
    return this.http.get<Make>(`${environment.apiUrl}${REST_ENDPOINT.GET}/` + id).toPromise();
  }
}
