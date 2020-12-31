package Presentacion.Command.ComandosFactura;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoBajaFactura  implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String precio = "^[0-9]$";
		
		int idFactura = (Integer) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_FACTURA,null);		
		int res = SAAbstractFactory.getInstance().createSAFactura().delete(idFactura);	
		
		if (res > 0) {
			pair.setKey(Evento.RES_BAJA_FACTURA_OK);
			pair.setValue(res);
		} else {
			pair.setKey(Evento.RES_BAJA_FACTURA_FAILED);
			pair.setValue(res);
		}
		
		return pair;

	}
}