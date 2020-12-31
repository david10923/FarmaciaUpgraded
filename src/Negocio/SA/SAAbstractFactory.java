package Negocio.SA;

import Negocio.Factura.SAFactura;
import Negocio.Laboratorio.SALaboratorio;
import Negocio.Producto.SAProducto;
import Negocio.Trabajador.SATrabajador;

public abstract class SAAbstractFactory {

	
	private static SAAbstractFactory instance;
	
	public static SAAbstractFactory getInstance() {
		if (instance == null) {
			instance = new SAAbstractFactoryImp();
		}
		return instance;
	}
	
	

	public abstract SATrabajador createSATrabajador();
	public abstract SALaboratorio createSALaboratorio();
	public abstract SAProducto createSAProducto();
	public abstract SAFactura createSAFactura();
	
}

