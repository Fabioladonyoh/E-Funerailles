package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.StatutDefunt;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "defunts")
public class Defunt extends BaseEntity{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Column(nullable = false, length = 100)
	    private String nom;

	    @NotBlank
	    @Column(nullable = false, length = 100)
	    private String prenom;

	    @NotNull
	    @Column(nullable = false)
	    private LocalDate dateNaissance;

	    @NotNull
	    @Column(nullable = false)
	    private LocalDate dateDeces;

	    @NotBlank
	    @Column(nullable = false, length = 150)
	    private String lieuConservation;

	    @Enumerated(EnumType.STRING)
	    private StatutDefunt statut;

	    @ManyToOne
	    @JoinColumn(name = "famille_id", nullable = false)
	    private Famille famille;

        @OneToMany(mappedBy = "defunt")
        private List<Ceremonie> ceremonies;

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


	public StatutDefunt getStatut() {
		return statut;
	}

	public void setStatut(StatutDefunt statut) {
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