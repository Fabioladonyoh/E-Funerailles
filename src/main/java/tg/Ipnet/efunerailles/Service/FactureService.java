package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;
import tg.Ipnet.efunerailles.Entity.Facture;

public interface FactureService {
    List<Facture> getAllFactures();
    Optional<Facture> getFactureById(Long id);
    
    // CHANGE CECI : de createFacture(Facture f) à save(Facture f)
    Facture save(Facture facture); 
    
    Facture updateFacture(Long id, Facture factureDetails);
    void deleteFacture(Long id);
}