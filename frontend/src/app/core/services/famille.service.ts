import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Famille } from '../models/famille.model';

@Injectable({
  providedIn: 'root'
})
export class FamilleService {
  private apiUrl = 'http://localhost:8181/api/familles'; // À confirmer

  constructor(private http: HttpClient) { }

  getAllFamilles(): Observable<Famille[]> {
    return this.http.get<Famille[]>(this.apiUrl);
  }

  getFamilleById(id: number): Observable<Famille> {
    return this.http.get<Famille>(`${this.apiUrl}/${id}`);
  }

  createFamille(famille: Famille): Observable<Famille> {
    return this.http.post<Famille>(this.apiUrl, famille);
  }

  updateFamille(id: number, famille: Famille): Observable<Famille> {
    return this.http.put<Famille>(`${this.apiUrl}/${id}`, famille);
  }

  deleteFamille(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
