package Presentacion.Dispacher;

import Presentacion.Vista.IGUI;

public abstract class Dispatcher {
	
	private static Dispatcher instance;
	
	public static Dispatcher getInstance() {
		if (instance == null) {
			instance = new DispatcherImp();
		}
		return instance;
	}

	public abstract void getGUI(Integer Evento,Object Data);

}
