package Presentacion.Factura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Factura.TCarrito;
import Negocio.Factura.TContiene;
import Negocio.SA.SAAbstractFactory;
import Presentacion.Vista.GUIFarmaciaImp;
import Presentacion.Vista.IGUI;
import Presentacion.Vista.MostrarTodos;
import Presentacion.Vista.MostrarUno;
import Presentacion.Vista.OperationsPanel;

public class GUIFactura extends JPanel implements IGUI {
	
	private OperationsPanel OperationsPanel; 
	private MostrarTodos mostrarTodos; 
	private MostrarUno mostrarUno;
	
	private MostrarUno mostraFacturaConProductos;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GUIFactura(){
		
		
		this.setVisible(true);
		
		OperationsPanel = new OperationsPanel(GUIFarmaciaImp.TAB_FACTURA);
		mostrarTodos = new MostrarTodasFacturas(GUIFarmaciaImp.TAB_FACTURA, null);
		mostrarUno = new MostrarUno(GUIFarmaciaImp.TAB_FACTURA,0);
		
		
		mostraFacturaConProductos = new MostrarUno(GUIFarmaciaImp.TAB_FACTURA,1);
		
		mostrarTodos.setPreferredSize(new Dimension(435,250));
		OperationsPanel.setPreferredSize(new Dimension(335,250));
		mostrarUno.setPreferredSize(new Dimension(385,290));
		mostraFacturaConProductos.setPreferredSize(new Dimension(385,290));
		
		mostraFacturaConProductos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarFacturaConProductos",
				TitledBorder.LEFT, TitledBorder.TOP));		
	
		this.add(mostrarTodos, BorderLayout.NORTH);
		this.add(OperationsPanel, BorderLayout.NORTH);
		this.add(mostrarUno,BorderLayout.EAST);
		this.add(mostraFacturaConProductos,BorderLayout.WEST);
		
		OperationsPanel.getAltaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new VentanaCrearFactura();
				
			}
			
		});
		OperationsPanel.getBajaBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBajaFactura();
				
			}
			
		});
		OperationsPanel.getModificarBoton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPedirCodigo();
				
			}
			
		});
	}

	@Override
	public void actualizar(Object data, Integer evento) {
		
		
	switch (evento) {
		
		case Evento.RES_ALTA_FACTURA_OK:
		
			JOptionPane.showMessageDialog(null,"Factura creada correctamente");
			setVisible(true);
			mostrarUno.llenarCombo();
			mostraFacturaConProductos.llenarCombo();
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_FACTURAS);			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAFactura().readAll());
			break;
			
			
		case Evento.RES_ALTA_FACTURA_FAILED:
			
			JOptionPane.showMessageDialog(null,"Factura erronea ");
			setVisible(true);
			
			break;
			
		case Evento.ANADIR_PRODUCTOS_FACTURA:{
			
			TCarrito carrito = (TCarrito) data ;
			
			new VentanaAnadirProductosFactura(carrito);
			
			break;
		}	
		
		
		case Evento.RES_BAJA_FACTURA_OK:
			
			Integer idBaja = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Factura inactiva con ID: " + idBaja);
			setVisible(true);
			mostrarUno.llenarCombo();
			mostraFacturaConProductos.llenarCombo();
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAFactura().readAll());
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_FACTURAS);
			break;
			
		case Evento.RES_BAJA_FACTURA_FAILED: 
			
			JOptionPane.showMessageDialog(null,"No se ha podido poner inactiva la factura");
			setVisible(true);
			
			break;
			
		case Evento.RES_MODIFICAR_FACTURA_OK:
			
			Integer idMod = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente: " +idMod.intValue());
			setVisible(true);
			
			mostrarUno.llenarCombo();
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAFactura().readAll());
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_FACTURAS);
			mostraFacturaConProductos.llenarCombo();
			break;
			
		case Evento.RES_MODIFICAR_FACTURA_FAILED:
			
			
			JOptionPane.showMessageDialog(null,"No se ha podido modificar ");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_FACTURA_OK:
			
			mostrarUno.setInfo(data);
			
			break;
		case Evento.RES_MOSTRAR_FACTURA_FAILED:
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar la factura");
			setVisible(true);
			
			break;
		case Evento.RES_MOSTRAR_TODOS_FACTURAS_OK:
			
			mostrarTodos.update(data);
			
			break;
			
		case Evento.RES_MOSTRAR_TODOS_FACTURAS_FAILED:
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar todos los facturas");
			setVisible(true);

			
			break;
					
			
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_OK:
			
			mostraFacturaConProductos.setInfo(data);
			
			
			break;
		case Evento.RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_FAILED: 
			
			JOptionPane.showMessageDialog(null,"No se ha podido mostrar la factura con productos");
			setVisible(true);
			
			break;
			
		case Evento.DATOS_INCORRECTOS_FACTURA: 
			
			String message = (String) data;
			
			JOptionPane.showMessageDialog(null,"Datos incorrectos factura");
			setVisible(true);
			
			break;
			
		case Evento.DATOS_PRODUCTOS_ANNADIDOS_CORRECTOS:
			

			JOptionPane.showMessageDialog(null,"Se han añadido los productos correctamente");
			setVisible(true);
			
			
			break;
		
		case Evento.DATOS_PRODUCTOS_ANADIDOS_INCORRECTOS:
			
			JOptionPane.showMessageDialog(null,"No se han anadido los productos correctamente");
			setVisible(true);
			
			break;
			
		case Evento.DATOS_PRODUCTOS_ELIMINADOS_CORRECTOS:
			
			JOptionPane.showMessageDialog(null,"Se han eliminado los productos correctamente");
			setVisible(true);
			
		
			break;
			
		case Evento.DATOS_PRODUCTOS_ELIMINADOS_INCORRECTOS:
			
			JOptionPane.showMessageDialog(null,"No se han eliminado los productos correctamente");
			setVisible(true);
			
		
			break;
		case Evento.RES_CERRAR_FACTURA_OK: 
			
			int idAlt = (Integer) data;
			
			JOptionPane.showMessageDialog(null,"Factura creada con ID: " +idAlt);
			mostrarUno.llenarCombo();
			mostraFacturaConProductos.llenarCombo();
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAFactura().readAll());
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_FACTURAS);
			
			break;
			
		case Evento.RES_CERRAR_FACTURA_FAIL: 
			
			JOptionPane.showMessageDialog(null,"No se ha podido crear factura");
			mostrarUno.llenarCombo();
			mostraFacturaConProductos.llenarCombo();			
			
			Controller.getInstance().action(data, Evento.MOSTRAR_TODOS_FACTURAS);
			
			//mostrarTodos.update(SAAbstractFactory.getInstance().createSAFactura().readAll());
			break;	
		case Evento.RES_RELLENAR_CONTIENES_OK:
			
			VentanaModificarProductosFactura.setContienes((List<TContiene>)data);
			
			break;
			
		case Evento.RES_RELLENAR_CONTIENES_FAILED:
			JOptionPane.showMessageDialog(null,"No se han cargado los contienes");
			break;
			
		case Evento.RES_PEDIR_CODIGO_FACTURA_OK:
			int id  = (int)data;
			new VentanaModificarProductosFactura(id);
			break; 
		
		case Evento.RES_PEDIR_CODIGO_FACTURA_FAILED:
			int id1  = (int)data;
			JOptionPane.showMessageDialog(null,"Factura con id: " +id1+" inactiva, no se puede modificar ");
			break;
			
		case Evento.RES_PEDIR_CODIGO_FACTURA_INEXISTENTE:
			//int id2 = (int)data;
			JOptionPane.showMessageDialog(null,"Factura inexistente");
			break;
		
		
		default:
			break;
		}
		
		
	}
	
	

}
