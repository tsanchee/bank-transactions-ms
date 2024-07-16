package com.bank.transactions.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.transactions.document.Transaction;

import reactor.core.publisher.Flux;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
	Flux<Transaction> findByProductId(String productId);
	Flux<Transaction> findByTransType(String transType);
	Flux<Transaction> findByTransReason(String transReason);
}