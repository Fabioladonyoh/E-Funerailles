package tg.Ipnet.efunerailles.Entity;

import jakarta.persistence.*;
import tg.Ipnet.efunerailles.Utils.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "planning")
public class Planning extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ceremonie_id")
    private Ceremonie ceremonie;

    @ManyToOne
    @JoinColumn(name = "corbillard_id")
    private Corbillard corbillard;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private User responsable;

    private LocalDateTime dateDebut;
    
    private LocalDateTime dateFin;

    
    public Long getId() {
    	return id; 
    	}
    
    public void setId(Long id) {
    	this.id = id;
    	}

    public Ceremonie getCeremonie() { 
    	return ceremonie;
    	}
    
    public void setCeremonie(Ceremonie ceremonie) { 
    	this.ceremonie = ceremonie; 
    	}

    public Corbillard getCorbillard() { 
    	return corbillard;
    	}
    
    public void setCorbillard(Corbillard corbillard) {
    	this.corbillard = corbillard;
    	}

    public User getResponsable() {
    	return responsable;
    	}
    
    public void setResponsable(User responsable) {
    	this.responsable = responsable;
    	}

    public LocalDateTime getDateDebut() {
    	return dateDebut;
    	}
    
    public void setDateDebut(LocalDateTime dateDebut) { 
    	this.dateDebut = dateDebut; 
    	}

    public LocalDateTime getDateFin() { 
    	return dateFin; 
    	}
    
    public void setDateFin(LocalDateTime dateFin) {
    	this.dateFin = dateFin;
}
    
}