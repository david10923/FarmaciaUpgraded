package Presentacion.Controller;
import Presentacion.Command.Command;
import Presentacion.Command.CommandFactory;
import Presentacion.Dispacher.Dispatcher;
import Presentacion.Vista.GuiFarmaciaSingleton;
import utils.Pair;

public class ControllerImp extends Controller {

	//private IGUI gui;
	//private GUIFarmaciaImp farmacia;

	public ControllerImp() {		

		GuiFarmaciaSingleton.getInstance();
	}

	@SuppressWarnings("null")
	@Override
	public void action(Object data, Integer event) {
		String ms;
		int id;
		
		
		Command command =CommandFactory.getInstance().getCommand(event);
		//trycatch
		Pair<Integer,Object> respuestaExecute = command.execute(data);		
		
		//gui = farmacia.getIGUI(event / 100);		
		
		Dispatcher.getInstance().getGUI(respuestaExecute.getKey(),respuestaExecute.getValue());	
	}
}
