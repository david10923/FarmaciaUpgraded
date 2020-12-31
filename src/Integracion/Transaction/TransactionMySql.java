package Integracion.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Integracion.TransactionManager.TransactionManager;

public class TransactionMySql implements Transaction {
	 
	private Connection connection;
	private static final String CONTROLLER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gest_pharma";
	private static final String USER = "gestpharma";
	private static final String PASSWORD = "gestpharmaadmin1";
	

	static {
		try {
			Class.forName(CONTROLLER);
		}catch(ClassNotFoundException e) {
			System.out.println("Error en conexion con el Driver");
		}
	}
	
	@Override
	public void start() {
		  try {
	            connection = DriverManager.getConnection(URL, USER, PASSWORD);
	            connection.setAutoCommit(false);
	            
	            System.out.println("Conectado a BD");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	           // throw new SQLException("No se ha conectado con BD");
	        }
		
	}

	@Override
	public void commit() {
		  try {
	            this.connection.commit();
	            this.connection.close();
	            TransactionManager.getInstance().deleteTransaction();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        // end-user-code
		
	}

	@Override
	public void rollback() {
		 try {
	            this.connection.rollback();
	            this.connection.close();
	            TransactionManager.getInstance().deleteTransaction();	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Object getResource() {
		return this.connection;
	}

}
