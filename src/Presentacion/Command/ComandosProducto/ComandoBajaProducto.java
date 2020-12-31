package Presentacion.Command.ComandosProducto;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoBajaProducto  implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		String nombre = "[A-HJ-NP-TV-Z]";
		
		int idProducto = (Integer) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_PRODUCTO,null);		
		
		if(idProducto!=-1) {
	
			int res = SAAbstractFactory.getInstance().createSAProducto().delete(idProducto);	
			if (res > 0) {
				pair.setKey(Evento.RES_BAJA_PRODUCTO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_BAJA_PRODUCTO_FAILED);
				pair.setValue(res);
			}
		}
		
		return pair;

	}
}