package Presentacion.Vista;

import java.util.ArrayList;
import java.util.List;

import Main.Main;
import Presentacion.Doctor.GUIDoctor;
import Presentacion.Factura.GUIFactura;
import Presentacion.Laboratorio.GUILaboratorio;
import Presentacion.Producto.GUIProducto;
import Presentacion.Trabajador.GUITrabajador;

public class GUIFarmacia extends GuiFarmaciaSingleton {
	
	private GUIFarmaciaImp farmacia;
	
	public GUIFarmacia() {
		farmacia = new GUIFarmaciaImp(Main.name);
		List<Object> guis = new ArrayList<>();

		guis.add(new VistaGeneral());
		guis.add(new GUITrabajador());
		guis.add(new GUILaboratorio());
		guis.add(new GUIProducto());
		guis.add(new GUIFactura());
		guis.add(new GUIDoctor());
		farmacia.initTabs(guis);
		
		
		//GUIFarmaciaImp farmacia = new GUIFarmaciaImp();
	}
	
	public GUIFarmaciaImp getFarmacia() {
		return farmacia;
	}

	@Override
	public void update(Integer event, Object data) {
		farmacia.getIGUI(event/100).actualizar(data,event);		
		
	}
	
	
}
