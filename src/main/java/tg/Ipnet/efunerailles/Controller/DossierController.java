package tg.Ipnet.efunerailles.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Dossier;
import tg.Ipnet.efunerailles.Service.DossierService;

@RestController
@RequestMapping("/api/dossiers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Pour permettre au frontend d'accéder
public class DossierController {

	private final DossierService dossierService ;
	
	 public DossierController(DossierService dossierService) {
	        this.dossierService = dossierService;
	    }

	@GetMapping
	public List<Dossier> getAllDossiers() {
	    return dossierService.getAllDossiers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dossier> getDossierById(@PathVariable Long id) {
	    return ResponseEntity.ok(dossierService.getDossierById(id));
	}

	@PostMapping
	public Dossier createDossier(@RequestBody Dossier dossier) {
	    return dossierService.createDossier(dossier);
	}

	@PutMapping("/{id}")
	public Dossier updateDossier(@PathVariable Long id, @RequestBody Dossier dossier) {
	    return dossierService.updateDossier(id, dossier);
	}

	@DeleteMapping("/{id}")
	public void deleteDossier(@PathVariable Long id) {
	    dossierService.deleteDossier(id);
	}
}