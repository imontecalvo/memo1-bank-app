package com.aninfo.repository;


import java.util.Collection;
import com.aninfo.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    Collection<Transaction> findByCbuAccount(Long cbu);
}
