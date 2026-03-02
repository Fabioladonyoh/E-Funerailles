package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Service.PlanningService;
import tg.Ipnet.efunerailles.Repository.CeremonieRepository;
import tg.Ipnet.efunerailles.Repository.CorbillardRepository;
import tg.Ipnet.efunerailles.Repository.PlanningRepository;
import tg.Ipnet.efunerailles.Repository.UserRepository;
import tg.Ipnet.efunerailles.Entity.Planning;
import tg.Ipnet.efunerailles.Entity.Ceremonie;
import tg.Ipnet.efunerailles.Entity.Corbillard;
import tg.Ipnet.efunerailles.Entity.User;
import tg.Ipnet.efunerailles.dto.PlanningDTO;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningServiceImpl implements PlanningService {

    private final PlanningRepository planningRepository;
    private final CeremonieRepository ceremonieRepository;
    private final CorbillardRepository corbillardRepository;
    private final UserRepository userRepository;

    public PlanningServiceImpl(PlanningRepository planningRepository,
                               CeremonieRepository ceremonieRepository,
                               CorbillardRepository corbillardRepository,
                               UserRepository userRepository) {
        this.planningRepository = planningRepository;
        this.ceremonieRepository = ceremonieRepository;
        this.corbillardRepository = corbillardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Planning> getAllPlannings() {
        return planningRepository.findAll();
    }

    @Override
    public Planning getPlanningById(Long id) {
        return planningRepository.findById(id).orElse(null);
    }

    @Override
    public Planning createPlanning(PlanningDTO dto) {
        Planning planning = new Planning();
        Ceremonie c = ceremonieRepository.findById(dto.getCeremonieId()).orElse(null);
        Corbillard co = corbillardRepository.findById(dto.getCorbillardId()).orElse(null);
        User u = userRepository.findById(dto.getResponsableId()).orElse(null);

        planning.setCeremonie(c);
        planning.setCorbillard(co);
        planning.setResponsable(u);
        planning.setDateDebut(dto.getDateDebut());
        planning.setDateFin(dto.getDateFin());

        return planningRepository.save(planning);
    }

    @Override
    public Planning updatePlanning(Long id, PlanningDTO dto) {
        Optional<Planning> optional = planningRepository.findById(id);
        if (!optional.isPresent()) return null;
        Planning planning = optional.get();

        Ceremonie c = ceremonieRepository.findById(dto.getCeremonieId()).orElse(null);
        Corbillard co = corbillardRepository.findById(dto.getCorbillardId()).orElse(null);
        User u = userRepository.findById(dto.getResponsableId()).orElse(null);

        planning.setCeremonie(c);
        planning.setCorbillard(co);
        planning.setResponsable(u);
        planning.setDateDebut(dto.getDateDebut());
        planning.setDateFin(dto.getDateFin());

        return planningRepository.save(planning);
    }

    @Override
    public void deletePlanning(Long id) {
        planningRepository.deleteById(id);
    }
}