package Presentacion.Command.ComandosLaboratorio;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosProductosLaboratorio implements Command {

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
			
		int idLabPro = (int) data;
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_FAIL,null);
		
		String sProList = SAAbstractFactory.getInstance().createSALaboratorio().readProductosLaboratorio(idLabPro);
		
		if (sProList != "") {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_OK);
			pair.setValue(sProList);
		}
		
		return pair;
	}

}
