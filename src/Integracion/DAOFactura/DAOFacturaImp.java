package Integracion.DAOFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;

public class DAOFacturaImp implements DAOFactura {

	@Override
	public TCarrito create(TCarrito carrito) {
		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		String query = "INSERT INTO factura(CODIGO_TRABAJADOR) VALUES(?)";
		
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1,carrito.gettFactura().getCodigoTrabajador());
			
			ps.executeUpdate();
			ResultSet res = ps.getGeneratedKeys();
			
			if (res.next()) {
				carrito.setCodigoFactura(res.getInt(1));
			}
			
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		return carrito;
	}

	@Override
	public TCarrito read(int codigo) {
		Connection con = null;
		TCarrito aux = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		String query = "SELECT * FROM factura WHERE CODIGO_FACTURA=? FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();		
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TCarrito();
				
				aux.gettFactura().setCodigo(res.getInt(1));
				aux.gettFactura().setCodigoTrabajador(res.getInt(2));
				aux.gettFactura().setFecha(res.getString(3));
				aux.gettFactura().setPrecioTotal(res.getDouble(4));
				aux.gettFactura().setEstado(res.getBoolean(5));			
			}
			
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	
	}

	@Override
	public int delete(int codigo) {	
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("UPDATE factura SET estado=(?) WHERE CODIGO_FACTURA=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, codigo);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = codigo;
			}
			
			
		} catch (SQLException e) {
				
		}
		return id;
		
		
	}

	@Override
	public int update(TFactura factura) {
		
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();		
			
			PreparedStatement ps = con.prepareStatement("UPDATE factura SET FECHA=(SELECT SYSDATE()), PRECIO_TOTAL=?, ESTADO=? "
					+ " WHERE CODIGO_FACTURA=?", PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setDouble(1, factura.getPrecioTotal());	
			ps.setBoolean(2, true);
			ps.setInt(3, factura.getCodigo());
			int res = ps.executeUpdate();
		
			if(res > 0) {
				
				id = factura.getCodigo();
			}
			
			
		} catch (SQLException e) {

		}
		return id;
		
	}

	@Override
	public TFactura readByCodigo(int codigo) {
		
		Connection con = null;
		TFactura aux = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		
		String query = "SELECT * FROM factura WHERE CODIGO_FACTURA=? FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();		
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TFactura();
				aux.setCodigo(res.getInt(1));
				aux.setCodigoTrabajador(res.getInt(2));
				aux.setFecha(res.getString(3));
				aux.setPrecioTotal(res.getDouble(4));
				aux.setEstado(res.getBoolean(5));			
			}
			
		}catch (Exception e) {
			System.out.println("");
		}
		
		return aux;
	
	}

	@Override
	public List<TFactura> readAll() {
		TFactura aux = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		List<TFactura> list = new ArrayList<TFactura>();
		
		Connection con = null;
		try {
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("select * from factura FOR UPDATE", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				aux = new TFactura();
				aux.setCodigo(res.getInt(1));
				aux.setCodigoTrabajador(res.getInt(2));
				aux.setFecha(res.getString(3));
				aux.setPrecioTotal(res.getDouble(4));
				aux.setEstado(res.getBoolean(5));	
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
			System.out.println("No lee todas las facturas");
		}
		
		return list;
		
	}

	@Override
	public TFacturaConProductos readFacturaConProductos(int codigo) {		
		
		TFacturaConProductos aux = new TFacturaConProductos();
		aux.settContiene(DAOAbstractFactory.getInstance().createDAOContiene().readById(codigo));
		
		
		return aux;
		
	}
	


	
	

}
