package Integracion.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionMySql;
import Integracion.TransactionFactory.TransactionFactory;

public class TransactionManagerImp extends TransactionManager {

	private ConcurrentHashMap<Thread, Transaction> _transactions;
	
	public TransactionManagerImp() {
		_transactions = new ConcurrentHashMap<Thread, Transaction>();
	}
	
	@Override
	public Transaction newTransaction() {
		Thread current = Thread.currentThread();
		Transaction tExe = null;
		
		if(!_transactions.contains(current)) {
			tExe = TransactionFactory.getInstance().nuevaTransaction();
			_transactions.put(current, tExe);
		}
		else {
			tExe = _transactions.get(current);
		}
		
		return tExe;	
	}

	@Override
	public void deleteTransaction() {
		_transactions.remove(Thread.currentThread());
	}

	@Override
	public Transaction getTransaction() {
		return _transactions.get(Thread.currentThread());
	}
}
