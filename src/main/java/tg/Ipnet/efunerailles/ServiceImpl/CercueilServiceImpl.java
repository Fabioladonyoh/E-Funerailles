package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Entity.Cercueil;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.CercueilRepository;
import tg.Ipnet.efunerailles.Service.CercueilService;

import java.util.List;

@Service
public class CercueilServiceImpl implements CercueilService {

    private final CercueilRepository cercueilRepository;

    public CercueilServiceImpl(CercueilRepository cercueilRepository) {
        this.cercueilRepository = cercueilRepository;
    }

    @Override
    public Cercueil saveCercueil(Cercueil cercueil) {
        return cercueilRepository.save(cercueil);
    }

    @Override
    public Cercueil updateCercueil(Long id, Cercueil cercueil) {
        Cercueil existing = cercueilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cercueil non trouvé avec id : " + id));

        
        existing.setMateriau(cercueil.getMateriau());
        existing.setPrix(cercueil.getPrix());
  
        return cercueilRepository.save(existing);
    }

    @Override
    public void deleteCercueil(Long id) {
        Cercueil existing = cercueilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cercueil non trouvé avec id : " + id));

        cercueilRepository.delete(existing);
    }

    @Override
    public Cercueil getCercueilById(Long id) {
        return cercueilRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cercueil non trouvé avec id : " + id));
    }

    @Override
    public List<Cercueil> getAllCercueils() {
        return cercueilRepository.findAll();
    }
}