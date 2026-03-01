package tg.Ipnet.efunerailles.dto;

import java.util.List;

import tg.Ipnet.efunerailles.Entity.Defunt;

public class FamilleDTO {
	
    private Long id;
    private String nomResponsable;
    private String prenomResponsable;
    private String telephone;
    private String adresse;
    private String email;
    private List<Defunt> defunts;
    
    public FamilleDTO() {
    	
    }
    
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
