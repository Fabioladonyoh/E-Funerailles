import { Defunt } from './defunt.model';

export interface Facture {
  id?: number;
  date: string;
  montantTotal: number; // Vérifie bien l'orthographe ici
  montantPaye: number;
  resteAPayer: number;
  statut: string;
  defunt: Defunt | { id: number };
}