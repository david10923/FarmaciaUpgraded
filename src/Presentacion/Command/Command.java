package Presentacion.Command;

import utils.Pair;

public interface Command {
	
	public Pair<Integer,Object> execute(Object data);

}
