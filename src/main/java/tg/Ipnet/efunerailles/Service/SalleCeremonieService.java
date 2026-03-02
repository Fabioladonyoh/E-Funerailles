package tg.Ipnet.efunerailles.Service;

import java.util.List;
import tg.Ipnet.efunerailles.Entity.SalleCeremonie;
import tg.Ipnet.efunerailles.dto.SalleCeremonieDTO;

public interface SalleCeremonieService {
	
    List<SalleCeremonie> getAllSalles();
    SalleCeremonie getSalleById(Long id);
    SalleCeremonie createSalle(SalleCeremonieDTO dto);
    SalleCeremonie updateSalle(Long id, SalleCeremonieDTO dto);
    void deleteSalle(Long id);
    
}