import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DossierCard } from '../models/dossier.model';

@Injectable({
  providedIn: 'root'
})
export class DossierService {
  private apiUrl = 'http://localhost:8181/api/dossiers'; // À confirmer

  constructor(private http: HttpClient) { }

  getAllDossiers(): Observable<DossierCard[]> {
    return this.http.get<DossierCard[]>(this.apiUrl);
  }

  getDossierById(id: number): Observable<DossierCard> {
    return this.http.get<DossierCard>(`${this.apiUrl}/${id}`);
  }

  createDossier(dossier: DossierCard): Observable<DossierCard> {
    return this.http.post<DossierCard>(this.apiUrl, dossier);
  }

  updateDossier(id: number, dossier: DossierCard): Observable<DossierCard> {
    return this.http.put<DossierCard>(`${this.apiUrl}/${id}`, dossier);
  }

  deleteDossier(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
