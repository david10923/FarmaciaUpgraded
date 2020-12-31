package Presentacion.Laboratorio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Presentacion.Controller.*;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUILaboratorio extends JPanel implements IGUI {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private OperationsPanel OperationsPanel; 
	private MostrarTodosLaboratorios mostrarTodos; 
	private MostrarUno mostrarUno;
	private MostrarUno mostrarProductosLaboratorio;
	
	public GUILaboratorio(){
		
		
		OperationsPanel = new OperationsPanel(GUIFarmaciaImp.TAB_LABORATORIO);
		mostrarTodos = new MostrarTodosLaboratorios(GUIFarmaciaImp.TAB_LABORATORIO, null);
		mostrarUno = new MostrarUno(GUIFarmaciaImp.TAB_LABORATORIO,0);
		mostrarProductosLaboratorio = new MostrarUno(GUIFarmaciaImp.TAB_LABORATORIO,1);
		
		mostrarTodos.setPreferredSize(new Dimension(435,250));
		OperationsPanel.setPreferredSize(new Dimension(335,250));
		mostrarUno.setPreferredSize(new Dimension(150,290));
		mostrarProductosLaboratorio.setPreferredSize(new Dimension(600,290));
		mostrarProductosLaboratorio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarProductosLaboratorio",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.NORTH);
	
		this.add(mostrarUno,BorderLayout.EAST);
		this.add(mostrarProductosLaboratorio,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 new VentanaCrearLaboratorio();
			}
			
		});
		OperationsPanel.getBajaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBajaLaboratorio();
				
			}
			
		});
		OperationsPanel.getModificarBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModificarLaboratorio();				
			}
			
		});
		this.setVisible(true);
		
	}


	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_LABORATORIO_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Laboratorio creado con ID: " +idAlta.intValue());
			setVisible(true);
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_LABORATORIOS);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSALaboratorio().readAll());
			mostrarProductosLaboratorio.llenarCombo();
			break;
			
		case Evento.RES_ALTA_LABORATORIO_FAILED:
					
			JOptionPane.showMessageDialog(null,"No se ha podido crear al laboratorio ");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_LABORATORIO_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Laboratorio puesto a inactivo con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_LABORATORIOS);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSALaboratorio().readAll());
			mostrarProductosLaboratorio.llenarCombo();
			
			//Controller.getInstance().action(idBaja, Evento.BAJA_PRODUCTOS_POR_LABORATORIO);
			
			
			
			break;
			
		case Evento.RES_BAJA_LABORATORIO_FAILED: // revisar el mensaje // ver si hay que poner que ya estaba dado de baja 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo  al laboratorio ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_LABORATORIO_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_LABORATORIOS);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSALaboratorio().readAll());
			mostrarProductosLaboratorio.llenarCombo();
			
			break;
			
		case Evento.RES_MODIFICAR_LABORATORIO_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_LABORATORIO_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_LABORATORIO_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar el trabajador");
			
			
			break;
		case Evento.RES_MOSTRAR_TODOS_LABORATORIOS_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_LABORATORIOS_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se han podido mostrar los trabajadores");
			

			
			break;
		case Evento.RES_REACTIVAR_LABORATORIO_OK:
			
			Integer idAct = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Laboratorio reactivado correctamente");
			setVisible(true);
			mostrarUno.llenarCombo();
			mostrarProductosLaboratorio.llenarCombo();
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_LABORATORIOS);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSALaboratorio().readAll());

			break;
		case Evento.DATOS_INCORRECTOS_LABORATORIO:
			
			String message = (String) data;
			JOptionPane.showMessageDialog(null,"Datos Incorrectos");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_OK:
			
			mostrarProductosLaboratorio.setInfo(data);
			mostrarProductosLaboratorio.llenarCombo();
			break;
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_FAIL:

			JOptionPane.showMessageDialog(null,"No se han podido mostrar todos los productos de un laboratorio");
			setVisible(true);
			
			
			break;
			
		case Evento.RES_REACTIVAR_PRODUCTOS_LABORATORIO_OK:
			
			JOptionPane.showMessageDialog(null,"Se han reactivado todos los productos del laboratorio");
			setVisible(true);
			
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_LABORATORIOS);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSALaboratorio().readAll());
			break;
		
		
		case Evento.RES_REACTIVAR_PRODUCTOS_LABORATORIO_FAIL:
			
			JOptionPane.showMessageDialog(null,"No se han podido reactivar productos del laboratorio");
			setVisible(true);
			
			break;
		
		default:
			break;
		}
		
	}

}
