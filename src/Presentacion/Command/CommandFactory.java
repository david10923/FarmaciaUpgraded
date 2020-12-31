package Presentacion.Command;

import Negocio.SA.SAAbstractFactory;
import Negocio.SA.SAAbstractFactoryImp;

public abstract class CommandFactory {
	
	private static CommandFactory instance;
	
	public static CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactoryImp();
		}
		return instance;
	}

	public abstract Command getCommand(Integer commandName);
}
