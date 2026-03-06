package tg.Ipnet.efunerailles.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.StatutDefunt;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "defunts")
public class Defunt extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable = false, length = 100)
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Column(nullable = false, length = 100)
    private String prenom;

    @NotNull(message = "La date de naissance est obligatoire")
    @Column(nullable = false)
    private LocalDate dateNaissance;

    @NotNull(message = "La date de décès est obligatoire")
    @Column(nullable = false)
    private LocalDate dateDeces;

    @NotBlank(message = "Le lieu de conservation est obligatoire")
    @Column(nullable = false, length = 150)
    private String lieuConservation;

    @Enumerated(EnumType.STRING)
    private StatutDefunt statut;

    @ManyToOne
    @JoinColumn(name = "famille_id", nullable = true) // Changé à true si pas encore de famille à la création
    @JsonIgnoreProperties("defunts") // Ne pas charger la liste des membres de la famille récursivement
    private Famille famille;

    @OneToMany(mappedBy = "defunt")
    @JsonIgnoreProperties("defunt")
    private List<Ceremonie> ceremonies;
}