package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tg.Ipnet.efunerailles.Repository.PaiementRepository;
import tg.Ipnet.efunerailles.Repository.FactureRepository; // ✅ AJOUTE
import tg.Ipnet.efunerailles.Service.PaiementService;
import tg.Ipnet.efunerailles.Entity.Facture;
import tg.Ipnet.efunerailles.Entity.Paiement;
import tg.Ipnet.efunerailles.Enums.StatutFacture; // ✅ CORRIGÉ (pas Entity !)
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    @Autowired
    private FactureRepository factureRepository; // ✅ AJOUTE

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    @Override
    public Paiement createPaiement(Paiement paiement) {
        return savePaiement(paiement); // 🔥 utilise la logique métier
    }

    @Override
    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found with id " + id));

        paiement.setMontant(paiementDetails.getMontant());
        paiement.setDate(paiementDetails.getDate());
        paiement.setFacture(paiementDetails.getFacture());

        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement not found with id " + id));
        paiementRepository.delete(paiement);
    }
    
    

    

    // 🔥 LOGIQUE METIER PROPRE
    @Override
    public Paiement savePaiement(Paiement paiement) {

        Facture facture = paiement.getFacture();

        if (facture == null) {
            throw new RuntimeException("Une facture est obligatoire pour un paiement");
        }

        // Mise à jour montant payé
        Double nouveauMontantPaye = facture.getMontantPaye() + paiement.getMontant();
        facture.setMontantPaye(nouveauMontantPaye);

        // ✅ Comparaison propre avec Double
        if (nouveauMontantPaye <= 0) {
            facture.setStatut(StatutFacture.NON_PAYEE);
        } 
        else if (nouveauMontantPaye < facture.getMontantTotal()) {
            facture.setStatut(StatutFacture.PARTIELLEMENT_PAYEE);
        } 
        else {
            facture.setStatut(StatutFacture.PAYEE);
        }

        factureRepository.save(facture);

        return paiementRepository.save(paiement);
    }
}