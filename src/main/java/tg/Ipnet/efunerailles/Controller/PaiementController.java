package tg.Ipnet.efunerailles.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tg.Ipnet.efunerailles.Entity.Paiement;
import tg.Ipnet.efunerailles.Service.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id).orElse(null);
    }

    @PostMapping
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement); // Utilisation du savePaiement pour mise à jour facture
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
        return paiementService.updatePaiement(id, paiementDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.deletePaiement(id);
    }
}