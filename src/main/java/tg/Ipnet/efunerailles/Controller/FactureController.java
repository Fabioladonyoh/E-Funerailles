package tg.Ipnet.efunerailles.Controller;

import org.springframework.web.bind.annotation.*;
import tg.Ipnet.efunerailles.Entity.Facture;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Service.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/factures") // Ton URL de base est ici
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Facture not found with id " + id));
    }

    /**
     * Cette méthode gère l'ajout simple de facture.
     * On utilise .save() car createFacture n'existe plus dans le Service.
     */
    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    /**
     * Cette méthode correspond à l'appel de ton formulaire Angular.
     * URL : http://localhost:8181/api/factures/dossiers
     */
    @PostMapping("/dossiers")
    public ResponseEntity<Facture> createDossier(@RequestBody Facture facture) {
        System.out.println("Réception nouveau dossier pour : " + 
            (facture.getDefunt() != null ? facture.getDefunt().getNom() : "Inconnu"));
        
        Facture savedFacture = factureService.save(facture);
        return ResponseEntity.ok(savedFacture);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
        return factureService.updateFacture(id, factureDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return ResponseEntity.ok().build();
    }
}