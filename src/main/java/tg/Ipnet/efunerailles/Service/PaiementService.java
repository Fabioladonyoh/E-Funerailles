package tg.Ipnet.efunerailles.Service;

import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.Paiement;

public interface PaiementService {
    List<Paiement> getAllPaiements();
    Optional<Paiement> getPaiementById(Long id);
    
    // Nous utilisons savePaiement comme nom standard
    Paiement savePaiement(Paiement paiement); 
    
    Paiement updatePaiement(Long id, Paiement paiementDetails);
    void deletePaiement(Long id);
}