package tg.Ipnet.efunerailles.Controller;

import org.springframework.web.bind.annotation.*;
import tg.Ipnet.efunerailles.Service.PlanningService;
import tg.Ipnet.efunerailles.Entity.Planning;
import tg.Ipnet.efunerailles.dto.PlanningDTO;

import java.util.List;

@RestController
@RequestMapping("/api/plannings")
@CrossOrigin(origins = "*")
public class PlanningController {

    private final PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @GetMapping
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @GetMapping("/{id}")
    public Planning getPlanningById(@PathVariable Long id) {
        return planningService.getPlanningById(id);
    }

    @PostMapping
    public Planning createPlanning(@RequestBody PlanningDTO dto) {
        return planningService.createPlanning(dto);
    }

    @PutMapping("/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody PlanningDTO dto) {
        return planningService.updatePlanning(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
    }
}