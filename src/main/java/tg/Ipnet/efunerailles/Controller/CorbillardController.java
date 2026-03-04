package tg.Ipnet.efunerailles.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import tg.Ipnet.efunerailles.Entity.Corbillard;
import tg.Ipnet.efunerailles.Service.CorbillardService;

import java.util.List;

@RestController
@RequestMapping("/api/corbillards")
@CrossOrigin(origins = "*")
public class CorbillardController {

    @Autowired
    private CorbillardService corbillardService;

    @GetMapping
    public List<Corbillard> getAllCorbillards() {
        return corbillardService.getAllCorbillards();
    }

    @GetMapping("/{id}")
    public Corbillard getCorbillardById(@PathVariable Long id) {
        return corbillardService.getCorbillardById(id).orElse(null);
    }

    @PostMapping
    public Corbillard createCorbillard(@RequestBody Corbillard corbillard) {
        return corbillardService.saveCorbillard(corbillard);
    }

    @PutMapping("/{id}")
    public Corbillard updateCorbillard(@PathVariable Long id, @RequestBody Corbillard corbillardDetails) {
        return corbillardService.updateCorbillard(id, corbillardDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCorbillard(@PathVariable Long id) {
        corbillardService.deleteCorbillard(id);
    }
}