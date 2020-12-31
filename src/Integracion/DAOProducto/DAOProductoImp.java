package Integracion.DAOProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Integracion.Querys.FactoriaQuerys;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Producto.TMedicamento;
import Negocio.Producto.TParafarmacia;
import Negocio.Producto.TProducto;

public class DAOProductoImp implements DAOProducto {

	@Override
	public int create(TProducto producto) {
		Connection con = null;
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();
		String query = "INSERT INTO producto(CODIGO_LABORATORIO, NOMBRE, UNIDADES,DESCRIPCION"
				+ ", PRECIO, ESTADO, RECETA_MEDICAMENTO, ALERGENOS_PARAFARMACIA) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, producto.getCodigoLaboratorio());
			ps.setString(2, producto.getNombre());
			ps.setInt(3, producto.getUnidades());
			ps.setString(4, producto.getDescripcion());
			ps.setDouble(5, producto.getPrecio());
			ps.setBoolean(6, true);
			
			if (producto.isReceta()) {
				ps.setBoolean(7,true);
				ps.setString(8, "NO");
			}else if(producto.getAlergenos() != "") {
				ps.setBoolean(7, false);
				ps.setString(8, producto.getAlergenos());
			}
			
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
	public int createMedicamento(TMedicamento producto) {
		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		int id = -1;
		String query = "INSERT INTO medicamento(CODIGO_PRODUCTO,RECETA) VALUES (?,?)";
		
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, producto.getCodigo());
			ps.setBoolean(2, producto.isReceta());
		
			ps.executeUpdate();
			id = producto.getCodigo();
			
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		
		return id;
		
	}
	
	public int createParafarmacia(TParafarmacia producto) {
		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		int id = -1;
		String query = "INSERT INTO parafarmacia(CODIGO_PRODUCTO,ALERGENOS) VALUES (?,?)";
		
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, producto.getCodigo());
			ps.setString(2, producto.getAlergenos());
			ps.executeUpdate();
			id = producto.getCodigo();
		
			
			
		}catch (SQLException e) {
			System.out.println("No se ha podido crear");
		}
		
		
		return id;
		
	}
	
	
	

	@Override
	public int delete(int codigo) {
		int id = -1;
		
		Transaction t = TransactionManager.getInstance().getTransaction();
		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();		
			PreparedStatement ps = con.prepareStatement("UPDATE producto SET estado=(?) WHERE CODIGO_PRODUCTO=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
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
	public int update(TProducto producto,boolean reactivar) {
		int id = -1 , res;

		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
	
		try {
			con = (Connection) t.getResource();	
			if(!reactivar){
				
				PreparedStatement ps = con.prepareStatement("UPDATE producto SET NOMBRE=?, UNIDADES=?, DESCRIPCION=?, PRECIO=?,RECETA_MEDICAMENTO=?, ALERGENOS_PARAFARMACIA=? "
						+ " WHERE CODIGO_PRODUCTO=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, producto.getNombre());
				ps.setInt(2, producto.getUnidades());	
				ps.setString(3, producto.getDescripcion());
				ps.setDouble(4, producto.getPrecio());
				
				if (producto.isReceta()) {
					ps.setBoolean(5,true);
					ps.setString(6, "NO");
				}else if(producto.getAlergenos() != "") {
					ps.setBoolean(5, false);
					ps.setString(6, producto.getAlergenos());
				}

				ps.setInt(7,producto.getCodigo());	
				
				 res = ps.executeUpdate();
				
			} else{
				
				PreparedStatement ps2 = con.prepareStatement("UPDATE producto SET  ESTADO=? "
						+ " WHERE CODIGO_PRODUCTO=?", PreparedStatement.RETURN_GENERATED_KEYS);
				ps2.setBoolean(1,true);
				ps2.setInt(2,producto.getCodigo());
				 res = ps2.executeUpdate();
				
			}
			if(res > 0) {
				
				id = producto.getCodigo();
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se ha podido modifcar el producto ");
		}
		return id;
	}

	@Override
	public TProducto readById(int id) {
		
		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		TProducto aux = null;
		
		String query = "SELECT * FROM producto WHERE CODIGO_PRODUCTO =? FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps;			
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);			
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TProducto(res.getInt(1),res.getInt(2), res.getString(3),res.getInt(4)
						,res.getString(5),res.getDouble(6),res.getBoolean(7),res.getBoolean(8), res.getString(9));
				
			}
			
			
		}catch (Exception e) {
			System.out.println("No se ha leido bien el producto");
		}
		
		return aux;
	}

	@Override
	public List<TProducto> readAll() {
 		List<TProducto> list = new ArrayList<TProducto>();
 		Transaction t = TransactionManager.getInstance().getTransaction();
		
		Connection con = null;
		TProducto aux = null;
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("select * from producto for update", PreparedStatement.RETURN_GENERATED_KEYS);
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				aux = new TProducto(res.getInt(1),res.getInt(2), res.getString(3),res.getInt(4)
						,res.getString(5),res.getDouble(6),res.getBoolean(7),
						res.getBoolean(8), res.getString(9));
				list.add(aux);
			}
			
		} catch (Exception e) {
			list.clear();
			e.printStackTrace();
			System.out.println("No se han podido leer los productos");
		}
		
		return list;
	}
	
	public List<TProducto> readProductosPorLaboratorio() {
		
		return null;
	}
	
	public int bajaTodosProductosLaboratorio(int codigo) {
		int id = -1;

		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("UPDATE producto SET ESTADO=? WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, codigo);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				
				id = res;
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("No se han podido dar de baja los productos de ese laboratorio");
		}
		return id;
	}
	public int reactivarProductoslaboratorio(int codigo) {
		int id = -1;

		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("UPDATE producto SET ESTADO=? WHERE CODIGO_LABORATORIO=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, true);
			ps.setInt(2, codigo);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				
				id = res;
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se han podido reactivar los productos del laboratorio");
		}
		return id;
	}
	
	public TProducto readByNombreYLaboratorio(String name, int id) {
		
		Connection con = null;
		Transaction t = TransactionManager.getInstance().getTransaction();
		TProducto aux = null;
		
		String query = "SELECT * FROM producto WHERE (NOMBRE=? AND CODIGO_LABORATORIO=?) FOR UPDATE";
		
		try {
			con = (Connection) t.getResource();	
			PreparedStatement ps;
			ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setInt(2, id);
			
			ResultSet res = ps.executeQuery();
			
			if (res.next()) {
				aux = new TProducto(res.getInt(1),res.getInt(2), res.getString(3),res.getInt(4)
						,res.getString(5),res.getDouble(6),res.getBoolean(7),res.getBoolean(8), res.getString(9));
				
			}
			
		}catch (Exception e) {
			System.out.println("No se ha podido leer el producto por nombre y laboratorio");
		}
		
		return aux;
	}
	@Override
	public int updateParafarmacia(TParafarmacia producto) {
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();

		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("UPDATE parafarmacia SET ALERGENOS=?, WHERE CODIGO_PRODUCTO=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, producto.getAlergenos());	
			ps.setInt(2,producto.getCodigo());
			
			int res = ps.executeUpdate();		
			if(res > 0) {
				
				id = producto.getCodigo();
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se ha podido actualiar la farmacia");
		}
		return id;
	}
	@Override
	public int updateMedicamento(TMedicamento producto) {
		int id = -1;
		Transaction t = TransactionManager.getInstance().getTransaction();

		Connection con = null; 
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("UPDATE medicamento SET RECETA=?, WHERE CODIGO_PRODUCTO=?", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, producto.getAlergenos());	
			ps.setInt(2,producto.getCodigo());
			int res = ps.executeUpdate();
			
			if(res > 0) {				
				id = producto.getCodigo();
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se ha podido modificar el medicamento");
		}
		return id;
	}
	
	
	@Override
	public int deleteParafarmacia(int codigo) {
		int id = -1;
		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("DELETE FROM parafarmacia WHERE CODIGO_PRODUCTO=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = codigo;
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar la parafarmacia");
		}
		return id;

	}
	@Override
	public int deleteMedicamento(int codigo) {
		int id = -1;
		Connection con = null; 
		Transaction t = TransactionManager.getInstance().getTransaction();
		try {
			
			con = (Connection) t.getResource();	
			PreparedStatement ps = con.prepareStatement("DELETE FROM  medicamento WHERE CODIGO_PRODUCTO=(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, codigo);
			int res = ps.executeUpdate();
		
			if(res > 0) {
				id = codigo;
			}
			
			
		} catch (SQLException e) {
			System.out.println("No se ha podido eliminar el medicamento");
		}
		return id;

	}
	@Override
	public List<TProducto> MostrarProductosTrabajador(int codigo) {
		
		return (List<TProducto>) FactoriaQuerys.getInstance().crearProductosQueHanSidoVendidosPorCadaTrabajador().execute(codigo);
	}
	
	

}
