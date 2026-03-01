package tg.Ipnet.efunerailles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Cercueil;
import tg.Ipnet.efunerailles.Service.CercueilService;

@RestController
@RequestMapping("/api/cercueils")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CercueilController {
	
	    @Autowired
	    private CercueilService cercueilService;

	    @GetMapping
	    public List<Cercueil> getAllCercueils() {
	        return cercueilService.getAllCercueils();
	    }

	    @GetMapping("/{id}")
	    public Cercueil getCercueilById(@PathVariable Long id) {
	        return cercueilService.getCercueilById(id).orElse(null);
	    }

	    @PostMapping
	    public Cercueil createCercueil(@RequestBody Cercueil cercueil) {
	        return cercueilService.saveCercueil(cercueil);
	    }

	    @PutMapping("/{id}")
	    public Cercueil updateCercueil(@PathVariable Long id, @RequestBody Cercueil cercueilDetails) {
	        return cercueilService.updateCercueil(id, cercueilDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCercueil(@PathVariable Long id) {
	        cercueilService.deleteCercueil(id);
	    }
	
	

}
