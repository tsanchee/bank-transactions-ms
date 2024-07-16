package com.bank.transactions.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.transactions.document.Transaction;
import com.bank.transactions.repository.TransactionRepository;
import com.bank.transactions.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Transactional
	public Mono<Transaction> addTrans(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	@Transactional
	public Mono<Transaction> editTrans(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	@Transactional(readOnly = true)
	public Flux<Transaction> getReadTrans(String readTrans) {
		return transactionRepository.findByTransReason(readTrans);
	}

	@Transactional
	public Mono<Void> deleteTrans(Transaction transaction) {
		return transactionRepository.delete(transaction);
	}

	@Transactional(readOnly = true)
	public Flux<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	@Transactional
	public Mono<Transaction> getByTransId(String id) {
		return transactionRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public Flux<Transaction> getByProductId(String productId) {
		return transactionRepository.findByProductId(productId);
	}

	@Transactional(readOnly = true)
	public Flux<Transaction> getByTransType(String transType) {
		return transactionRepository.findByTransType(transType);
	}

	@Transactional(readOnly = true)
	public Flux<Transaction> getByTransReason(String transReason) {
		return transactionRepository.findByTransReason(transReason);
	}

}
