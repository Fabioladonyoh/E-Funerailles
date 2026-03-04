package tg.Ipnet.efunerailles.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tg.Ipnet.efunerailles.Entity.Dossier;

public interface DossierRepository extends JpaRepository<Dossier, Long> {

    Optional<Dossier> findByNumeroDossier(String numeroDossier);

    boolean existsByNumeroDossier(String numeroDossier);
}