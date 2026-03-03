import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8181/api/auth'; // URL de base de votre API d'authentification

  constructor(private http: HttpClient) { }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signin`, credentials);
  }

  register(userInfo: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/signup`, userInfo);
  }
  

}
