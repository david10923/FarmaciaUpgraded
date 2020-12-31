package Presentacion.Command.ComandosFactura;

import java.util.List;
import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Factura.TContiene;
import Negocio.Factura.TFactura;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoModificarFactura implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String precioRegexp = "^[0-9]$";
		
		List<TContiene> contienes = (List<TContiene>) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_FACTURA,null);
		
		if(contienes == null) {
			return pair;
		}
	
		
		int res = SAAbstractFactory.getInstance().createSAFactura().update(contienes);
		

		if (res > 0) {
			pair.setKey(Evento.RES_MODIFICAR_FACTURA_OK);
			pair.setValue(res);
		} else {
			pair.setKey(Evento.RES_MODIFICAR_FACTURA_FAILED);
			pair.setValue(res);
		}
			
		
		return pair;
	}

}
