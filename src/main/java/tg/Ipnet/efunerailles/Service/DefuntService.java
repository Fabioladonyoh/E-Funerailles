package tg.Ipnet.efunerailles.Service;


import java.util.List;
import java.util.Optional;

import tg.Ipnet.efunerailles.Entity.Defunt;

public interface DefuntService {

	List<Defunt> getAllDefunts();
    Optional<Defunt> getDefuntById(Long id);
    Defunt createDefunt(Defunt defunt);
    Defunt updateDefunt(Long id, Defunt defuntDetails);
    void deleteDefunt(Long id);
}
