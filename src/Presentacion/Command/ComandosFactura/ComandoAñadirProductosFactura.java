package Presentacion.Command.ComandosFactura;

import Negocio.Factura.TCarrito;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAñadirProductosFactura implements Command {

	@Override
	public Pair<Integer, Object> execute(Object data) {
		
		
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_PRODUCTOS_ANADIDOS_INCORRECTOS,null);
		
		
		TCarrito carrito = (TCarrito) data;
		
		if(carrito.getUnidades()!= 0) {			
			SAAbstractFactory.getInstance().createSAFactura().anadirProductosFactura(carrito);
			
			
			if(carrito != null) {
				pair.setKey(Evento.DATOS_PRODUCTOS_ANNADIDOS_CORRECTOS);
				pair.setValue(carrito);
			}
			
		}
		
		
		
		
		return pair;
	}
	

	
	
}
