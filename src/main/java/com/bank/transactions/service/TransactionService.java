package com.bank.transactions.service;

import com.bank.transactions.document.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
	public Mono<Transaction> addTrans(Transaction transaction);
	public Mono<Transaction> editTrans(Transaction transaction);
	public Mono<Void> deleteTrans(Transaction transaction);
	public Flux<Transaction> getTransactions();
	public Mono<Transaction> getByTransId(String id);
	public Flux<Transaction> getByProductId(String productId);
	public Flux<Transaction> getByTransType(String transType);
	public Flux<Transaction> getByTransReason(String transReason);

}
