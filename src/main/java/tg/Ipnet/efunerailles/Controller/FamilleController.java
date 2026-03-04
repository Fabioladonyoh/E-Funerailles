package tg.Ipnet.efunerailles.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Famille;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Service.FamilleService;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/familles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FamilleController {
	
    @Autowired
    private FamilleService familleService;

    @GetMapping
    public List<Famille> getAllFamilles() {
        return familleService.getAllFamilles();
    }

    @GetMapping("/{id}")
    public Famille getFamilleById(@PathVariable Long id) {
        return familleService.getFamilleById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Famille not found with id " + id));
    }

    @PostMapping
    public Famille createFamille(@RequestBody Famille famille) {
        return familleService.createFamille(famille);
    }

    @PutMapping("/{id}")
    public Famille updateFamille(@PathVariable Long id, @RequestBody Famille familleDetails) {
        return familleService.updateFamille(id, familleDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFamille(@PathVariable Long id) {
        familleService.deleteFamille(id);
        return ResponseEntity.ok().build();
    }
	
}