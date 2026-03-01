package tg.Ipnet.efunerailles.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "familles")
public class Famille extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nomResponsable;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String prenomResponsable;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(length = 200)
    private String adresse;

    
    @Column(length = 150)
    private String email;

    @OneToMany(mappedBy = "famille", cascade = CascadeType.ALL)
    private List<Defunt> defunts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomResponsable() {
		return nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	public String getPrenomResponsable() {
		return prenomResponsable;
	}

	public void setPrenomResponsable(String prenomResponsable) {
		this.prenomResponsable = prenomResponsable;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Defunt> getDefunts() {
		return defunts;
	}

	public void setDefunts(List<Defunt> defunts) {
		this.defunts = defunts;
	}
    
    
    
    
}