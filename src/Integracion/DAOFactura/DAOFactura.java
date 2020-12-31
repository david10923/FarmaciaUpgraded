package Integracion.DAOFactura;

import java.util.List;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;

public interface DAOFactura {
	public TCarrito create(TCarrito carrito);
	public TCarrito read(int codigo);
	public int delete(int codigo );	
	public int update(TFactura factura);
	public TFactura readByCodigo(int codigo);
	public List<TFactura> readAll();
	public TFacturaConProductos readFacturaConProductos(int codigo);
	
}
