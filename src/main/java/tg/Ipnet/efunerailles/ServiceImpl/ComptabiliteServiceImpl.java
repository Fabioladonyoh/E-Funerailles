package tg.Ipnet.efunerailles.ServiceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Repository.FactureRepository;
import tg.Ipnet.efunerailles.Repository.PaiementRepository;
import tg.Ipnet.efunerailles.Service.ComptabiliteService;

@Service
@RequiredArgsConstructor
public class ComptabiliteServiceImpl implements ComptabiliteService {

    private final FactureRepository factureRepository = null;
    private final PaiementRepository paiementRepository = null;

    @Override
    public BigDecimal getChiffreAffairesTotal() {
        return factureRepository.getChiffreAffairesTotal();
    }

    @Override
    public BigDecimal getChiffreAffairesParMois(int mois, int annee) {
        return factureRepository.getChiffreAffairesParMois(mois, annee);
    }

    @Override
    public BigDecimal getTotalEncaisse() {
        return paiementRepository.getTotalEncaisse();
    }

    @Override
    public BigDecimal getTotalResteAPayer() {
        return factureRepository.getTotalResteAPayer();
    }

    @Override
    public Double getTauxPaiement() {

        BigDecimal totalFactures = getChiffreAffairesTotal();
        BigDecimal totalEncaisse = getTotalEncaisse();

        if (totalFactures.compareTo(BigDecimal.ZERO) == 0) {
            return 0.0;
        }

        return totalEncaisse
                .divide(totalFactures, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }

    @Override
    public Map<String, Double> getRepartitionPaiements() {

        List<Object[]> results = paiementRepository.getRepartitionParMode();
        Map<String, Double> repartition = new HashMap<>();

        for (Object[] row : results) {
            String mode = row[0].toString();
            Double montant = ((Number) row[1]).doubleValue();
            repartition.put(mode, montant);
        }

        return repartition;
    }
}