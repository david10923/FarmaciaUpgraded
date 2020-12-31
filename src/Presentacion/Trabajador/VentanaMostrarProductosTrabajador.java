package Presentacion.Trabajador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaMostrarProductosTrabajador extends JDialog implements ActionListener{
	private JLabel CODIGO_Label; 
	private JTextField  CODIGO_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	private JTextArea info;
	
	
	
	
	public VentanaMostrarProductosTrabajador() {
		

		iniciarventana();
		
		
		CODIGO_Label = new JLabel("CODIGO: ");		
		CODIGO_Label.setBounds(10, 120, 165, 25);		
		this.add(CODIGO_Label);		
	    CODIGO_Text = new JTextField();		
		CODIGO_Text.setBounds(100, 120, 165, 25);		
		this.add(CODIGO_Text);
	    //////INFO DE ETXT AREA////////
		info = new JTextArea();
		JScrollPane scroll = new JScrollPane(info);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll);		
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(this);		
		this.add(botonAceptar);
		
		///////BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 160, 90, 25);
		botonCancelar.addActionListener(this);			
		this.add(botonCancelar);
		
		
	}
	
	
	void iniciarventana(){
		
		this.setBounds(350, 100,300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//salta exception aqui
		this.setLayout(null);
		this.setTitle("Mostrar Productos de un Trabajador");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			
			String aux = CODIGO_Text.getText();
			if(aux.equals("")) {
					
				//Controller.getInstance().action(aux, Evento.MOSTRAR_PRODUCTOS_TRABAJADOR);
				aux = null;
			}
			
			Controller.getInstance().action(aux, Evento.MOSTRAR_PRODUCTOS_TRABAJADOR);//else Controller.getInstance().action("No has introducido datos", Evento.DATOS_INCORRECTOS_TRABAJADOR);
				
			removeBox();
			setVisible(false);			
			
		}else if (botonPulsado == botonCancelar) {			
			setVisible(false);			
			
		}
		
		
	}
	
	public void removeBox() {
		CODIGO_Text.setText(null);
	}

}
