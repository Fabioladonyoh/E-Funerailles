package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Entity.Corbillard;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.CorbillardRepository;
import tg.Ipnet.efunerailles.Service.CorbillardService;

import java.util.List;

@Service
public class CorbillardServiceImpl implements CorbillardService {

    private final CorbillardRepository corbillardRepository;

    public CorbillardServiceImpl(CorbillardRepository corbillardRepository) {
        this.corbillardRepository = corbillardRepository;
    }

    @Override
    public Corbillard saveCorbillard(Corbillard corbillard) {
        return corbillardRepository.save(corbillard);
    }

    @Override
    public Corbillard updateCorbillard(Long id, Corbillard corbillard) {
        Corbillard existing = corbillardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Corbillard non trouvé avec id : " + id));

        existing.setMarque(corbillard.getMarque());
        existing.setImmatriculation(corbillard.getImmatriculation());
   
        return corbillardRepository.save(existing);
    }

    @Override
    public void deleteCorbillard(Long id) {
        Corbillard existing = corbillardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Corbillard non trouvé avec id : " + id));

        corbillardRepository.delete(existing);
    }

    @Override
    public Corbillard getCorbillardById(Long id) {
        return corbillardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Corbillard non trouvé avec id : " + id));
    }

    @Override
    public List<Corbillard> getAllCorbillards() {
        return corbillardRepository.findAll();
    }
}