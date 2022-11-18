package service;

import java.util.Comparator;

import entity.TransactionEntity;

public class TransactionSorterService {
	
	public Comparator<TransactionEntity> sortByFilter() {
		return new SortByID();
	}
	
	public Comparator<TransactionEntity> sortByFilter(String filter) {
		switch (filter) {
		case "wallet-number":
			return new SortByWalletNumber();
		case "transaction-number":
			return new SortByTransactionNumber();
		case "id":
			return new SortByID();
		default:
			return new SortByID();
		}
	}
	
	private class SortByID implements Comparator<TransactionEntity>{
		@Override
		public int compare(TransactionEntity o1, TransactionEntity o2) {
			// TODO Auto-generated method stub
			return o2.getId() - o1.getId();
		}
	}
	
	private class SortByTransactionNumber implements Comparator<TransactionEntity>{
		@Override
		public int compare(TransactionEntity o1, TransactionEntity o2) {
			// TODO Auto-generated method stub
			return o1.getTransactionNumber().compareTo(o2.getTransactionNumber());
		}
	}
	
	private class SortByWalletNumber implements Comparator<TransactionEntity>{
		@Override
		public int compare(TransactionEntity o1, TransactionEntity o2) {
			// TODO Auto-generated method stub
			return o1.getWalletNumber().compareTo(o2.getWalletNumber());
		}
	}
}
