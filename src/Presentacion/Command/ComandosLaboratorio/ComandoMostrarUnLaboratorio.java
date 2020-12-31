package Presentacion.Command.ComandosLaboratorio;

import Negocio.SA.SAAbstractFactory;
import Negocio.Laboratorio.TLaboratorio;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarUnLaboratorio implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_LABORATORIO_FAILED,null);
		int id = (Integer) data;
		
		TLaboratorio t = (TLaboratorio) (SAAbstractFactory.getInstance().createSALaboratorio().readById(id));

		if (t != null) {
			pair.setKey(Evento.RES_MOSTRAR_LABORATORIO_OK);
			pair.setValue(t);
			//gui.actualizar(t, Evento.RES_MOSTRAR_LABORATORIO_OK);
		}
		
		return pair;
		
	}

}
