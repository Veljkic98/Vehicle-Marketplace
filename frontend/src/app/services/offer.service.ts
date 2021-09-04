import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Filter } from '../model/filter.model';
import { OfferRes } from '../model/offerRes.model';
import { Page } from '../model/page.model';

const REST_ENDPOINT = {
  GET: '/offers',
};

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  // getAllFilter(page: number, size: number, filter: Filter): Observable<Page<Offer>> {
  //   return this.http.post<Page<Offer>>(`${environment.apiUrl}${REST_ENDPOINT.GET_ALL}` + `/filter/by-page/?page=${page}&size=${size}&sort=id,ASC`, filter);
  // }

  getAll(page: number, size: number): Observable<Page<OfferRes>> {
    return this.http.get<Page<OfferRes>>(`${environment.apiUrl}${REST_ENDPOINT.GET}` + `/by-page/?page=${page}&size=${size}&sort=id,ASC`);
  }
}
