package tg.Ipnet.efunerailles.dto;

import java.time.LocalDateTime;

public class PlanningDTO {
	
    private Long ceremonieId;
    
    private Long corbillardId;
    
    private Long responsableId;
    
    private LocalDateTime dateDebut;
    
    private LocalDateTime dateFin;

   
    public Long getCeremonieId() { return ceremonieId; }
    public void setCeremonieId(Long ceremonieId) { this.ceremonieId = ceremonieId; }

    public Long getCorbillardId() { return corbillardId; }
    public void setCorbillardId(Long corbillardId) { this.corbillardId = corbillardId; }

    public Long getResponsableId() { return responsableId; }
    public void setResponsableId(Long responsableId) { this.responsableId = responsableId; }

    public LocalDateTime getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut = dateDebut; }

    public LocalDateTime getDateFin() { return dateFin; }
    public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }
}