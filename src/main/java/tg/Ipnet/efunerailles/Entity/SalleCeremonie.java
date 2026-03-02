package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import tg.Ipnet.efunerailles.Enums.StatutSalle;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

@Entity
public class SalleCeremonie extends BaseEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String nom;

    private Integer capacite;

    @Enumerated(EnumType.STRING)
    private StatutSalle statut;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public StatutSalle getStatut() {
		return statut;
	}

	public void setStatut(StatutSalle statut) {
		this.statut = statut;
	}
    
    
}