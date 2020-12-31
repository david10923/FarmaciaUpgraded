package Integracion.DAOProducto;

import java.util.List;

import Negocio.Producto.TMedicamento;
import Negocio.Producto.TParafarmacia;
import Negocio.Producto.TProducto;

public interface DAOProducto {
	public int create(TProducto producto);
	public int delete(int codigo);	
	public int update(TProducto producto, boolean reactivado);
	public TProducto readById (int id);
	public List<TProducto> readAll();
	public List<TProducto> readProductosPorLaboratorio();
	public int bajaTodosProductosLaboratorio(int codigo);
	public int reactivarProductoslaboratorio(int codigo);
	public TProducto readByNombreYLaboratorio(String name, int id);
	
	public int createMedicamento(TMedicamento producto);
	public int createParafarmacia(TParafarmacia producto);
	
	public int updateParafarmacia(TParafarmacia producto);
	public int updateMedicamento(TMedicamento producto);
	public int deleteParafarmacia(int codigo);
	public int deleteMedicamento(int codigo);
	public List<TProducto> MostrarProductosTrabajador(int codigo);
	
}
