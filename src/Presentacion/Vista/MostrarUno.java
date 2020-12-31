package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Factura.TFactura;
import Negocio.Factura.TFacturaConProductos;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;

public class MostrarUno extends JPanel{
	
	JComboBox<String> combo;
	private String nameId;
	private JTextArea info;
	
	
	
	
	
	private int Index ;
	
	public MostrarUno(String nameId){
		super();
		this.nameId = nameId;
		initMostrarUno();
		createJComboBox();
		llenarCombo();
		addAction();
	}
	
	public MostrarUno(String nameId, int i){
		super();
		Index = i;
		this.nameId = nameId;
		initMostrarUno();
		createJComboBox();
		llenarCombo();
		addAction();
		
	}
	
	
	
	public void initMostrarUno(){
		
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarUno",
				TitledBorder.LEFT, TitledBorder.TOP));		
		
		this.setPreferredSize(new Dimension(400,275));		
		
		this.setVisible(true);
		
		
	}
	
	public void createJComboBox() {
		
		
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());
		
		this.add(p1, BorderLayout.PAGE_START);
		
		this.add(p2, BorderLayout.CENTER);
		
		
		
		info = new JTextArea();
		
		JScrollPane scroll = new JScrollPane(info);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		p2.add(scroll,BorderLayout.CENTER);
		
		
		combo = new JComboBox<String>();
	
		info.setEditable(false);
		
		combo.setVisible(true);
		
		p1.add(combo, BorderLayout.CENTER);
		
		//p2.add(info, BorderLayout.CENTER);
		
	
		p1.setVisible(true);
		p2.setVisible(true);
		
		
	}
	
	
	public void addAction() {
		
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (combo.getItemCount() > 0) {
					
					int id = Integer.parseInt(combo.getSelectedItem().toString().split(" - ")[0]);
					switch (nameId) {
					case "Trabajador":
						Controller.getInstance().action(id, Evento.MOSTRAR_TRABAJADOR);
						break;
					case "Laboratorio":
						if(Index == 0){
							Controller.getInstance().action(id, Evento.MOSTRAR_LABORATORIO);
						}else{
							Controller.getInstance().action(id,Evento.MOSTRAR_TODOS_PRODUCTOS_LABORATORIO);
						}
		
						break;
					case "Producto":
						Controller.getInstance().action(id, Evento.MOSTRAR_PRODUCTO);
						break;
					case "Factura":
						if(Index == 0){
							Controller.getInstance().action(id, Evento.MOSTRAR_FACTURA);
						}else{
							Controller.getInstance().action(id,Evento.MOSTRAR_TODOS_PRODUCTOS_FACTURA);
						}
						break;
					default:
						break;
					}
				}
				
				
				
			}
		});
		
	}
	
	
	public void llenarCombo() {
		
		combo.removeAllItems();
		
		switch (nameId) {
		case "Trabajador":
			
			for(Object tTra : SAAbstractFactory.getInstance().createSATrabajador().readAll()) {
				combo.addItem(((TTrabajador) tTra).getCodigo() + " - " + ((TTrabajador) tTra).getDni());
			}	
			break;
			
		case "Laboratorio":
			
			for(Object tLab : SAAbstractFactory.getInstance().createSALaboratorio().readAll()) {
				combo.addItem(((TLaboratorio) tLab).getCodigo() + " - " + ((TLaboratorio) tLab).getNombre());
			}	
			break;
			
		case "Producto":
			
			for(Object tPro : SAAbstractFactory.getInstance().createSAProducto().readAll()) {
				combo.addItem(((TProducto) tPro).getCodigo() + " - " + ((TProducto) tPro).getNombre());
			}	
			break;
		case "Factura":
			
			for(Object tFac : SAAbstractFactory.getInstance().createSAFactura().readAll()) {
				String fecha = "NO CREADA";
				
				if (((TFactura)tFac).getFecha() != null) {
					fecha =((TFactura)tFac).getFecha();
				}
				
				combo.addItem(((TFactura) tFac).getCodigo() + " - " + fecha);
			}	
			break;
		default:
			break;
		}
		
	}
	
	
	
	public void setInfo(Object aux) {
		
		switch (nameId) {
		
		case "Trabajador":
			
			info.setText(((TTrabajador)aux).toString());
			break;
			
		case "Laboratorio":
			
			if(this.Index == 0){
				info.setText(((TLaboratorio)aux).toString());
				
			}else{
				info.setText((String)aux);
			}
			
			break;
		case "Producto":
			
			info.setText(((TProducto)aux).toString());
			break;
			
		case "Factura": 
			
			if(this.Index == 0){
				info.setText(((TFactura)aux).toString());
				
			}else{
				info.setText(((TFacturaConProductos)aux).toString());
			}
			
			
			break;
		default:
			break;
		}
		
		
	}

}
