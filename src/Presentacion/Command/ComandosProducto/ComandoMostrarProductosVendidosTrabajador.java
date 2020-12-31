package Presentacion.Command.ComandosProducto;

import java.util.ArrayList;
import java.util.List;

import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarProductosVendidosTrabajador implements Command{



	@Override
	public Pair<Integer, Object> execute(Object data) {
		List<TProducto> aux = new ArrayList<TProducto>();
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_TRABAJADOR,null);	
		
		if(data!=null) {
			aux = SAAbstractFactory.getInstance().createSAProducto().mostrarTodosProductosTrabajador(Integer.parseInt(data.toString()));					
			if(!aux.isEmpty()) {
				pair.setKey(Evento.RES_MOSTRAR_PRODUCTOS_TRABAJADOR_OK);
				pair.setValue(aux);
			
			}
			else {
				pair.setKey(Evento.RES_MOSTRAR_PRODUCTOS_TRABAJADOR_FAILED);
				pair.setValue(null);
			
			}
		
		}
		
		return pair;

	}
}
