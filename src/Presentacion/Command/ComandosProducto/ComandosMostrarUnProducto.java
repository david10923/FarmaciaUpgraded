package Presentacion.Command.ComandosProducto;

import Negocio.SA.SAAbstractFactory;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandosMostrarUnProducto implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_PRODUCTO_FAILED,null);
		int id = (Integer) data;
		
		TProducto t = (TProducto) (SAAbstractFactory.getInstance().createSAProducto().read(id));

		if (t != null) {
			pair.setKey(Evento.RES_MOSTRAR_PRODUCTO_OK);
			pair.setValue(t);
		}
		
		return pair;
		
	}

}
