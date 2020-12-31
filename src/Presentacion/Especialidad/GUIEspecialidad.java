package Presentacion.Especialidad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Presentacion.Producto.MostrarTodosProductos;
import Presentacion.Salas.VentanaBajaSala;
import Presentacion.Salas.VentanaCrearSala;
import Presentacion.Salas.VentanaModificarSala;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUIEspecialidad extends JPanel implements ActionListener, IGUI {
	
	private OperationsPanel OperationsPanel; 
	private MostrarTodos mostrarTodos; 
	private MostrarUno mostrarUno;
	private JButton MostrarTrabajadores;
	
	
	
	public GUIEspecialidad(){
		
		this.setVisible(true);
		OperationsPanel = new OperationsPanel(GUIFarmaciaImp.TAB_PRODUCTO);
		mostrarTodos = new MostrarTodosProductos(GUIFarmaciaImp.TAB_PRODUCTO, null);
		mostrarUno = new MostrarUno(GUIFarmaciaImp.TAB_PRODUCTO);
		MostrarTrabajadores=new JButton(" Trabajador x Prod");
		OperationsPanel.getToolBar().addSeparator();
		OperationsPanel.getToolBar().add(MostrarTrabajadores);
		
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.EAST);
		this.add(mostrarUno,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(this);
		OperationsPanel.getBajaBoton().addActionListener(this);
		OperationsPanel.getModificarBoton().addActionListener(this);
		MostrarTrabajadores.addActionListener(this);
		

		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == OperationsPanel.getAltaBoton()) {
			VentanaCrearSala addSala = new VentanaCrearSala();
		}else if (botonPulsado == OperationsPanel.getBajaBoton()) {
			VentanaBajaSala bajaSala = new VentanaBajaSala();
		}else if (botonPulsado == OperationsPanel.getModificarBoton()) {
			VentanaModificarSala modSala = new VentanaModificarSala();
		}

		
	}
	
	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_SALA_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Sala creada con ID: " +idAlta.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODAS_SALAS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			break;
			
		case Evento.RES_ALTA_SALA_FAILED:
					
			JOptionPane.showMessageDialog(null,"La sala indicado esta inactivo , no se puede dar de alta la sala");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_SALA_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Sala puesta a inactiva con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODAS_SALAS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			break;
			
		case Evento.RES_BAJA_SALA_FAILED: // revisar el mensaje // ver si hay que poner que ya estaba dado de baja 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo el producto ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_SALA_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificada correctamente: " +idMod.intValue());
			setVisible(true);
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODAS_SALAS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			
			break;
			
		case Evento.RES_MODIFICAR_SALA_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_SALA_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_SALA_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar la sala");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TODAS_SALAS_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODAS_SALAS_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar todos los productos ");
			setVisible(true);
			
			break;
			
		case Evento.RES_REACTIVAR_SALA_OK:
			
			Integer idAct = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Producto reactivado correctamente");
			setVisible(true);
			
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			
			break;
		case Evento.DATOS_INCORRECTOS_SALA: 
			JOptionPane.showMessageDialog(null,"Los datos introducidos no son correctos");
			setVisible(true);
			
			break;
					
		
	}
	
	
	
	

	}
}
