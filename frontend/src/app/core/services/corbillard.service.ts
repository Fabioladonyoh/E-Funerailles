import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Corbillard } from '../models/corbillard.model';

@Injectable({
  providedIn: 'root'
})
export class CorbillardService {
  private apiUrl = 'http://localhost:8181/api/corbillards'; // À confirmer

  constructor(private http: HttpClient) { }

  getAllCorbillards(): Observable<Corbillard[]> {
    return this.http.get<Corbillard[]>(this.apiUrl);
  }

  getCorbillardById(id: number): Observable<Corbillard> {
    return this.http.get<Corbillard>(`${this.apiUrl}/${id}`);
  }

  createCorbillard(corbillard: Corbillard): Observable<Corbillard> {
    return this.http.post<Corbillard>(this.apiUrl, corbillard);
  }

  updateCorbillard(id: number, corbillard: Corbillard): Observable<Corbillard> {
    return this.http.put<Corbillard>(`${this.apiUrl}/${id}`, corbillard);
  }

  deleteCorbillard(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
