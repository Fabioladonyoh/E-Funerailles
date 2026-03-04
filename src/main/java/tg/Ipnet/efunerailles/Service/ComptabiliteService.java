package tg.Ipnet.efunerailles.Service;

import java.math.BigDecimal;
import java.util.Map;

public interface ComptabiliteService {

    BigDecimal getChiffreAffairesTotal();

    BigDecimal getChiffreAffairesParMois(int mois, int annee);

    BigDecimal getTotalEncaisse();

    BigDecimal getTotalResteAPayer();

    Double getTauxPaiement();

    Map<String, Double> getRepartitionPaiements();
}