package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Service.TransactionService;
import tg.Ipnet.efunerailles.Repository.TransactionRepository;
import tg.Ipnet.efunerailles.Repository.FactureRepository;
import tg.Ipnet.efunerailles.Entity.Transaction;
import tg.Ipnet.efunerailles.Entity.Facture;
import tg.Ipnet.efunerailles.dto.TransactionDTO;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final FactureRepository factureRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  FactureRepository factureRepository) {
        this.transactionRepository = transactionRepository;
        this.factureRepository = factureRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction createTransaction(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        Facture facture = factureRepository.findById(dto.getFactureId()).orElse(null);

        transaction.setFacture(facture);
        transaction.setDateTransaction(dto.getDateTransaction());
        transaction.setMontant(dto.getMontant());
        transaction.setType(dto.getType());
        transaction.setDescription(dto.getDescription());

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, TransactionDTO dto) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        if (!optional.isPresent()) return null;
        Transaction transaction = optional.get();

        Facture facture = factureRepository.findById(dto.getFactureId()).orElse(null);

        transaction.setFacture(facture);
        transaction.setDateTransaction(dto.getDateTransaction());
        transaction.setMontant(dto.getMontant());
        transaction.setType(dto.getType());
        transaction.setDescription(dto.getDescription());

        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}