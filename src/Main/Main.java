package Main;



import javax.swing.SwingUtilities;

import Presentacion.Controller.*;

public class Main {
	public static String name = "FARMACIA";
	
	

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {					
			public void run() {
				//new InfoDB();
				Controller.getInstance();

		}
		});
	}

}
