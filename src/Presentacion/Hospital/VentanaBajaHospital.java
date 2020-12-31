package Presentacion.Hospital;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaBajaHospital extends JDialog implements ActionListener{

	private JLabel CODIGO_Label; 
	private JTextField CODIGO_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	
	
	
	public VentanaBajaHospital() {
		

		iniciarventana();
		
		
		CODIGO_Label = new JLabel("Codigo: ");		
		CODIGO_Label.setBounds(10, 120, 165, 25);		
		this.add(CODIGO_Label);		
		CODIGO_Text = new JTextField();		
		CODIGO_Text.setBounds(100, 120, 165, 25);		
		this.add(CODIGO_Text);
		
		
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
		this.setTitle("Baja Sala");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			
			String aux = CODIGO_Text.getText();
			/*if(!aux.equals("")) {
				Controller.getInstance().action(aux, Evento.BAJA_TRABAJADOR);	
			}
			*/
			Controller.getInstance().action(aux, Evento.BAJA_HOSPITAL);	
			
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
