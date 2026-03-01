package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;
import tg.Ipnet.efunerailles.Entity.Corbillard;
import tg.Ipnet.efunerailles.Entity.Defunt;

public class ReservationDTO {
	
	    private Long id;
	    private LocalDate dateDebut;
	    private LocalDate dateFin;
	    private String typeReservation;
	    private Defunt defunt;
	    private Corbillard corbillard;
	    
	    public ReservationDTO() {
	    	
	    }
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(LocalDate dateDebut) {
			this.dateDebut = dateDebut;
		}
		public LocalDate getDateFin() {
			return dateFin;
		}
		public void setDateFin(LocalDate dateFin) {
			this.dateFin = dateFin;
		}
		public String getTypeReservation() {
			return typeReservation;
		}
		public void setTypeReservation(String typeReservation) {
			this.typeReservation = typeReservation;
		}
		public Defunt getDefunt() {
			return defunt;
		}
		public void setDefunt(Defunt defunt) {
			this.defunt = defunt;
		}
		public Corbillard getCorbillard() {
			return corbillard;
		}
		public void setCorbillard(Corbillard corbillard) {
			this.corbillard = corbillard;
		}
	    
	    


}
