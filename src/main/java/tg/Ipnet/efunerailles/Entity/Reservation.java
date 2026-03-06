package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.TypeReservation;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter // Génère tous les getters automatiquement
@Setter // Génère tous les setters automatiquement
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de début est obligatoire")
    @Column(nullable = false)
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    @Column(nullable = false)
    private LocalDate dateFin;

    // ✅ CORRECTION : Suppression de @NotBlank (qui causait l'erreur HV000030)
    @NotNull(message = "Le type de réservation est obligatoire")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    private TypeReservation typeReservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "defunt_id", nullable = false)
    @NotNull(message = "Le défunt est obligatoire")
    private Defunt defunt;

    @ManyToOne
    @JoinColumn(name = "corbillard_id")
    private Corbillard corbillard;
    
    @ManyToOne
    @JoinColumn(name = "cercueil_id")
    private Cercueil cercueil;
}