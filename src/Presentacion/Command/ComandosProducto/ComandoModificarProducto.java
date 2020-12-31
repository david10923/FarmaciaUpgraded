package Presentacion.Command.ComandosProducto;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoModificarProducto implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		
		TProducto tProducto = (TProducto) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_PRODUCTO,null);
		
		if(tProducto == null) {
			return pair;
		}
	
			int res = SAAbstractFactory.getInstance().createSAProducto().update(tProducto);

			if (res > 0) {
				pair.setKey(Evento.RES_MODIFICAR_PRODUCTO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_MODIFICAR_PRODUCTO_FAILED);
				pair.setValue(res);
			}
			
	
		
		return pair;
	}

}
