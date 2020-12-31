package Presentacion.Vista;


public abstract class GuiFarmaciaSingleton {
	
	private static GuiFarmaciaSingleton instance;
	
	public static GuiFarmaciaSingleton getInstance() {
		if(instance == null) {
			instance = new GUIFarmacia();
		}
		return instance;
	}
	public  abstract void update(Integer event,Object data);
	

}
