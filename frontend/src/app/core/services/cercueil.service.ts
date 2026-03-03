import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cercueil } from '../models/cercueil.model';

@Injectable({
  providedIn: 'root'
})
export class CercueilService {
  private apiUrl = 'http://localhost:8181/api/cercueils'; // TODO: Remplacer par le lien API réel

  constructor(private http: HttpClient) { }

  getAllCercueils(): Observable<Cercueil[]> {
    return this.http.get<Cercueil[]>(this.apiUrl);
  }

  getCercueilById(id: number): Observable<Cercueil> {
    return this.http.get<Cercueil>(`${this.apiUrl}/${id}`);
  }

  createCercueil(cercueil: Cercueil): Observable<Cercueil> {
    return this.http.post<Cercueil>(this.apiUrl, cercueil);
  }

  updateCercueil(id: number, cercueil: Cercueil): Observable<Cercueil> {
    return this.http.put<Cercueil>(`${this.apiUrl}/${id}`, cercueil);
  }

  deleteCercueil(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
