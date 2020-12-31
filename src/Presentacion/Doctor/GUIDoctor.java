package Presentacion.Doctor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Presentacion.Producto.MostrarTodosProductos;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUIDoctor extends JPanel implements IGUI  {
	
	
	private OperationsPanel OperationsPanel; 
	private MostrarTodos mostrarTodos; 
	private MostrarUno mostrarUno;

	public GUIDoctor() {
		
		this.setVisible(true);
		OperationsPanel = new OperationsPanel(GUIFarmaciaImp.TAB_PRODUCTO);
		mostrarTodos = new MostrarTodosProductos(GUIFarmaciaImp.TAB_PRODUCTO, null);
		mostrarUno = new MostrarUno(GUIFarmaciaImp.TAB_PRODUCTO);
		OperationsPanel.getToolBar().addSeparator();
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.EAST);
		this.add(mostrarUno,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaCrearDoctor();
				
			}
			
		});
		OperationsPanel.getBajaBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBajaDoctor();
				
				
			}
			
		});
		OperationsPanel.getModificarBoton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModificarDoctor();
				
				
			}
			
		});
		
		this.setVisible(true);
	}

	@Override
	public void actualizar(Object data, Integer evento) {
		// TODO Auto-generated method stub
		
	}

	
}
