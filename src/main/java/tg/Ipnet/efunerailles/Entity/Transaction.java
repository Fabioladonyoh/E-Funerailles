package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.*;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTransaction;
    private double montant;

    private String type; // "ENTREE" ou "SORTIE"
    private String description;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateTransaction() { return dateTransaction; }
    public void setDateTransaction(LocalDateTime dateTransaction) { this.dateTransaction = dateTransaction; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Facture getFacture() { return facture; }
    public void setFacture(Facture facture) { this.facture = facture; }
}