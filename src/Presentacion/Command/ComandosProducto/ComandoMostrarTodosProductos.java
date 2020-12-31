package Presentacion.Command.ComandosProducto;


import java.util.List;

import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosProductos implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FAILED,null);
		List<TProducto> aux = SAAbstractFactory.getInstance().createSAProducto().readAll();
		
		if (data!=null) {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_OK);
			pair.setValue(aux);
		}
		
		return pair;
	}

}
