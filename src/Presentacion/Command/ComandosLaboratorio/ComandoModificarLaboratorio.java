package Presentacion.Command.ComandosLaboratorio;

import java.util.regex.Pattern;

import Negocio.Laboratorio.TLaboratorio;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoModificarLaboratorio implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		String telefonoRegexp = "^[0-9]{9}$";
		
		TLaboratorio tLaboratorio = (TLaboratorio) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_LABORATORIO,null);
		
		if(tLaboratorio == null) {
			return pair;
		}
	
		else if(Pattern.matches(telefonoRegexp,tLaboratorio.getTelefono())){
			int res = SAAbstractFactory.getInstance().createSALaboratorio().update(tLaboratorio);

			if (res > 0) {
				pair.setKey(Evento.RES_MODIFICAR_LABORATORIO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_MODIFICAR_LABORATORIO_FAILED);
				pair.setValue(res);
			}
			
		}
		
		return pair;
	}

}
