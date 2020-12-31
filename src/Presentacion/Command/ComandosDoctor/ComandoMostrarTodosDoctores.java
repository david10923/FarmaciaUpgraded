package Presentacion.Command.ComandosDoctor;

import java.util.List;

import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosDoctores  implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_DOCTORES_FAILED,null);
		//List<TProducto> aux = SAAbstractFactory.getInstance().createSAProducto().readAll();
		
		if (data!=null) {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_DOCTORES_OK);
			pair.setValue(null);
		}
		
		return pair;
	}

}
