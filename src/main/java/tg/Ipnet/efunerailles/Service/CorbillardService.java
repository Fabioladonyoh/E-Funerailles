package tg.Ipnet.efunerailles.Service;

import tg.Ipnet.efunerailles.Entity.Corbillard;
import java.util.List;

public interface CorbillardService {

    Corbillard saveCorbillard(Corbillard corbillard);

    Corbillard updateCorbillard(Long id, Corbillard corbillard);

    void deleteCorbillard(Long id);

    Corbillard getCorbillardById(Long id);

    List<Corbillard> getAllCorbillards();
}