package Presentacion.Command.ComandosTrabajador;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoBajaTrabajador  implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		
		String dni_trabajador = (String) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_TRABAJADOR,null);		
		
		
		if(dni_trabajador!= null) {
			if(Pattern.matches(dniRegexp,dni_trabajador)){
				int res = SAAbstractFactory.getInstance().createSATrabajador().delete(dni_trabajador);	
				if (res > 0) {
					pair.setKey(Evento.RES_BAJA_TRABAJADOR_OK);
					pair.setValue(res);
				} else {
					pair.setKey(Evento.RES_BAJA_TRABAJADOR_FAILED);
					pair.setValue(res);
				}
			
			}
		}
		
		
		return pair;

	}
}
