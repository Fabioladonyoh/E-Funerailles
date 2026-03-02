package tg.Ipnet.efunerailles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tg.Ipnet.efunerailles.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}