package Presentacion.Command.ComandosFactura;

import Negocio.Factura.TCarrito;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoCerrarFactura implements Command {

	@Override
	public Pair<Integer, Object> execute(Object data) {
		TCarrito carrito = (TCarrito) data ; 
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_CERRAR_FACTURA_FAIL,null);		
		
		int ok = SAAbstractFactory.getInstance().createSAFactura().cerrarFactura(carrito); 
		
		if(ok >0) {
			pair.setKey(Evento.RES_CERRAR_FACTURA_OK);
			pair.setValue(ok);
		}
		
		return pair;
	}
	
	

}
