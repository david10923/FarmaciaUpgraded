package Presentacion.Command.ComandosFactura;


import java.util.List;

import Negocio.Factura.TContiene;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoRellenarContienes implements Command {

	
	

		@Override
		public Pair<Integer,Object> execute(Object data) {
			Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_RELLENAR_CONTIENES_FAILED,null);
			
			int codFactura = (int) data;
			
			if(codFactura > 0) {
				List<TContiene> l = SAAbstractFactory.getInstance().createSAFactura().readContieneDeFactura(codFactura);
				if(l != null) {
					pair.setKey(Evento.RES_RELLENAR_CONTIENES_OK);
					pair.setValue(l);
				}
			}
			
			return pair;
		}
}
