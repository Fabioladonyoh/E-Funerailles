package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tg.Ipnet.efunerailles.Entity.Facture;
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

    @Override
    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture updateFacture(Long id, Facture factureDetails) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id " + id));
        facture.setDate(factureDetails.getDate());
        facture.setMontantTotal(factureDetails.getMontantTotal());
        facture.setMontantPaye(factureDetails.getMontantPaye());
        facture.setResteAPayer(factureDetails.getResteAPayer());
        facture.setDefunt(factureDetails.getDefunt());
        facture.setStatut(factureDetails.getStatut());
        return factureRepository.save(facture);
    }

    @Override
    public void deleteFacture(Long id) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id " + id));
        factureRepository.delete(facture);
    }
}