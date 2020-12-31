package Presentacion.Command.ComandosLaboratorio;



import java.util.List;

import Negocio.Laboratorio.TLaboratorio;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosLaboratorios implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_LABORATORIOS_FAILED,null);
		List<TLaboratorio> aux = SAAbstractFactory.getInstance().createSALaboratorio().readAll();
		
		if (data!=null) {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_LABORATORIOS_OK);
			pair.setValue(aux);
		}
		
		return pair;
	}

}
