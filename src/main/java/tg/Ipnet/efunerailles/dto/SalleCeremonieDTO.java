package tg.Ipnet.efunerailles.dto;

import tg.Ipnet.efunerailles.Enums.StatutSalle;

public class SalleCeremonieDTO {
	
    private String nom;
    private Integer capacite;
    private StatutSalle statut;


    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Integer getCapacite() { return capacite; }
    public void setCapacite(Integer capacite) { this.capacite = capacite; }

    public StatutSalle getStatut() { return statut; }
    public void setStatut(StatutSalle statut) { this.statut = statut; }
}