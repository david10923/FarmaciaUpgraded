package Presentacion.Command.ComandosFactura;

import java.util.List;

import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodasFacturas implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		
		List<TFactura> aux = SAAbstractFactory.getInstance().createSAFactura().readAll();
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_MOSTRAR_TODOS_FACTURAS_FAILED,null);
		
		
		if (aux!=null) {
			pair.setKey(Evento.RES_MOSTRAR_TODOS_FACTURAS_OK);
			pair.setValue(aux);
		}
		
		return pair;
	}

}
