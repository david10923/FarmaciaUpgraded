package Presentacion.Command.ComandosFactura;

import Negocio.Factura.TCarrito;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoEliminarProductosFactura implements Command {

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_PRODUCTOS_ELIMINADOS_INCORRECTOS,null);		
		
		TCarrito carrito = (TCarrito) data;
		
		SAAbstractFactory.getInstance().createSAFactura().eliminarProductosFactura(carrito);
		
		
		if(carrito != null) {
			pair.setKey(Evento.DATOS_PRODUCTOS_ELIMINADOS_CORRECTOS);
			pair.setValue(carrito);
		}
		
		
		return pair;
		
	}

}
