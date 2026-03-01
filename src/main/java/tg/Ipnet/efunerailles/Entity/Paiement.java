package tg.Ipnet.efunerailles.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.ModePaiement;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "paiements")
public class Paiement extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Double montant;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;


    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "facture_id", nullable = false)
    private Facture facture;
    
    
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

	

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
    
    
}