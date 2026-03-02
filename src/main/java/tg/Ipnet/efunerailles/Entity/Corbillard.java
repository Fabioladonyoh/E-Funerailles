package tg.Ipnet.efunerailles.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Enums.StatutCorbillard;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "corbillards")
public class Corbillard extends BaseEntity{

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(unique = true)
	    private String code;

	    @NotBlank
	    @Column(nullable = false, unique = true, length = 50)
	    private String immatriculation;

	    @NotBlank
	    @Column(nullable = false, length = 100)
	    private String marque;

	    @NotNull
	    @Column(nullable = false)
	    private Boolean disponibilite;
    
	    @Enumerated(EnumType.STRING)
	    private StatutCorbillard statut;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Boolean getDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}
	public Corbillard orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
