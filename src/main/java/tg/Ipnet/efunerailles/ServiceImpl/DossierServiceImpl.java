package tg.Ipnet.efunerailles.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Dossier;
import tg.Ipnet.efunerailles.Repository.DossierRepository;
import tg.Ipnet.efunerailles.Service.DossierService;

@Service
@RequiredArgsConstructor
public class DossierServiceImpl implements DossierService {

    private final DossierRepository dossierRepository ;

    public DossierServiceImpl(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }
    
    @Override
    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }

    @Override
    public Dossier getDossierById(Long id) {
        return dossierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier non trouvé avec l'id : " + id));
    }

    @Override
    public Dossier createDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public Dossier updateDossier(Long id, Dossier dossierDetails) {

        Dossier dossier = dossierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier non trouvé avec l'id : " + id));

        dossier.setNumeroDossier(dossierDetails.getNumeroDossier());
        dossier.setDateCeremonie(dossierDetails.getDateCeremonie());
        dossier.setHeureCeremonie(dossierDetails.getHeureCeremonie());
        dossier.setNomProche(dossierDetails.getNomProche());
        dossier.setTelephoneProche(dossierDetails.getTelephoneProche());
        dossier.setStatut(dossierDetails.getStatut());
        dossier.setDefunt(dossierDetails.getDefunt());

        return dossierRepository.save(dossier);
    }

    @Override
    public void deleteDossier(Long id) {

        if (!dossierRepository.existsById(id)) {
            throw new RuntimeException("Dossier non trouvé avec l'id : " + id);
        }

        dossierRepository.deleteById(id);
    }
}