package tg.Ipnet.efunerailles.Service;

import tg.Ipnet.efunerailles.Entity.Cercueil;
import java.util.List;

public interface CercueilService {

    Cercueil saveCercueil(Cercueil cercueil);

    Cercueil updateCercueil(Long id, Cercueil cercueil);

    void deleteCercueil(Long id);

    Cercueil getCercueilById(Long id);

    List<Cercueil> getAllCercueils();
}