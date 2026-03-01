package tg.Ipnet.efunerailles.Entity;


import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cercueils")
public class Cercueil extends BaseEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Column(nullable = false, length = 100)
	    private String modele;

	    @NotBlank
	    @Column(nullable = false, length = 100)
	    private String materiau;

	    @NotNull
	    @Column(nullable = false)
	    private Double prix;

	    @NotNull
	    @Column(nullable = false)
	    private Integer stockDisponible;
	    
	    @OneToMany(mappedBy = "cercueil")
	    private List<Reservation> reservations;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getMateriau() {
		return materiau;
	}
	public void setMateriau(String materiau) {
		this.materiau = materiau;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getStockDisponible() {
		return stockDisponible;
	}
	public void setStockDisponible(Integer stockDisponible) {
		this.stockDisponible = stockDisponible;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Cercueil orElse(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
    
	
    
}