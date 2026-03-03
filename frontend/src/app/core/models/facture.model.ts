import { Defunt } from './defunt.model';

export interface Facture {
  id: number;
  montant: number;
  dateFacturation: Date;
  statut: string;
  defunt: Defunt;
}
