package Negocio.Factura;

import java.util.List;

public interface SAFactura {
	
	public TCarrito create(TFactura factura);
	public TCarrito read (int codigo);
	public TFactura readByCodigo(int codigo);
	public List<TFactura> readAll();
	public int update(List<TContiene> contienes);
	public int delete(int tId);
	public TFacturaConProductos readFacturaConProductos(int codigo);
	public TCarrito anadirProductosFactura(TCarrito carrito);
	public TCarrito eliminarProductosFactura(TCarrito carrito);
	public int cerrarFactura(TCarrito carrito);
	public List<TContiene> readContieneDeFactura(int codigo);

}
