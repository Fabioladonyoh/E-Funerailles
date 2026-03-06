import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paiement } from '../models/paiement.model';

@Injectable({ providedIn: 'root' })
export class PaiementService {
  private apiUrl = 'http://localhost:8181/api/paiements';

  constructor(private http: HttpClient) { }

  getAllPaiements(): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(this.apiUrl);
  }

  // IMPORTANT : Récupérer tous les versements d'une seule facture
  getPaiementsByFacture(factureId: number): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(`${this.apiUrl}/facture/${factureId}`);
  }

  getPaiementById(id: number): Observable<Paiement> {
    return this.http.get<Paiement>(`${this.apiUrl}/${id}`);
  }

  // Rappel : Ton backend met à jour le reste à payer de la facture automatiquement ici
  createPaiement(paiement: Partial<Paiement>): Observable<Paiement> {
    return this.http.post<Paiement>(this.apiUrl, paiement);
  }

  deletePaiement(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}