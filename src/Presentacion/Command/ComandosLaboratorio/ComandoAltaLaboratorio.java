package Presentacion.Command.ComandosLaboratorio;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Negocio.Laboratorio.TLaboratorio;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoAltaLaboratorio  implements Command{

	@Override
	public Pair<Integer,Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		String telefonoRegexp = "^[0-9]{9}$";
		
		TLaboratorio tLaboratorio = (TLaboratorio) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_LABORATORIO,null);		
		
	
		if(tLaboratorio == null) {
			return pair;
		}		
		
		else if(Pattern.matches(telefonoRegexp,tLaboratorio.getTelefono())) {
			int res = SAAbstractFactory.getInstance().createSALaboratorio().create(tLaboratorio);			
			
			if (res > 0) {
				pair.setKey(Evento.RES_ALTA_LABORATORIO_OK);
				pair.setValue(res);
			} else if (res == 0) {
				pair.setKey(Evento.RES_REACTIVAR_LABORATORIO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_ALTA_LABORATORIO_FAILED);
				pair.setValue(res);
			}
			
		}
	
		return pair;
	}

}

