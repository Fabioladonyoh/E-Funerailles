export interface DossierCard {
  code: string;
  status: 'En cours' | 'Planifié' | 'Terminé';
  deceasedName: string;
  date: string;
  time: string;
  contactName: string;
  phone: string;
  totalAmount: number;
  paidAmount: number;
}
