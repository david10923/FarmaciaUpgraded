package Negocio.SA;

import Negocio.Factura.SAFactura;
import Negocio.Factura.SAFacturaImp;
import Negocio.Laboratorio.SALaboratorio;
import Negocio.Laboratorio.SALaboratorioImp;
import Negocio.Producto.SAProducto;
import Negocio.Producto.SAProductoImp;
import Negocio.Trabajador.SATrabajador;
import Negocio.Trabajador.SATrabajadorImp;

public class SAAbstractFactoryImp extends SAAbstractFactory  {

	
	@Override
	public SATrabajador createSATrabajador() {
		return new SATrabajadorImp();
	}

	public SALaboratorio createSALaboratorio() {
		return new SALaboratorioImp();
	}
	
	public SAProducto createSAProducto() {
		return new SAProductoImp();
	}

	@Override
	public SAFactura createSAFactura() {
		return new SAFacturaImp();
	}


	
}
