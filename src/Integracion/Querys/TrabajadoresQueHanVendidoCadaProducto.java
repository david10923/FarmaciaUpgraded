package Integracion.Querys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Factura.TFactura;
import Negocio.Trabajador.TTrabajador;

public class TrabajadoresQueHanVendidoCadaProducto{
	public Object execute(Object param) {
		int id = (int) param;
		ArrayList<TTrabajador> listaTrabajadores= null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement statement = connection.createStatement();
					String query = "SELECT DISTINCT trabajador.DNI "
							+ "FROM trabajador  JOIN factura ON factura.codigo_Trabajador = trabajador.codigo_trabajador "
							+ "JOIN contiene ON factura.codigo_factura = contiene.codigo_factura WHERE contiene.codigo_producto = " + id;
					ResultSet resultSet = statement.executeQuery(query);
					TTrabajador Trabajador;
					listaTrabajadores = new ArrayList<>();
					while (resultSet.next()) {
						Trabajador = new TTrabajador(resultSet.getString("DNI"));
						listaTrabajadores.add(Trabajador);

					}
				} catch (SQLException e) {
					listaTrabajadores = null;
				}
			}
		}
		return listaTrabajadores;
	}
}
