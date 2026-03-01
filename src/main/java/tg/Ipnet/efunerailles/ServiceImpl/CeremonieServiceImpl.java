package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import tg.Ipnet.efunerailles.Entity.Ceremonie;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.CeremonieRepository;
import tg.Ipnet.efunerailles.Service.CeremonieService;

import java.util.List;
import java.util.Optional;

@Service
public class CeremonieServiceImpl implements CeremonieService {

    @Autowired
    private CeremonieRepository ceremonieRepository;

    @Override
    public List<Ceremonie> getAllCeremonies() {
        return ceremonieRepository.findAll();
    }

    @Override
    public Optional<Ceremonie> getCeremonieById(Long id) {
        return ceremonieRepository.findById(id);
    }

    @Override
    public Ceremonie createCeremonie(Ceremonie ceremonie) {
        return ceremonieRepository.save(ceremonie);
    }
    @Override
    public Ceremonie updateCeremonie(Long id, Ceremonie ceremonieDetails) {
        Ceremonie ceremonie = ceremonieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ceremonie not found with id " + id));
        ceremonie.setDate(ceremonieDetails.getDate());
        ceremonie.setLieu(ceremonieDetails.getLieu());
        ceremonie.setDefunt(ceremonieDetails.getDefunt());
        return ceremonieRepository.save(ceremonie);
    }

    @Override
    public void deleteCeremonie(Long id) {
        Ceremonie ceremonie = ceremonieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ceremonie not found with id " + id));
        ceremonieRepository.delete(ceremonie);
    }

}