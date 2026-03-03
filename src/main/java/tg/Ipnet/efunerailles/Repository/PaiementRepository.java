package tg.Ipnet.efunerailles.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tg.Ipnet.efunerailles.Entity.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
	

    // Total encaissé
    @Query("SELECT COALESCE(SUM(p.montant), 0) FROM Paiement p")
    BigDecimal getTotalEncaisse();

    @Query("SELECT p.modePaiement, SUM(p.montant) FROM Paiement p GROUP BY p.modePaiement")
    List<Object[]> getRepartitionParMode();

}
