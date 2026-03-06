import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class DossierService {
  private apiUrl = 'http://localhost:8181/api/factures/dossiers';

  constructor(private http: HttpClient) { }

  // Utilisation de any ou d'une interface DossierRequest pour la création
  createDossier(dossier: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, dossier);
  }

  getAllDossiers(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
}