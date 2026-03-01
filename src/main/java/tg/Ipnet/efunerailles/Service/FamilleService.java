package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.Famille;

public interface FamilleService {
	
	 List<Famille> getAllFamilles();
	    Optional<Famille> getFamilleById(Long id);
	    Famille createFamille(Famille famille);
	    Famille updateFamille(Long id, Famille familleDetails);
	    void deleteFamille(Long id);


}
