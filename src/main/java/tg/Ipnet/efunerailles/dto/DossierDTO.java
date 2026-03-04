package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import tg.Ipnet.efunerailles.Enums.StatutDossier;

@Data
public class DossierDTO {

    private Long id;

    private String numeroDossier;

    private LocalDate dateCeremonie;

    private LocalTime heureCeremonie;

    private String nomProche;

    private String telephoneProche;

    private StatutDossier statut;

    private Long defuntId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getDefuntId() {
		return defuntId;
	}

	public void setDefuntId(Long defuntId) {
		this.defuntId = defuntId;
	}
    
    
}