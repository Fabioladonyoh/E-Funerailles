export interface KpiCard {
  icon: string;
  title: string;
  value: string;
  color: string;
}

export interface PaymentDistribution {
  name: string;
  percentage: number;
  color: string;
}

export interface Dossier {
  code: string;
  deceasedName: string;
  ceremonyDate: string;
  amount: number;
  status: 'En cours' | 'Planifié' | 'Terminé';
}
