package Integracion.Querys;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;
import Negocio.Trabajador.TTrabajador;

public class ProductosVendidosPorUnTrabajador{
	public Object execute(Object param) {
		int id = (int) param;
		ArrayList<TProducto> listaProductos = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if (transaction != null) {
			Connection connection = (Connection) transaction.getResource();
			if (connection != null) {
				try {
					Statement statement = connection.createStatement();
					String query = "SELECT  DISTINCT producto.nombre "
							+ "FROM producto  JOIN contiene ON producto.codigo_producto = contiene.codigo_producto "
							+ "JOIN factura ON contiene.codigo_factura = factura.codigo_factura JOIN trabajador" 
							+ " ON factura.codigo_trabajador = trabajador.codigo_trabajador WHERE trabajador.codigo_trabajador = " + id;
					ResultSet resultSet = statement.executeQuery(query);
					TProducto producto;
					listaProductos = new ArrayList<>();
					while (resultSet.next()) {
						producto = new TProducto(resultSet.getString("nombre"));
						listaProductos.add(producto);
					}
				} catch (SQLException e) {
					listaProductos= null;
				}
			}
		}
		return listaProductos;
	}
}
