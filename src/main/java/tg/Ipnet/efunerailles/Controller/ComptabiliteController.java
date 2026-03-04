package tg.Ipnet.efunerailles.Controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Service.ComptabiliteService;

@RestController
@RequestMapping("/api/comptabilite")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ComptabiliteController {

    private final ComptabiliteService comptabiliteService = null;
    
    // 🔹 Dashboard global
    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {

        Map<String, Object> stats = new HashMap<>();

        stats.put("chiffreAffairesTotal", comptabiliteService.getChiffreAffairesTotal());
        stats.put("totalEncaisse", comptabiliteService.getTotalEncaisse());
        stats.put("totalResteAPayer", comptabiliteService.getTotalResteAPayer());
        stats.put("tauxPaiement", comptabiliteService.getTauxPaiement());
        stats.put("repartitionPaiements", comptabiliteService.getRepartitionPaiements());

        return stats;
    }
    
    
    
    // 🔹 Chiffre d'affaires par mois
    @GetMapping("/chiffre-affaires-mensuel")
    public Object getChiffreAffairesMensuel(
            @RequestParam int mois,
            @RequestParam(defaultValue = "#{T(java.time.Year).now().value}") int annee) {

        return comptabiliteService.getChiffreAffairesParMois(mois, annee);
    }
}