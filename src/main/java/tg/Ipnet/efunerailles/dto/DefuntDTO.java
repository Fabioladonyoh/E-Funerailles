package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;
import java.util.List;
import tg.Ipnet.efunerailles.Entity.Ceremonie;
import tg.Ipnet.efunerailles.Entity.Famille;

public class DefuntDTO {

	  private Long id;
	    private String nom;
	    private String prenom;
	    private LocalDate dateNaissance;
	    private LocalDate dateDeces;
	    private String lieuConservation;
	    private String statut;
	    private Famille famille;
        private List<Ceremonie> ceremonies;
        
        public DefuntDTO() {
        	
        }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public LocalDate getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(LocalDate dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public LocalDate getDateDeces() {
			return dateDeces;
		}

		public void setDateDeces(LocalDate dateDeces) {
			this.dateDeces = dateDeces;
		}

		public String getLieuConservation() {
			return lieuConservation;
		}

		public void setLieuConservation(String lieuConservation) {
			this.lieuConservation = lieuConservation;
		}

		public String getStatut() {
			return statut;
		}

		public void setStatut(String statut) {
			this.statut = statut;
		}

		public Famille getFamille() {
			return famille;
		}

		public void setFamille(Famille famille) {
			this.famille = famille;
		}

		public List<Ceremonie> getCeremonies() {
			return ceremonies;
		}

		public void setCeremonies(List<Ceremonie> ceremonies) {
			this.ceremonies = ceremonies;
		}
        
        

	
}
