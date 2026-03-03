import { Facture } from './facture.model';

export interface Paiement {
  id: number;
  montant: number;
  datePaiement: Date;
  methode: string;
  facture: Facture;
}
