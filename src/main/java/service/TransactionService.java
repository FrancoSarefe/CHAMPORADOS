package service;

import java.util.List;

import entity.TransactionEntity;
import repository.TransactionRepository;

public class TransactionService {
	
	private TransactionRepository transactionRepository;
	
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	public List<TransactionEntity> getAllTransactions() {
		return transactionRepository.findAll();
	}
	
	public List<TransactionEntity> getTransactionsByWalletNumber(String walletNumber) {
		return transactionRepository.findByWalletNumber(walletNumber);
	}
	
	public List<TransactionEntity> getTransactionByTransactionNumber(String transactionNumber) {
		return transactionRepository.findByTransactionNumber(transactionNumber);
	}
	
	public void setTransactionStatus(String transactionNumber, String status) {
		transactionRepository.updateTransactionStatus(transactionNumber, status);
	}
	
	public void addTransaction(String transactionNumber, String cartNumber, String room, 
			  					  float grandTotal) {
		transactionRepository.insertTransaction(transactionNumber, cartNumber, room, grandTotal);
	}
}
