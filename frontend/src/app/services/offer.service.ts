import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Filter } from '../model/filter.model';
import { OfferReq } from '../model/offerReq.model';
import { OfferRes } from '../model/offerRes.model';
import { Page } from '../model/page.model';

const REST_ENDPOINT = {
  GET: '/offers',
  POST: '/offers',
};

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  // private headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

  constructor(
    private http: HttpClient,
  ) { }

  getAll(page: number, size: number, which: string) {
    if (which == "mine") {
      const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

      return this.http.get<Page<OfferRes>>(`${environment.apiUrl}${REST_ENDPOINT.GET}` + `/by-page/my/?page=${page}&size=${size}&sort=id,ASC`, { headers: headers }).toPromise();
    } else {
      return this.http.get<Page<OfferRes>>(`${environment.apiUrl}${REST_ENDPOINT.GET}` + `/by-page/?page=${page}&size=${size}&sort=id,ASC`).toPromise();
    }
  }

  delete(id: number) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });

    return this.http.delete(`${environment.apiUrl}${REST_ENDPOINT.GET}/${id}`, { headers: headers });
  }

  post(offer: OfferReq, image: string) {
    const headers = new HttpHeaders({ 'Authorization': "Bearer " + JSON.parse(localStorage.getItem('user')).token });
    
    const formData = new FormData();

    formData.append('dto', new Blob([JSON.stringify(offer)], {
      type: 'application/json'
    }));

    if (image) formData.append('file', image);

    return this.http.post<OfferRes>(`${environment.apiUrl}${REST_ENDPOINT.POST}`, formData, {headers: headers});
  }
}
