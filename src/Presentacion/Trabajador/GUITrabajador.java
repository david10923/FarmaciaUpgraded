package Presentacion.Trabajador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUITrabajador extends JPanel implements IGUI {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private OperationsPanel OperationsPanel; 
	private MostrarTodosTrabajadores mostrarTodos; 
	private MostrarUno mostrarUno;
	private JButton MostrarProds;
	
	
	public GUITrabajador(){
		
		
		OperationsPanel = new OperationsPanel(GUIFarmaciaImp.TAB_TRABAJADOR);
		mostrarTodos = new MostrarTodosTrabajadores(GUIFarmaciaImp.TAB_TRABAJADOR, null);
		mostrarUno = new MostrarUno(GUIFarmaciaImp.TAB_TRABAJADOR);
		MostrarProds=new JButton("Prod x Trabajador");
		OperationsPanel.getToolBar().addSeparator();
		OperationsPanel.getToolBar().add(MostrarProds);

		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.EAST);
		this.add(mostrarUno,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 new VentanaCrearTrabajador();
			}
			
		});
		OperationsPanel.getBajaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBajaTrabajador();
				
			}
			
		});
		OperationsPanel.getModificarBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaModificarTrabajador();				
			}
			
		});
		MostrarProds.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMostrarProductosTrabajador();				
			}
		});
		this.setVisible(true);
		
	}


	@Override
	public void actualizar(Object data, Integer evento) {
		
		switch (evento) {
		
		case Evento.RES_ALTA_TRABAJADOR_OK:
			
			Integer idAlta = (Integer) data;
		
			JOptionPane.showMessageDialog(null,"Usuario creado con ID: " +idAlta.intValue());
			setVisible(true);
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_TRABAJADORES);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			break;
			
		case Evento.RES_ALTA_TRABAJADOR_FAILED:
					
			JOptionPane.showMessageDialog(null,"No se ha podido crear al trabajador ");
			setVisible(true);
			
			break;
			
			
		case Evento.RES_BAJA_TRABAJADOR_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Usuario puesto a inactivo con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_TRABAJADORES);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			break;
			
		case Evento.RES_BAJA_TRABAJADOR_FAILED: // revisar el mensaje // ver si hay que poner que ya estaba dado de baja 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner a inactivo  al trabajador ");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_TRABAJADOR_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_TRABAJADORES);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			
			break;
			
		case Evento.RES_MODIFICAR_TRABAJADOR_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TRABAJADOR_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_TRABAJADOR_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar el trabajador");
			
			
			break;
		case Evento.RES_MOSTRAR_TODOS_TRABAJADORES_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_TRABAJADORES_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se han podido mostrar los trabajadores");
			
			break;
		case Evento.RES_REACTIVAR_TRABAJADOR_OK:
			
			JOptionPane.showMessageDialog(null,"Trabajador reactivado correctamente");
			setVisible(true);
			mostrarUno.llenarCombo();
			
			Controller.getInstance().action(data,Evento.MOSTRAR_TODOS_TRABAJADORES);
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSATrabajador().readAll());
			
			break;
		case Evento.DATOS_INCORRECTOS_TRABAJADOR: 
			
			//String message = (String) data;
			
			JOptionPane.showMessageDialog(null,"Los datos introducidos no son correctos");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_PRODUCTOS_TRABAJADOR_OK:
			String aux = "Productos" + "\n";
			List<TProducto> list = (List<TProducto>) data;
			for(TProducto t : list) aux += "Nombre: " + t.getNombre() + "\n";
			JOptionPane.showMessageDialog(null, aux );
			setVisible(true);

			break;
			
		case Evento.RES_MOSTRAR_PRODUCTOS_TRABAJADOR_FAILED:
			JOptionPane.showMessageDialog(null,"El trabajador no ha vendido productos");
			break;
			
		default:
			break;
		}
		
	}

}
