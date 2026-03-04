package tg.Ipnet.efunerailles.Service;

import java.util.List;

import tg.Ipnet.efunerailles.Entity.Dossier;

public interface DossierService {

    List<Dossier> getAllDossiers();

    Dossier getDossierById(Long id);

    Dossier createDossier(Dossier dossier);

    Dossier updateDossier(Long id, Dossier dossier);

    void deleteDossier(Long id);
}