package com.aninfo.service;


import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

    public Transaction createTransaction(Transaction transaction) {
        Double sum = transaction.getSum();
        Long cbu = transaction.getCbuAccount();

        if (Objects.equals(transaction.getType(), "withdraw")){
            accountService.withdraw(cbu, sum);

        } else if (Objects.equals(transaction.getType(), "deposit")) {
            accountService.deposit(cbu, sum);
        }
        else{
            throw new InvalidTransactionTypeException("Invalid transaction type");
        }
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> findById(Long id){
        return transactionRepository.findById(id);
    }

    public Collection<Transaction> findByCbu(Long cbu){
        return transactionRepository.findByCbuAccount(cbu);
    }

    public void deleteById(Long id){
        transactionRepository.deleteById(id);
    }
}
