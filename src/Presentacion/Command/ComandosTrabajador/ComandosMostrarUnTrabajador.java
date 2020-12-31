package Presentacion.Command.ComandosTrabajador;

import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandosMostrarUnTrabajador implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TRABAJADOR_FAILED,null);
		int id = (Integer) data;
		
		TTrabajador t = (TTrabajador) (SAAbstractFactory.getInstance().createSATrabajador().readById(id));

		if (t != null) {
			pair.setKey(Evento.RES_MOSTRAR_TRABAJADOR_OK);
			pair.setValue(t);
			//gui.actualizar(t, Evento.RES_MOSTRAR_TRABAJADOR_OK);
		}
		
		return pair;
		
	}

}
