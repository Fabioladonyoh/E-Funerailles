import { Famille } from './famille.model';

export interface Defunt {
  id: number;
  nom: string;
  prenom: string;
  dateNaissance: Date;
  dateDeces: Date;
  lieuDeces: string;
  famille: Famille;
}
