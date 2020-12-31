package Presentacion.Command.ComandosLaboratorio;

import java.util.regex.Pattern;

import Negocio.SA.SAAbstractFactory;
import Presentacion.Command.Command;
import Presentacion.Controller.Evento;
import utils.Pair;

public class ComandoBajaLaboratorio implements Command{

	@Override
	public Pair<Integer, Object> execute(Object data) {
		// TODO Auto-generated method stub
		
		//String telefono = "^[0-9]{9}$";
		
		//String telefono_lab = (String) data;
		int idLaboratorio = (Integer) data;
		
		Pair<Integer,Object> pair = new Pair<Integer,Object>(Evento.DATOS_INCORRECTOS_LABORATORIO,null);		
		
		if(idLaboratorio != -1) {
			int res = SAAbstractFactory.getInstance().createSALaboratorio().delete(idLaboratorio);	
			if (res > 0) {
				pair.setKey(Evento.RES_BAJA_LABORATORIO_OK);
				pair.setValue(res);
			} else {
				pair.setKey(Evento.RES_BAJA_LABORATORIO_FAILED);
				pair.setValue(res);
			}
			
		}
			
			
		return pair;

	}
}