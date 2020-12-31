package Presentacion.Trabajador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Trabajador.TTrabajador;

public class VentanaCrearTrabajador extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel DNI_Label; 
	private JTextField DNI_Text;
	private JLabel TELEFONO_Label;
	private JTextField TELEFONO_Text;
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaCrearTrabajador(){
		
		iniciarventana();
		
		
		/////NOMBRE //////		
		NOMBRE_Label = new JLabel("NOMBRE: ");		
		NOMBRE_Label.setBounds(10, 120, 165, 25);		
		this.add(NOMBRE_Label);		
		NOMBRE_Text = new JTextField();		
		NOMBRE_Text.setBounds(100, 120, 165, 25);		
		this.add(NOMBRE_Text);
		
		
		////////DNI////////
		DNI_Label = new JLabel("DNI: ");		
		DNI_Label.setBounds(10, 20, 80, 25);		
		this.add(DNI_Label);		
		DNI_Text = new JTextField();		
		DNI_Text.setBounds(100, 20, 165, 25);		
		this.add(DNI_Text);
		
		
		///////TARJETA SANITARIA////////		
		TELEFONO_Label = new JLabel("TELEFONO: ");		
		TELEFONO_Label.setBounds(10, 70, 80, 25);		
		this.add(TELEFONO_Label);		
		TELEFONO_Text = new JTextField();		
		TELEFONO_Text.setBounds(100, 70, 165, 25);		
		this.add(TELEFONO_Text);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TTrabajador aux = null;
				if(!NOMBRE_Text.getText().equals("") && !TELEFONO_Text.getText().equals("")) {
						aux = new TTrabajador(DNI_Text.getText(),NOMBRE_Text.getText(),TELEFONO_Text.getText());
				}
				Controller.getInstance().action(aux, Evento.ALTA_TRABAJADOR);
				
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
		DNI_Text.setText(null);
		TELEFONO_Text.setText(null);
		NOMBRE_Text.setText(null);
	}
	

}
