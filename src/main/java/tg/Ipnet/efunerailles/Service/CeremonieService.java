package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.Ceremonie;

public interface CeremonieService {
	
	  List<Ceremonie> getAllCeremonies();
	    Optional<Ceremonie> getCeremonieById(Long id);
	    Ceremonie createCeremonie(Ceremonie ceremonie);
	    Ceremonie updateCeremonie(Long id, Ceremonie ceremonieDetails);
	    void deleteCeremonie(Long id);

}
