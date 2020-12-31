package Integracion.TransactionFactory;

import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionMySql;

public class TransactionFactoryImp  extends TransactionFactory{

	@Override
	public Transaction nuevaTransaction() {
		return new TransactionMySql();
	}

}
