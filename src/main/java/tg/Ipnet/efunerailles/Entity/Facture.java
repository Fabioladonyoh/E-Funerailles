package tg.Ipnet.efunerailles.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.StatutFacture;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "factures")
public class Facture extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Double montantTotal;

    @NotNull
    @Column(nullable = false)
    private Double montantPaye;

    
    private Double resteAPayer;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private StatutFacture statut;
    
    @OneToOne
    @JoinColumn(name = "defunt_id", nullable = false)
    private Defunt defunt;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<Paiement> paiements;
    
    @OneToOne
    @JoinColumn(name = "dossier_id", nullable = false)
    private Dossier dossier;


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
	    return montantTotal - montantPaye;
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


	@PrePersist
	@PreUpdate
	private void calculateReste() {
	    if (montantTotal != null && montantPaye != null) {
	        this.resteAPayer = montantTotal - montantPaye;
	    }
	}
	
	
	public StatutFacture getStatut() {
		return statut;
	}

	public void setStatut(StatutFacture statut) {
		this.statut = statut;
	}

	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public Defunt getDefunt() {
		return defunt;
	}

	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}
    
    
}
