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
    const token = JSON.parse(localStorage.getItem('user')).refreshToken
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
          localStorage.removeItem('user');
          this.router.navigate(['/login']);
        }
      )
  }

  saveToken(token: String, refreshToken: string) {
    var localobj = JSON.parse(localStorage.getItem('user'));

    localStorage.removeItem('user');

    localStorage.setItem('user', JSON.stringify({
      username: localobj.username,
      token: token,
      refreshToken: refreshToken,
      id: localobj.id,
      role: localobj.role
    }));
  }

  logOut(): void {
    localStorage.removeItem('user');
  }

  getId(): number {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).id : 'INVALID';
  }

  getRole(): string {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).role : 'INVALID';
  }

  getRefreshToken(): string {
    return localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).refreshToken : 'INVALID';
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('user') !== null;
  }
}
