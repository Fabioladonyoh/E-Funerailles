package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Service.SalleCeremonieService;
import tg.Ipnet.efunerailles.Repository.SalleCeremonieRepository;
import tg.Ipnet.efunerailles.Entity.SalleCeremonie;
import tg.Ipnet.efunerailles.dto.SalleCeremonieDTO;

import java.util.List;
import java.util.Optional;

@Service
public class SalleCeremonieServiceImpl implements SalleCeremonieService {

    private final SalleCeremonieRepository salleRepository;

    public SalleCeremonieServiceImpl(SalleCeremonieRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public List<SalleCeremonie> getAllSalles() {
        return salleRepository.findAll();
    }

    @Override
    public SalleCeremonie getSalleById(Long id) {
        return salleRepository.findById(id).orElse(null);
    }

    @Override
    public SalleCeremonie createSalle(SalleCeremonieDTO dto) {
        SalleCeremonie salle = new SalleCeremonie();
        salle.setNom(dto.getNom());
        salle.setCapacite(dto.getCapacite());
        salle.setStatut(dto.getStatut());

        return salleRepository.save(salle);
    }

    @Override
    public SalleCeremonie updateSalle(Long id, SalleCeremonieDTO dto) {
        Optional<SalleCeremonie> optional = salleRepository.findById(id);
        if (!optional.isPresent()) return null;
        SalleCeremonie salle = optional.get();

        salle.setNom(dto.getNom());
        salle.setCapacite(dto.getCapacite());
        salle.setStatut(dto.getStatut());

        return salleRepository.save(salle);
    }

    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }
}