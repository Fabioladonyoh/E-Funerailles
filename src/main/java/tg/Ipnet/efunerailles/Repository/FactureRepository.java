package tg.Ipnet.efunerailles.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tg.Ipnet.efunerailles.Entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    // Chiffre d'affaires total
    @Query("SELECT COALESCE(SUM(f.montantTotal), 0) FROM Facture f")
    BigDecimal getChiffreAffairesTotal();

    // Total restant à payer
    @Query("SELECT COALESCE(SUM(f.montantTotal - f.montantPaye), 0) FROM Facture f")
    BigDecimal getTotalResteAPayer();

    // Chiffre d'affaires par mois
    @Query("""
           SELECT COALESCE(SUM(f.montantTotal), 0)
           FROM Facture f
           WHERE MONTH(f.date) = :mois AND YEAR(f.date) = :annee
           """)
    BigDecimal getChiffreAffairesParMois(int mois, int annee);
}