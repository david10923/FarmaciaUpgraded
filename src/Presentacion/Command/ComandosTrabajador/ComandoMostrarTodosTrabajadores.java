package Presentacion.Command.ComandosTrabajador;

import java.util.List;

import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosTrabajadores implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		List<TTrabajador> aux = SAAbstractFactory.getInstance().createSATrabajador().readAll();
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FAILED,null);
		
		
		if (data!=null) {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_TRABAJADORES_OK);
			pair.setValue(aux);
		}
		
		return pair;
	}

}
