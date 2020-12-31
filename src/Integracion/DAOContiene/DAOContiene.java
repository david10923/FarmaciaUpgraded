package Integracion.DAOContiene;




import java.util.List;

import Negocio.Factura.TContiene;
import Negocio.Producto.TProducto;

public interface DAOContiene {
	public int create(TProducto producto, int codigoFactura, int cantidadAnadida);
	public int update(TContiene contiene);
	public int delete (TContiene contiene);
	public List<TContiene>readById(int codigo);
	public List<TContiene>readAll();
	
}
