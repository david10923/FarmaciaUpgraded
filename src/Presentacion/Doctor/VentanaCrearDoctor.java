package Presentacion.Doctor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Negocio.Doctor.TDoctor;
import Negocio.Trabajador.TTrabajador;
import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaCrearDoctor extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel DNI_Label; 
	private JTextField DNI_Text;
	private JLabel TELEFONO_Label;
	private JTextField TELEFONO_Text;
	private JLabel EMAIL_Label;
	private JTextField EMAIL_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaCrearDoctor(){
		
		iniciarventana();

		////////DNI////////
		DNI_Label = new JLabel("DNI: ");		
		DNI_Label.setBounds(10, 20, 80, 25);		
		this.add(DNI_Label);		
		DNI_Text = new JTextField();		
		DNI_Text.setBounds(100, 20, 165, 25);		
		this.add(DNI_Text);
		
		///////TELEFONO////////		
		TELEFONO_Label = new JLabel("TELEFONO: ");		
		TELEFONO_Label.setBounds(10, 70, 80, 25);		
		this.add(TELEFONO_Label);		
		TELEFONO_Text = new JTextField();		
		TELEFONO_Text.setBounds(100, 70, 165, 25);		
		this.add(TELEFONO_Text);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		////////EMAIL////////
		EMAIL_Label = new JLabel("EMAIL: ");		
		EMAIL_Label.setBounds(10, 120, 80, 25);		
		this.add(EMAIL_Label);		
		EMAIL_Text = new JTextField();		
		EMAIL_Text.setBounds(100, 120, 165, 25);		
		this.add(EMAIL_Text);
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TDoctor aux = null;
				if(!DNI_Text.getText().equals("") && !TELEFONO_Text.getText().equals("") && EMAIL_Text.getText().equals("")) {
						aux = new TDoctor(DNI_Text.getText(),TELEFONO_Text.getText(),EMAIL_Text.getText());
				}
				Controller.getInstance().action(aux, Evento.ALTA_DOCTOR);
				
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
		EMAIL_Text.setText(null);
	}
	

}

