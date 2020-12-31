package Integracion.DAOLaboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;


public class DAOLaboratorioImp implements DAOLaboratorio {
	
	

	@Override
	public int create(TLaboratorio tLaboratorio) {
		Connection con = null;
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		String query = "INSERT INTO laboratorio(NOMBRE, TELEFONO, DIRECCION, ESTADO) VALUES(?,?,?,?)";
		
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, tLaboratorio.getNombre());
			ps.setString(2, tLaboratorio.getTelefono());
			ps.setString(3, tLaboratorio.getDireccion());
			ps.setBoolean(4, true);
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
	public List<TLaboratorio> readAll() {
		List<TLaboratorio> list = new ArrayList<TLaboratorio>();
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null;
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("select * from laboratorio FOR UPDATE", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				TLaboratorio aux = new TLaboratorio();

				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
		}
		
		return list;
		
	}

	@Override
	public TLaboratorio readById(int id) {
		Connection con = null;
		TLaboratorio aux = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		String query = "SELECT * FROM laboratorio WHERE CODIGO_LABORATORIO=? FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TLaboratorio();
				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}
	
	public TLaboratorio readByName(String name) {
		
		Connection con = null;
		TLaboratorio aux = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		String query = "SELECT * FROM laboratorio WHERE NOMBRE=? FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TLaboratorio();
				aux.setCodigo(res.getInt(1));
				aux.setNombre(res.getString(2));
				aux.setTelefono(res.getString(3));
				aux.setDireccion(res.getString(4));
				aux.setEstado(res.getBoolean(5));
			
			}
			
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	}
	

	@Override
	public int update(TLaboratorio tLaboratorio, boolean reactivar) {
		int id = -1,res;

		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			con = (Connection) t.getResource();	
			if(!reactivar){				
				PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET NOMBRE=?, TELEFONO=?, DIRECCION=? "
						+ " WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, tLaboratorio.getNombre());
				ps.setString(2, tLaboratorio.getTelefono());
				ps.setString(3, tLaboratorio.getDireccion());
				ps.setInt(4, tLaboratorio.getCodigo());
				
				 res = ps.executeUpdate();
				
			}else{
				PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET ESTADO=?"
						+ " WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);				
				
				ps.setBoolean(1, true);
				ps.setInt(2, tLaboratorio.getCodigo());
				
				 res = ps.executeUpdate();
				
			}
			
		
			if(res > 0) {
				
				id = tLaboratorio.getCodigo();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
		
	}

	@Override
	public int delete(int codigo) {
		int id = -1;
	
		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("UPDATE laboratorio SET estado=(?) WHERE CODIGO_LABORATORIO=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, codigo);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = codigo;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;

	}

	public List<TProducto> readProductosLaboratorio(int idLaboratorio){
		
		List<TProducto> list = new ArrayList<TProducto>();
		TProducto aux;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null;
		try {
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("select * from producto "
					+ "where (ESTADO=1 AND CODIGO_LABORATORIO=?) FOR UPDATE", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idLaboratorio);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				
				aux = new TProducto(res.getInt(1),res.getInt(2), res.getString(3),res.getInt(4)
						,res.getString(5),res.getDouble(6),res.getBoolean(7),res.getBoolean(8), res.getString(9));
				list.add(aux);
				
			}
			
		} catch (Exception e) {
			list.clear();
			e.printStackTrace();
		}
		
		return list;
		
	}

	

}
