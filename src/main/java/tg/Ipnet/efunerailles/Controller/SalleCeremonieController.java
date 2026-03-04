package tg.Ipnet.efunerailles.Controller;

import org.springframework.web.bind.annotation.*;
import tg.Ipnet.efunerailles.Service.SalleCeremonieService;
import tg.Ipnet.efunerailles.Entity.SalleCeremonie;
import tg.Ipnet.efunerailles.dto.SalleCeremonieDTO;

import java.util.List;

@RestController
@RequestMapping("/api/salles")
@CrossOrigin(origins = "*")
public class SalleCeremonieController {

    private final SalleCeremonieService salleService;

    public SalleCeremonieController(SalleCeremonieService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<SalleCeremonie> getAllSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public SalleCeremonie getSalleById(@PathVariable Long id) {
        return salleService.getSalleById(id);
    }

    @PostMapping
    public SalleCeremonie createSalle(@RequestBody SalleCeremonieDTO dto) {
        return salleService.createSalle(dto);
    }

    @PutMapping("/{id}")
    public SalleCeremonie updateSalle(@PathVariable Long id, @RequestBody SalleCeremonieDTO dto) {
        return salleService.updateSalle(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
    }
}