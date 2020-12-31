package Integracion.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import Integracion.Transaction.Transaction;

public  abstract class TransactionManager {
	
	private static TransactionManager instance;
	
	
	public static TransactionManager getInstance () {
		if(instance == null) {
			instance  = new TransactionManagerImp();
		}
		return instance;
	}

	
	public abstract Transaction newTransaction();
	public abstract void deleteTransaction();
	public abstract Transaction getTransaction();
	
}
