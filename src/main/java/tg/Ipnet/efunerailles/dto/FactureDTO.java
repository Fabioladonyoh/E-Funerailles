package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;
import java.util.List;

import tg.Ipnet.efunerailles.Entity.Defunt;
import tg.Ipnet.efunerailles.Entity.Paiement;

public class FactureDTO {
	
	    private Long id;
	    private Double montantTotal;
	    private Double montantPaye;
	    private Double resteAPayer;
	    private LocalDate date;
	    private String statut;
	    private Defunt defunt;
	    private List<Paiement> paiements;
	    
	    public FactureDTO() {
	    	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Double getMontantTotal() {
			return montantTotal;
		}

		public void setMontantTotal(Double montantTotal) {
			this.montantTotal = montantTotal;
		}

		public Double getMontantPaye() {
			return montantPaye;
		}

		public void setMontantPaye(Double montantPaye) {
			this.montantPaye = montantPaye;
		}

		public Double getResteAPayer() {
			return resteAPayer;
		}

		public void setResteAPayer(Double resteAPayer) {
			this.resteAPayer = resteAPayer;
		}

		public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

		public String getStatut() {
			return statut;
		}

		public void setStatut(String statut) {
			this.statut = statut;
		}

		public Defunt getDefunt() {
			return defunt;
		}

		public void setDefunt(Defunt defunt) {
			this.defunt = defunt;
		}

		public List<Paiement> getPaiements() {
			return paiements;
		}

		public void setPaiements(List<Paiement> paiements) {
			this.paiements = paiements;
		}
	    
	    


}
