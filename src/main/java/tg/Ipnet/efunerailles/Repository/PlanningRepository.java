package tg.Ipnet.efunerailles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.Ipnet.efunerailles.Entity.Planning;

public interface PlanningRepository extends JpaRepository<Planning, Long> {
	
}