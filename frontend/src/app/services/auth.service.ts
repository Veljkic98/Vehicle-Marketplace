import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { JWT } from '../model/jwt.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    public router: Router,
  ) { }

  login(email: string, password: string): Observable<JWT> {
    return this.http.post<JWT>("http://localhost:8080/api/auth/login", { username: email, password: password });
  }

  refreshToken(): Observable<JWT> {
    const token = JSON.parse(localStorage.getItem('user-admin')).refreshToken
    const header = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': "Bearer " + token });

    return this.http.post<JWT>("http://localhost:8080/api/auth/refresh", token, { headers: header });
  }

  refreshTokenService() {
    this.refreshToken()
      .subscribe(
        data => {
          this.saveToken(data["accessToken"], data["accessTokenRefresh"]);
          window.location.reload();
        }, error => {
          localStorage.removeItem('user-admin');
          this.router.navigate(['/login']);
        }
      )
  }

  saveToken(token: String, refreshToken: string) {
    var localobj = JSON.parse(localStorage.getItem('user-admin'));

    localStorage.removeItem('user-admin');

    localStorage.setItem('user-admin', JSON.stringify({
      username: localobj.username,
      token: token,
      refreshToken: refreshToken,
      id: localobj.id,
      role: localobj.role
    }));
  }

  logOut(): void {
    localStorage.removeItem('user-admin');
    localStorage.removeItem('user-admin-hospital');
  }

  getId(): number {
    return localStorage.getItem('user-admin') ? JSON.parse(localStorage.getItem('user-admin')).id : 'INVALID';
  }

  getRole(): string {
    return localStorage.getItem('user-admin') ? JSON.parse(localStorage.getItem('user-admin')).role : 'INVALID';
  }

  getRefreshToken(): string {
    return localStorage.getItem('user-admin') ? JSON.parse(localStorage.getItem('user-admin')).refreshToken : 'INVALID';
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user-admin') !== null;
  }
}
