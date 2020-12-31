package Presentacion.Dispacher;


import Presentacion.Vista.GuiFarmaciaSingleton;

public class DispatcherImp extends Dispatcher{
	
	//private GuiFarmaciaSingleton farmacia;


	@Override
	public void getGUI(Integer event,Object data) {
	
		GuiFarmaciaSingleton.getInstance().update(event,data);
		
	}

}
