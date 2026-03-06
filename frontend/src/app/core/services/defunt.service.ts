import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Defunt } from '../models/defunt.model';

@Injectable({
  providedIn: 'root'
})
export class DefuntService {
  private apiUrl = 'http://localhost:8181/api/defunts'; // À confirmer

  constructor(private http: HttpClient) { }

  getAllDefunts(): Observable<Defunt[]> {
    return this.http.get<Defunt[]>(this.apiUrl);
  }

  getDefuntById(id: number): Observable<Defunt> {
    return this.http.get<Defunt>(`${this.apiUrl}/${id}`);
  }

  // Dans defunt.service.ts
createDefunt(defunt: Partial<Defunt>): Observable<Defunt> {
  return this.http.post<Defunt>(this.apiUrl, defunt);
}

  updateDefunt(id: number, defunt: Defunt): Observable<Defunt> {
    return this.http.put<Defunt>(`${this.apiUrl}/${id}`, defunt);
  }

  deleteDefunt(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
