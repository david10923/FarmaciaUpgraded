package Presentacion.Command.ComandosTrabajador;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAltaTrabajador  implements Command{

	@Override
	public Pair<Integer,Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
		String telefonoRegexp = "^[0-9]{9}$";
		
		TTrabajador tTrabajador = (TTrabajador) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_TRABAJADOR,null);		
		
	
		if(tTrabajador == null) {
			return pair;
		}		
		
		else if(Pattern.matches(dniRegexp,tTrabajador.getDni()) && Pattern.matches(telefonoRegexp,tTrabajador.getTelefono())) {
			int res = SAAbstractFactory.getInstance().createSATrabajador().create(tTrabajador);			
			
			if (res > 0) {
				pair.setKey(Evento.RES_ALTA_TRABAJADOR_OK);
				pair.setValue(res);
			} else if (res == 0) {
				pair.setKey(Evento.RES_REACTIVAR_TRABAJADOR_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_ALTA_TRABAJADOR_FAILED);
				pair.setValue(res);
			}
			
		}
	
		return pair;
	}

}
