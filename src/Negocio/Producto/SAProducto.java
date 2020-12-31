package Negocio.Producto;

import java.util.List;

public interface SAProducto {
	public int create(TProducto producto);
	public int delete(int id);	
	public int update(TProducto producto);
	public TProducto read (int id);
	public List<TProducto> readAll();
	public int bajaTodosProductosLaboratorio(int codigo);
	public int reactivarProductoslaboratorio(int codigo);
	public List<TProducto> mostrarTodosProductosTrabajador(int codigo);
	
}
