package tg.Ipnet.efunerailles.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.StatutFacture;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "factures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facture extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le montant total est obligatoire")
    @Column(nullable = false)
    @Builder.Default
    private Double montantTotal = 0.0;

    @NotNull(message = "Le montant payé est obligatoire")
    @Column(nullable = false)
    @Builder.Default
    private Double montantPaye = 0.0;

    @NotNull(message = "Le reste à payer est obligatoire")
    @Column(nullable = false)
    @Builder.Default
    private Double resteAPayer = 0.0;

    @NotNull(message = "La date de facturation est obligatoire")
    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatutFacture statut = StatutFacture.NON_PAYEE;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "defunt_id", nullable = false, unique = true)
    @JsonIgnoreProperties({"famille", "ceremonies", "statut", "createdAt", "updatedAt"}) 
    private Defunt defunt;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference 
    private List<Paiement> paiements;

    /**
     * Calcule la valeur théorique du reste à payer.
     */
    public Double getCalculatedReste() {
        double total = (this.montantTotal != null) ? this.montantTotal : 0.0;
        double paye = (this.montantPaye != null) ? this.montantPaye : 0.0;
        return total - paye;
    }

    /**
     * SYNCHRONISATION : Cette méthode met à jour physiquement le champ 
     * resteAPayer et le statut pour la base de données.
     */
    public void calculerResteAPayer() {
        this.resteAPayer = this.getCalculatedReste();
        
        if (this.resteAPayer <= 0) {
            this.statut = StatutFacture.PAYEE;
            this.resteAPayer = 0.0; // Évite les restes négatifs en cas de trop-perçu
        } else if (this.montantPaye > 0) {
            this.statut = StatutFacture.PARTIELLEMENT_PAYEE;
        } else {
            this.statut = StatutFacture.NON_PAYEE;
        }
    }
}