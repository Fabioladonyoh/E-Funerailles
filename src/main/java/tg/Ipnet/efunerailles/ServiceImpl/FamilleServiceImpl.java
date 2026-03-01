package tg.Ipnet.efunerailles.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Famille;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.FamilleRepository;
import tg.Ipnet.efunerailles.Service.FamilleService;
	
	import org.springframework.beans.factory.annotation.Autowired;
	
	import java.util.Optional;



@Service
@RequiredArgsConstructor
@Transactional
public class FamilleServiceImpl implements FamilleService {
	
	    @Autowired
	    private FamilleRepository familleRepository;

	    @Override
	    public List<Famille> getAllFamilles() {
	        return familleRepository.findAll();
	    }

	    @Override
	    public Optional<Famille> getFamilleById(Long id) {
	        return familleRepository.findById(id);
	    }

	    @Override
	    public Famille createFamille(Famille famille) {
	        return familleRepository.save(famille);
	    }

	    @Override
	    public Famille updateFamille(Long id, Famille familleDetails) {
	        Famille famille = familleRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Famille not found with id " + id));
	        famille.setNomResponsable(familleDetails.getNomResponsable());
	        famille.setPrenomResponsable(familleDetails.getPrenomResponsable());
	        famille.setEmail(familleDetails.getEmail());
	        famille.setTelephone(familleDetails.getTelephone());
	        famille.setAdresse(familleDetails.getAdresse());
	        return familleRepository.save(famille);
	    }

	    @Override
	    public void deleteFamille(Long id) {
	        Famille famille = familleRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Famille not found with id " + id));
	        familleRepository.delete(famille);
	    }
	}