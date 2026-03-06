package tg.Ipnet.efunerailles.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Facture;
import tg.Ipnet.efunerailles.Entity.Paiement;
import tg.Ipnet.efunerailles.Repository.FactureRepository;
import tg.Ipnet.efunerailles.Repository.PaiementRepository;
import tg.Ipnet.efunerailles.Service.PaiementService;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository paiementRepository;
    private final FactureRepository factureRepository;

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    @Override
    @Transactional
    public Paiement savePaiement(Paiement paiement) {
        // 1. Vérification de la facture
        if (paiement.getFacture() == null || paiement.getFacture().getId() == null) {
            throw new RuntimeException("ID de facture manquant.");
        }

        Facture facture = factureRepository.findById(paiement.getFacture().getId())
                .orElseThrow(() -> new RuntimeException("Facture introuvable."));

        // 2. Mise à jour financière
        double nouveauMontantPaye = facture.getMontantPaye() + paiement.getMontant();
        facture.setMontantPaye(nouveauMontantPaye);
        
        // Appel de la méthode que nous avons ajoutée dans l'entité Facture
        facture.calculerResteAPayer();

        // 3. Préparation du paiement
        paiement.setFacture(facture);
        if (paiement.getDate() == null) {
            paiement.setDate(LocalDate.now());
        }

        // 4. Sauvegarde croisée
        factureRepository.save(facture);
        return paiementRepository.save(paiement);
    }

    @Override
    @Transactional
    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
        
        paiement.setMontant(paiementDetails.getMontant());
        paiement.setModePaiement(paiementDetails.getModePaiement());
        // Note: Pour un vrai update, il faudrait recalculer la facture ici aussi.
        return paiementRepository.save(paiement);
    }

    @Override
    @Transactional
    public void deletePaiement(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
        
        Facture facture = paiement.getFacture();
        if (facture != null) {
            facture.setMontantPaye(facture.getMontantPaye() - paiement.getMontant());
            facture.calculerResteAPayer();
            factureRepository.save(facture);
        }
        
        paiementRepository.deleteById(id);
    }
}