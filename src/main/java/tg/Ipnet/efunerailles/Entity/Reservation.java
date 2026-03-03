package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.TypeReservation;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reservations")
public class Reservation extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateDebut;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateFin;

    @NotBlank
    @Column(nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private TypeReservation typeReservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "defunt_id", nullable = false)
    private Defunt defunt;

    @ManyToOne(optional = true)
    @JoinColumn(name = "corbillard_id")
    private Corbillard corbillard;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "cercueil_id")
    private Cercueil cercueil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	

	public TypeReservation getTypeReservation() {
		return typeReservation;
	}

	public void setTypeReservation(TypeReservation typeReservation) {
		this.typeReservation = typeReservation;
	}

	public Defunt getDefunt() {
		return defunt;
	}

	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}

	public Corbillard getCorbillard() {
		return corbillard;
	}

	public void setCorbillard(Corbillard corbillard) {
		this.corbillard = corbillard;
	}

	public Cercueil getCercueil() {
		return cercueil;
	}

	public void setCercueil(Cercueil cercueil) {
		this.cercueil = cercueil;
	}

	
	
    
    
}
