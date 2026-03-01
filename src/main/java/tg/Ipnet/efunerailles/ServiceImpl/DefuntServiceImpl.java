package tg.Ipnet.efunerailles.ServiceImpl;


import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Defunt;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.DefuntRepository;
import tg.Ipnet.efunerailles.Service.DefuntService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DefuntServiceImpl implements DefuntService {
	
	  @Autowired
	    private DefuntRepository defuntRepository;

	    @Override
	    public List<Defunt> getAllDefunts() {
	        return defuntRepository.findAll();
	    }

	    @Override
	    public Optional<Defunt> getDefuntById(Long id) {
	        return defuntRepository.findById(id);
	    }

	    @Override
	    public Defunt createDefunt(Defunt defunt) {
	        return defuntRepository.save(defunt);
	    }
	    
	    @Override
	    public Defunt updateDefunt(Long id, Defunt defuntDetails) {
	        Defunt defunt = defuntRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Defunt not found with id " + id));
	        defunt.setNom(defuntDetails.getNom());
	        defunt.setPrenom(defuntDetails.getPrenom());
	        defunt.setDateNaissance(defuntDetails.getDateNaissance());
	        defunt.setDateDeces(defuntDetails.getDateDeces());
	        defunt.setLieuConservation(defuntDetails.getLieuConservation());
	        defunt.setFamille(defuntDetails.getFamille());
	        defunt.setStatut(defuntDetails.getStatut());
	        return defuntRepository.save(defunt);
	    }

	    @Override
	    public void deleteDefunt(Long id) {
	        Defunt defunt = defuntRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Defunt not found with id " + id));
	        defuntRepository.delete(defunt);
	    }
	    
}