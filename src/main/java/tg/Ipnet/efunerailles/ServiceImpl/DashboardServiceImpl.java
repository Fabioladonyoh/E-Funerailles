package tg.Ipnet.efunerailles.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Repository.DossierRepository;
import tg.Ipnet.efunerailles.Repository.FactureRepository;
import tg.Ipnet.efunerailles.Repository.PaiementRepository;
import tg.Ipnet.efunerailles.Service.DashboardService;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final DossierRepository dossierRepository;
    private final FactureRepository factureRepository;
    private final PaiementRepository paiementRepository;

    public DashboardServiceImpl(
            DossierRepository dossierRepository,
            FactureRepository factureRepository,
            PaiementRepository paiementRepository) {

        this.dossierRepository = dossierRepository;
        this.factureRepository = factureRepository;
        this.paiementRepository = paiementRepository;
    }
    
    @Override
    public Map<String, Object> getDashboardData() {

        Map<String, Object> dashboard = new HashMap<>();

        dashboard.put("totalDossiers", dossierRepository.countTotalDossiers());
        dashboard.put("dossiersPlanifies", dossierRepository.countPlanifie());
        dashboard.put("dossiersEnCours", dossierRepository.countEnCours());
        dashboard.put("dossiersTermines", dossierRepository.countTermine());

        dashboard.put("chiffreAffaires", factureRepository.getChiffreAffairesTotal());
        dashboard.put("resteAPayer", factureRepository.getTotalResteAPayer());

        dashboard.put("totalEncaisse", paiementRepository.getTotalEncaisse());

        dashboard.put("repartitionPaiement", paiementRepository.getRepartitionParMode());

        return dashboard;
    }
}