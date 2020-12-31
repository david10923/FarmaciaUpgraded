package Presentacion.Command.ComandosProducto;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Producto.*;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAltaProducto implements Command{

	@Override
	public Pair<Integer,Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String nombreRegexp = "[A-HJ-NP-TV-Z]";
		
		TProducto tProducto = (TProducto) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_PRODUCTO,null);		
		
	
		if(tProducto == null) {
			return pair;
		}		
		
	
			int res = SAAbstractFactory.getInstance().createSAProducto().create(tProducto);			
			
			if (res > 0) {
				pair.setKey(Evento.RES_ALTA_PRODUCTO_OK);
				pair.setValue(res);
			} else if (res == 0) {
				pair.setKey(Evento.RES_REACTIVAR_PRODUCTO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_ALTA_PRODUCTO_FAILED);
				pair.setValue(res);
			}
			
		
	
		return pair;
	}

}

