package Presentacion.Command.ComandosFactura;

import Negocio.SA.SAAbstractFactory;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarUnaFactura implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_FACTURA_FAILED,null);
		
		int id = (Integer) data;
		TCarrito t = (TCarrito) (SAAbstractFactory.getInstance().createSAFactura().read(id));
		
		
		if (t != null) {
			pair.setKey(Evento.RES_MOSTRAR_FACTURA_OK);
			pair.setValue(t.gettFactura());
		}
		
		return pair;
		
	}

}
