package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.Facture;

public interface FactureService {
	
	 List<Facture> getAllFactures();
	    Optional<Facture> getFactureById(Long id);
	    Facture createFacture(Facture facture);
	    Facture updateFacture(Long id, Facture factureDetails);
	    void deleteFacture(Long id);

}
