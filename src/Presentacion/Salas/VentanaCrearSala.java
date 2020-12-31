package Presentacion.Salas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Negocio.Salas.TSala;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaCrearSala extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel PLANTA_Label;
	private JTextField PLANTA_Text;
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	private JLabel AFORO_Label;
	private JTextField AFORO_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaCrearSala(){
		
		iniciarventana();
	/////NOMBRE //////		
			NOMBRE_Label = new JLabel("NOMBRE: ");		
			NOMBRE_Label.setBounds(10, 120, 165, 25);		
			this.add(NOMBRE_Label);		
			NOMBRE_Text = new JTextField();		
			NOMBRE_Text.setBounds(100, 120, 165, 25);		
			this.add(NOMBRE_Text);
			
			
			////////DNI////////
			PLANTA_Label = new JLabel("Planta: ");		
			PLANTA_Label.setBounds(10, 20, 80, 25);		
			this.add(PLANTA_Label);		
			PLANTA_Text = new JTextField();		
			PLANTA_Text.setBounds(100, 20, 165, 25);		
			this.add(PLANTA_Text);
			
			
			///////TARJETA SANITARIA////////		
			AFORO_Label = new JLabel("Aforo: ");		
			AFORO_Label.setBounds(10, 70, 80, 25);		
			this.add(AFORO_Label);		
			AFORO_Text = new JTextField();		
			AFORO_Text.setBounds(100, 70, 165, 25);		
			this.add(AFORO_Text);
			this.add(Box.createRigidArea(new Dimension(5,5)));
		
			
		
		
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TSala aux = null;
				if(!NOMBRE_Text.getText().equals("") && !PLANTA_Text.getText().equals("") && !AFORO_Text.getText().equals("")) {
						aux = new TSala(NOMBRE_Text.getText(),PLANTA_Text.getText(),AFORO_Text.getText());
				}
				Controller.getInstance().action(aux, Evento.ALTA_SALA);
				
				removeBox();
				setVisible(false);			
				
			}
			
		});		
		this.add(botonAceptar);
		
		///////BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 160, 90, 25);
		botonCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);							
			}
			
		});			
		this.add(botonCancelar);
		
		
	}
	
	void iniciarventana(){
		
		this.setBounds(350, 100,300,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Alta Trabajador");
	}
	
	
	public void removeBox() {
		AFORO_Text.setText(null);
		PLANTA_Text.setText(null);
		NOMBRE_Text.setText(null);
	}
	

}

