package Presentacion.Command.ComandosFactura;

import Negocio.Factura.TFacturaConProductos;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosProductosFactura  implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_FAILED,null);
		
		int id  = (Integer) data; 
		
		TFacturaConProductos p = (TFacturaConProductos) (SAAbstractFactory.getInstance().createSAFactura().readFacturaConProductos(id));			
		
		if(p != null) {
			pair.setKey( Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_OK);
			pair.setValue(p);
		}
		
		return pair;
	}

}
