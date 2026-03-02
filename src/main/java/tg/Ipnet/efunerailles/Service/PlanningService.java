package tg.Ipnet.efunerailles.Service;

import java.util.List;
import tg.Ipnet.efunerailles.Entity.Planning;
import tg.Ipnet.efunerailles.dto.PlanningDTO;

public interface PlanningService {
	
    List<Planning> getAllPlannings();
    Planning getPlanningById(Long id);
    Planning createPlanning(PlanningDTO planningDTO);
    Planning updatePlanning(Long id, PlanningDTO planningDTO);
    void deletePlanning(Long id);
    
}