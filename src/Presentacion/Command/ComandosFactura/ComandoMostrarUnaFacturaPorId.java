package Presentacion.Command.ComandosFactura;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarUnaFacturaPorId implements Command {

	@Override
	public Pair<Integer, Object> execute(Object data) {
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.RES_PEDIR_CODIGO_FACTURA_INEXISTENTE,null);
		
		int id = (Integer) data;
		
		if(id!=-1) {
			TFactura t = (TFactura) (SAAbstractFactory.getInstance().createSAFactura().readByCodigo(id));
			
			if(t!= null) {		
			
				if (t.isEstado() && t.getPrecioTotal()>0) {
					pair.setKey(Evento.RES_PEDIR_CODIGO_FACTURA_OK);
					pair.setValue(t.getCodigo());
				}else {
					pair.setKey(Evento.RES_PEDIR_CODIGO_FACTURA_FAILED);
					pair.setValue(t.getCodigo());
				}
			}
		}
		
		
		return pair;
		
	}

}
