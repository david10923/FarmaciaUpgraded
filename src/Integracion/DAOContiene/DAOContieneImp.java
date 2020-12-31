package Integracion.DAOContiene;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Factura.TContiene;
import Negocio.Producto.TProducto;

public class DAOContieneImp implements DAOContiene {

	
	public int create(TProducto producto, int codigoFactura,  int cantidadAnadida){
		Connection con = null;
		int id = -1;
		String query = "INSERT INTO contiene(CODIGO_FACTURA, CODIGO_PRODUCTO, UNIDADES, PRECIO) VALUES(?,?,?,?)";
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		try {
			con = (Connection) t.getResource();		
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigoFactura );
			ps.setInt(2, producto.getCodigo());
			ps.setInt(3, cantidadAnadida);
			ps.setDouble(4, producto.getPrecio() * cantidadAnadida);
			ps.executeUpdate();
			ResultSet res = ps.getGeneratedKeys();
			
			if (res.next()) {
				id = res.getInt(1);
			}
			
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		
		return id;
	}


	
	@Override
	public int update(TContiene contiene) {
		
		
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("UPDATE contiene SET UNIDADES=?, PRECIO=? "
					+ " WHERE (CODIGO_FACTURA=? AND CODIGO_PRODUCTO=? )", PreparedStatement.RETURN_GENERATED_KEYS);
		
			ps.setInt(1, contiene.getCantidad());
			ps.setDouble(2, contiene.getPrecio());
			ps.setInt(3, contiene.getCodigoFactura());
			ps.setInt(4, contiene.getCodigoProducto());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				
				id = res;
			}
			
			
		} catch (SQLException e) {

		}
		return id;
		

	}

	
	@Override
	public int delete(TContiene contiene) {
		
		int id = -1;
		
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("DELETE FROM contiene WHERE (CODIGO_PRODUCTO=? AND CODIGO_FACTURA=?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, contiene.getCodigoProducto());
			ps.setInt(2, contiene.getCodigoFactura());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = res;
			}
			
			
		} catch (SQLException e) {

		}
		return id;

	}

	public List<TContiene> readById(int id) {
		Connection con = null;
		List<TContiene> lista = new ArrayList<TContiene>();
		
		String query = "SELECT * FROM contiene WHERE CODIGO_FACTURA=?";
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		try {
			con = (Connection) t.getResource();	
			
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				TContiene contiene = new TContiene();
				contiene.setCodigoFactura(res.getInt(1));
				contiene.setCodigoProducto(res.getInt(2));
				contiene.setCantidad(res.getInt(3));
				contiene.setPrecio(res.getDouble(4));
				lista.add(contiene);
			}
			
			
		}catch (Exception e) {
			lista.clear();
		}
		
		return lista;
	}
	
	public List<TContiene>readAll(){
		Connection con = null;
		List<TContiene> lista = new ArrayList<TContiene>();
		Transaction t = TransactionManager.getInstance().getTransaction();
		String query = "SELECT * FROM contiene";
		
		try {
			con = (Connection) t.getResource();
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while (res.next()) {
				TContiene contiene = new TContiene();
				contiene.setCodigoFactura(res.getInt(1));
				contiene.setCodigoProducto(res.getInt(2));
				contiene.setCantidad(res.getInt(3));
				contiene.setPrecio(res.getDouble(4));
				lista.add(contiene);
			}
			
			
		}catch (Exception e) {
			lista.clear();
		}
		
		return lista;
	}
	

}
