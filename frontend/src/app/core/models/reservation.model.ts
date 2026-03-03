import { Cercueil } from './cercueil.model';
import { Corbillard } from './corbillard.model';
import { Defunt } from './defunt.model';

export interface Reservation {
  id: number;
  dateReservation: Date;
  cercueil: Cercueil;
  corbillard: Corbillard;
  defunt: Defunt;
}
