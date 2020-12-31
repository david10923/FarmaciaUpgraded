package Presentacion.Producto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Vista.OperationsPanel;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;

public class GUIProducto extends JPanel implements ActionListener, IGUI {
	
	private OperationsPanel OperationsPanel; 
	private MostrarTodos mostrarTodos; 
	private MostrarUno mostrarUno;
	private JButton MostrarTrabajadores;
	
	
	
	public GUIProducto(){
		
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
			VentanaCrearProducto addClient = new VentanaCrearProducto();
		}else if (botonPulsado == OperationsPanel.getBajaBoton()) {
			VentanaBajaProducto bajaClient = new VentanaBajaProducto();
		}else if (botonPulsado == OperationsPanel.getModificarBoton()) {
			VentanaModificarProducto modCliente = new VentanaModificarProducto();
		}else if(botonPulsado==MostrarTrabajadores) {
			
			VentanaMostrarTrabajadoresProducto v= new VentanaMostrarTrabajadoresProducto();			
		}

		
	}
	
	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_PRODUCTO_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Producto creado con ID: " +idAlta.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			break;
			
		case Evento.RES_ALTA_PRODUCTO_FAILED:
					
			JOptionPane.showMessageDialog(null,"El laboratorio indicado esta inactivo , no se puede dar de alta el producto");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_PRODUCTO_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Producto puesto a inactivo con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			break;
			
		case Evento.RES_BAJA_PRODUCTO_FAILED: // revisar el mensaje // ver si hay que poner que ya estaba dado de baja 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo el producto ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_PRODUCTO_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			
			break;
			
		case Evento.RES_MODIFICAR_PRODUCTO_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_PRODUCTO_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_PRODUCTO_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar el producto");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar todos los productos ");
			setVisible(true);
			
			break;
			
		case Evento.RES_REACTIVAR_PRODUCTO_OK:
			
			Integer idAct = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Producto reactivado correctamente");
			setVisible(true);
			
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			
			break;
		case Evento.DATOS_INCORRECTOS_PRODUCTO: 
			JOptionPane.showMessageDialog(null,"Los datos introducidos no son correctos");
			setVisible(true);
			
			break;
			
		case Evento.RES_BAJA_PRODUCTOS_POR_LABORATORIO_OK:
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_PRODUCTOS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAProducto().readAll());
			break;
		case Evento.RES_MOSTRAR_TRABAJADORES_PRODUCTO_OK:
			String aux = "Trabajadores" + "\n";
			List<TTrabajador> list = (List<TTrabajador>) data;
			for(TTrabajador t : list) aux += "DNI: " + t.getDni() + "\n";
			JOptionPane.showMessageDialog(null, aux );
			setVisible(true);

			break;
		case Evento.RES_MOSTRAR_TRABAJADORES_PRODUCTO_FAILED:
			JOptionPane.showMessageDialog(null,"El trabajador no ha vendido productos");
			break;
		
		
	}
	
	
	
	

	}
	
}
