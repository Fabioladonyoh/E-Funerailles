package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import tg.Ipnet.efunerailles.Entity.Facture;
import tg.Ipnet.efunerailles.Enums.StatutFacture;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.FactureRepository;
import tg.Ipnet.efunerailles.Service.FactureService;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Override
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    /**
     * Cette méthode remplace 'createFacture' pour correspondre à l'interface.
     * Elle gère aussi bien la création que la mise à jour (save standard JPA).
     */
    @Override
    @Transactional
    public Facture save(Facture facture) {
        // Sécurité : Calcul automatique du reste à payer avant l'insertion
        if (facture.getMontantTotal() != null) {
            double montantPaye = (facture.getMontantPaye() != null) ? facture.getMontantPaye() : 0.0;
            facture.setResteAPayer(facture.getMontantTotal() - montantPaye);
        }
        
        // Logique optionnelle : Si c'est une nouvelle facture, on peut définir un statut par défaut
       if (facture.getId() == null && facture.getStatut() == null) {
    facture.setStatut(StatutFacture.NON_PAYEE); // Utilise l'Enum directement
}

        return factureRepository.save(facture);
    }

    @Override
    @Transactional
    public Facture updateFacture(Long id, Facture factureDetails) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture introuvable avec l'id : " + id));
        
        // Mise à jour des champs
        facture.setDate(factureDetails.getDate());
        facture.setMontantTotal(factureDetails.getMontantTotal());
        facture.setMontantPaye(factureDetails.getMontantPaye());
        
        // Recalcul du reste à payer lors de la mise à jour
        if (facture.getMontantTotal() != null) {
            double paye = (facture.getMontantPaye() != null) ? facture.getMontantPaye() : 0.0;
            facture.setResteAPayer(facture.getMontantTotal() - paye);
        }
        
        facture.setDefunt(factureDetails.getDefunt());
        facture.setStatut(factureDetails.getStatut());
        
        return factureRepository.save(facture);
    }

    @Override
    @Transactional
    public void deleteFacture(Long id) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture introuvable avec l'id : " + id));
        factureRepository.delete(facture);
    }
}