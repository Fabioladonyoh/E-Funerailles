package tg.Ipnet.efunerailles.Controller;


import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Defunt;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Service.DefuntService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defunts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DefuntController {
	

    @Autowired
    private DefuntService defuntService;

    @GetMapping
    public List<Defunt> getAllDefunts() {
        return defuntService.getAllDefunts();
    }

    @GetMapping("/{id}")
    public Defunt getDefuntById(@PathVariable Long id) {
        return defuntService.getDefuntById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Defunt not found with id " + id));
    }

    @PostMapping
    public Defunt createDefunt(@RequestBody Defunt defunt) {
        return defuntService.createDefunt(defunt);
    }

    @PutMapping("/{id}")
    public Defunt updateDefunt(@PathVariable Long id, @RequestBody Defunt defuntDetails) {
        return defuntService.updateDefunt(id, defuntDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDefunt(@PathVariable Long id) {
        defuntService.deleteDefunt(id);
        return ResponseEntity.ok().build();
    }
	
}