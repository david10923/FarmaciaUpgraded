package Presentacion.Hospital;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Negocio.Hospital.THospital;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaModificarHospital extends JDialog {

	
private static final long serialVersionUID = 1L;
	

	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	private JLabel DIRECCION_Label;
	private JTextField DIRECCION_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaModificarHospital(){
		
		iniciarventana();
		
		
		
		
		
	/////NOMBRE //////		
			NOMBRE_Label = new JLabel("NOMBRE: ");		
			NOMBRE_Label.setBounds(10, 120, 165, 25);		
			this.add(NOMBRE_Label);		
			NOMBRE_Text = new JTextField();		
			NOMBRE_Text.setBounds(100, 120, 165, 25);		
			this.add(NOMBRE_Text);
			
			
		////////DIRECCION////////
		DIRECCION_Label = new JLabel("DIRECCION: ");		
		DIRECCION_Label.setBounds(10, 20, 80, 25);		
		this.add(DIRECCION_Label);		
		DIRECCION_Text = new JTextField();		
		DIRECCION_Text.setBounds(100, 20, 165, 25);		
		this.add(DIRECCION_Text);
		
		
	//////BOTON DE ACEPTAR/////
			botonAceptar = new JButton("Aceptar");
			botonAceptar.setBounds(80, 160, 80, 25);
			botonAceptar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					THospital aux = null;
					if(!NOMBRE_Text.getText().equals("") && !DIRECCION_Text.getText().equals("") ) {
							aux = new THospital(NOMBRE_Text.getText(),DIRECCION_Text.getText());
					}
					Controller.getInstance().action(aux, Evento.MODIFICAR_HOSPITAL);
					
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
		this.setTitle("Modificar Trabajador");
	}
	
	public void removeBox() {
		NOMBRE_Text.setText(null);
		DIRECCION_Text.setText(null);
	}

}


