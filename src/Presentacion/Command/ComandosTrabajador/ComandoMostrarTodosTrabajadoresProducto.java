package Presentacion.Command.ComandosTrabajador;

import java.util.ArrayList;
import java.util.List;

import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoMostrarTodosTrabajadoresProducto implements Command{


	@Override
	public Pair<Integer, Object> execute(Object data) {
		List<TTrabajador> aux = new ArrayList<TTrabajador>();
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_PRODUCTO,null);	
		
		
		if(data!=null) {
			aux = SAAbstractFactory.getInstance().createSATrabajador().mostrarTodosTrabajadoresProducto(Integer.parseInt(data.toString()));	
			if(!aux.isEmpty()) {
				pair.setKey(Evento.RES_MOSTRAR_TRABAJADORES_PRODUCTO_OK);
				pair.setValue(aux);				
			}
			else {
				pair.setKey(Evento.RES_MOSTRAR_TRABAJADORES_PRODUCTO_FAILED);
				pair.setValue(null);
				
			}
		}
		
		return pair;
	}

}

