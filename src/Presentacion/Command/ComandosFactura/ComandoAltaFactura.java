package Presentacion.Command.ComandosFactura;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAltaFactura implements Command{

	@Override
	public Pair<Integer,Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String precioRegexp = "^[0-9]$";
		
		TFactura tFactura = (TFactura) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_FACTURA,null);		
		
	
		if(tFactura == null) {
			return pair;
		}				
		
		TCarrito carrito = SAAbstractFactory.getInstance().createSAFactura().create(tFactura);		
			
			
		if (carrito != null) {
			pair.setKey(Evento.ANADIR_PRODUCTOS_FACTURA);
			pair.setValue(carrito);
		} else {
			pair.setKey(Evento.RES_ALTA_FACTURA_FAILED);
			pair.setValue(carrito);
		}
				
	
		return pair;
	}

}

