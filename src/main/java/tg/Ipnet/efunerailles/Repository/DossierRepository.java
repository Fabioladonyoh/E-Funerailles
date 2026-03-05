package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tg.Ipnet.efunerailles.Entity.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Long> {

    Optional<Dossier> findByNumeroDossier(String numeroDossier);

    boolean existsByNumeroDossier(String numeroDossier);
    
    @Query("SELECT COUNT(d) FROM Dossier d")
    Long countTotalDossiers();

    @Query("SELECT COUNT(d) FROM Dossier d WHERE d.statut = 'PLANIFIE'")
    Long countPlanifie();

    @Query("SELECT COUNT(d) FROM Dossier d WHERE d.statut = 'EN_COURS'")
    Long countEnCours();

    @Query("SELECT COUNT(d) FROM Dossier d WHERE d.statut = 'TERMINE'")
    Long countTermine();
    
}