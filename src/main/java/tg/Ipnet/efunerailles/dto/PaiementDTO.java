package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;
import tg.Ipnet.efunerailles.Entity.Facture;

public class PaiementDTO {
	
    	private Long id;
	    private Double montant;
	    private LocalDate date;
	    private String modePaiement;
	    private Facture facture;
	    
	    public PaiementDTO() {
	    	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Double getMontant() {
			return montant;
		}

		public void setMontant(Double montant) {
			this.montant = montant;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public String getModePaiement() {
			return modePaiement;
		}

		public void setModePaiement(String modePaiement) {
			this.modePaiement = modePaiement;
		}

		public Facture getFacture() {
			return facture;
		}

		public void setFacture(Facture facture) {
			this.facture = facture;
		}
	    
	    

}
