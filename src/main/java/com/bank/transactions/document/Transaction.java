package com.bank.transactions.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "transaction" )
public class Transaction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	
	@Field(name = "productId")
	private String productId;
	
	@Field(name = "transType")
	private String transType;

	@Field(name = "transReason")
	private String transReason;
	
	@Field(name = "paymentMethod")
	private String paymentMethod;
	
	@Indexed(unique = true)
	private String toProductId;
	
	@Field(name = "amount")
	private boolean amount;
	
	@Field(name = "commision")
	private boolean commision;
	
	@Field(name = "createdAt")
	private String createdAt;
	
	@Field(name = "createdBy")
	private String createdBy;
	
	@Field(name = "updatedAt")
	private String updatedAt;
	
	@Field(name = "updatedBy")
	private String updatedBy;
	
	@Field(name = "status")
	private String status;

}
