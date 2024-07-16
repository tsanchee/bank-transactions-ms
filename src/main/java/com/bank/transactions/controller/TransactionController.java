package com.bank.transactions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.transactions.document.Transaction;
import com.bank.transactions.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(value = "")
	@ResponseBody public Mono<Transaction> addTrans(@RequestBody Transaction transaction){
		return transactionService.addTrans(transaction);
	}
	
	@PutMapping(value = "")
	@ResponseBody public Mono<Transaction> editTrans(@RequestBody Transaction transaction){
		return transactionService.editTrans(transaction);
	}
	
	@DeleteMapping(value = "/{id}")
	public Mono<ResponseEntity<Transaction>> deleteTrans(@PathVariable String id){
		return transactionService.getByTransId(id).flatMap(transaction -> transactionService.deleteTrans(transaction))
                .map(c -> ResponseEntity
                        .noContent().build());
	}
	
	@GetMapping(value = "")
	public Flux<Transaction> getTransactions(){
		return transactionService.getTransactions();
	}
	
	@GetMapping(value = "/ids/{id}")
	@ResponseBody public Mono<Transaction> getByTransId(@PathVariable String id){
		return transactionService.getByTransId(id);
	}
	
	@GetMapping(value = "/products/{productId}")
	@ResponseBody public Flux<Transaction> getByProductId(@PathVariable String productId){
		return transactionService.getByProductId(productId);
	}
	
	@GetMapping(value = "/types/{transType}")
	@ResponseBody public Flux<Transaction> getByTransType(@PathVariable String transType){
		return transactionService.getByTransType(transType);
	}
	
	@GetMapping(value = "/reasons/{transReason}")
	@ResponseBody public Flux<Transaction> getByTransReason(@PathVariable String transReason){
		return transactionService.getByTransReason(transReason);
	}
}
