package tg.Ipnet.efunerailles.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import tg.Ipnet.efunerailles.Enums.StatutDossier;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "dossiers")
public class Dossier extends BaseEntity{
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
	private String numeroDossier;

    @NotBlank
    @Column(nullable = false)
	private LocalDate dateCeremonie;
	

    @NotBlank
    @Column(nullable = false, length = 100)
	private LocalTime heureCeremonie;
	

    @NotBlank
    @Column(nullable = false, length = 100)
	private String nomProche;
	

    @NotBlank
    @Column(nullable = false, length = 100)
	private String telephoneProche;
	
	@Enumerated(EnumType.STRING)
	private StatutDossier statut;
	
	 @OneToOne(mappedBy = "dossier", cascade = CascadeType.ALL)
	    private Facture facture;
	
	@ManyToOne
	@JoinColumn(name = "defunt_id", nullable = false)
	private Defunt defunt;
	
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	
	public LocalDate getDateCeremonie() {
		return dateCeremonie;
	}
	public void setDateCeremonie(LocalDate dateCeremonie) {
		this.dateCeremonie = dateCeremonie;
	}
	public LocalTime getHeureCeremonie() {
		return heureCeremonie;
	}
	public void setHeureCeremonie(LocalTime heureCeremonie) {
		this.heureCeremonie = heureCeremonie;
	}
	public String getNomProche() {
		return nomProche;
	}
	public void setNomProche(String nomProche) {
		this.nomProche = nomProche;
	}
	public String getTelephoneProche() {
		return telephoneProche;
	}
	public void setTelephoneProche(String telephoneProche) {
		this.telephoneProche = telephoneProche;
	}

	public StatutDossier getStatut() {
		return statut;
	}
	public void setStatut(StatutDossier statut) {
		this.statut = statut;
	}
	public Defunt getDefunt() {
		return defunt;
	}
	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}
	
	

}
