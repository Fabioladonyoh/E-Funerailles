package tg.Ipnet.efunerailles.Controller;



import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Ceremonie;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Service.CeremonieService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/ceremonies")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CeremonieController {

    @Autowired
    private CeremonieService ceremonieService;

    @GetMapping
    public List<Ceremonie> getAllCeremonies() {
        return ceremonieService.getAllCeremonies();
    }
    
    @GetMapping("/{id}")
    public Ceremonie getCeremonieById(@PathVariable Long id) {
        return ceremonieService.getCeremonieById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ceremonie not found with id " + id));
    }

    @PostMapping
    public Ceremonie createCeremonie(@RequestBody Ceremonie ceremonie) {
        return ceremonieService.createCeremonie(ceremonie);
    }

    @PutMapping("/{id}")
    public Ceremonie updateCeremonie(@PathVariable Long id, @RequestBody Ceremonie ceremonieDetails) {
        return ceremonieService.updateCeremonie(id, ceremonieDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCeremonie(@PathVariable Long id) {
        ceremonieService.deleteCeremonie(id);
        return ResponseEntity.ok().build();
    }
}
