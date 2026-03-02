package tg.Ipnet.efunerailles.Service;

import java.util.List;
import tg.Ipnet.efunerailles.Entity.Transaction;
import tg.Ipnet.efunerailles.dto.TransactionDTO;

public interface TransactionService {
	
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long id);
    Transaction createTransaction(TransactionDTO dto);
    Transaction updateTransaction(Long id, TransactionDTO dto);
    void deleteTransaction(Long id);

}