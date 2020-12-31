package Presentacion.Vista;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Presentacion.Doctor.GUIDoctor;
import Presentacion.Especialidad.GUIEspecialidad;
import Presentacion.Factura.GUIFactura;
import Presentacion.Hospital.GUIHospital;
import Presentacion.Laboratorio.GUILaboratorio;
import Presentacion.Producto.GUIProducto;
import Presentacion.Salas.GUISalas;
import Presentacion.Trabajador.GUITrabajador;
import Presentacion.Vista.*;


public class GUIFarmaciaImp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public static String TAB_PROVEEDOR = "Proveedor";
	public static String TAB_TRABAJADOR = "Trabajador";
	public static String TAB_FACTURA = "Factura";
	public static String TAB_LABORATORIO = "Laboratorio";
	public static String TAB_PRODUCTO = "Producto";
	public static String TAB_DOCTOR ="Doctor";
	public static String TAB_SALAS ="Salas";
	public static String TAB_ESPECIALIDAD ="Especialidad";
	public static String TAB_HOSPITAL ="Hospital";

	private JTabbedPane tabs;

	public GUIFarmaciaImp(String info) {
		super(info);
		initGui();
		
		

	}

	public void initGui() {

		this.setBounds(350, 100, 900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());// comprobar

	}

	public IGUI getIGUI(int x) {
		return (IGUI) tabs.getComponent(Math.abs(x));
	}
	
	public void initTabs(List<Object> guis) {
		
		tabs = new JTabbedPane();
		tabs.setTabPlacement(JTabbedPane.LEFT); //para poner los tabs arriba , en la srs estan en la izquierda
		tabs.addTab("General", (VistaGeneral)guis.get(0));
		tabs.addTab(TAB_TRABAJADOR, null , (GUITrabajador)guis.get(1),"Trabajador");
		tabs.addTab(TAB_LABORATORIO, null , (GUILaboratorio)guis.get(2),"Laboratorio");
		tabs.addTab(TAB_PRODUCTO, null, (GUIProducto)guis.get(3), "Producto");
		tabs.addTab(TAB_FACTURA,null,(GUIFactura)guis.get(4),"Factura");
//		tabs.addTab(TAB_DOCTOR, null ,(GUIDoctor)guis.get(5),"Doctor");
//		tabs.addTab(TAB_SALAS, null ,(GUISalas)guis.get(6),"Salas");
//		tabs.addTab(TAB_ESPECIALIDAD, null ,(GUIEspecialidad)guis.get(7),"Especialidad");
//		tabs.addTab(TAB_HOSPITAL, null ,(GUIHospital)guis.get(8),"Hospital");
//		
		
		this.add(tabs, BorderLayout.CENTER);
		

		test();
		
	}

	public void test() {
		
		tabs.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				switch(tabs.getSelectedIndex()) {				
				case 1:
					Controller.getInstance().action(1, Evento.MOSTRAR_TODOS_TRABAJADORES);
					break;
				case 2:
					Controller.getInstance().action(1, Evento.MOSTRAR_TODOS_LABORATORIOS);
					break;
				case 3:
					Controller.getInstance().action(1, Evento.MOSTRAR_TODOS_PRODUCTOS);
					
					break;
				case 4:
					Controller.getInstance().action(1 ,Evento.MOSTRAR_TODOS_FACTURAS);
					break;
			
				case 5:
					Controller.getInstance().action(1 ,Evento.MOSTRAR_TODOS_DOCTORES);
					break; 
				case 6:
					Controller.getInstance().action(1 ,Evento.MOSTRAR_TODAS_SALAS);
					break;
				case 7:
					Controller.getInstance().action(1 ,Evento.MOSTRAR_TODAS_ESPECIALIDADES);
					break;
				case 8: 
					Controller.getInstance().action(1 ,Evento.MOSTRAR_TODOS_HOSPITALES);
					break;
				}
			}
			
		});

	}
	
}
