package tg.Ipnet.efunerailles.dto;

import java.time.LocalDate;

import tg.Ipnet.efunerailles.Entity.Defunt;

public class CeremonieDTO {
	
	private Long id;
    private LocalDate date;
    private String lieu;
    private Defunt defunt;
    
    public CeremonieDTO() {
    	
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Defunt getDefunt() {
		return defunt;
	}
	public void setDefunt(Defunt defunt) {
		this.defunt = defunt;
	}
    
    

}
