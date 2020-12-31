package Presentacion.Command.ComandosSala;

import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Negocio.Salas.TSala;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAltaSala implements Command{

	@Override
	public Pair<Integer,Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String nombreRegexp = "[A-HJ-NP-TV-Z]";
		
		TSala tSala = (TSala) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_SALA,null);		
		
	
		if(tSala == null) {
			return pair;
		}		
		
	/*
			int res = SAAbstractFactory.getInstance().createSASala().create(tSala);			
			
			if (res > 0) {
				pair.setKey(Evento.RES_ALTA_SALA_OK);
				pair.setValue(res);
			} else if (res == 0) {
				pair.setKey(Evento.RES_REACTIVAR_SALA_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_ALTA_SALA_FAILED);
				pair.setValue(res);
			}
			
		*/
	
		return pair;
	}


}
