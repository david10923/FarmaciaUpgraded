package Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;

public class VentanaBajaProducto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel CODIGO_LABEL; 
	private JTextField CODIGO_TEXT;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	
	
	
	public VentanaBajaProducto() {
		

		iniciarventana();
		
		
		////////CODIGO////////
		CODIGO_LABEL = new JLabel("CODIGO: ");		
		CODIGO_LABEL.setBounds(10, 120, 165, 25);		
		this.add(CODIGO_LABEL);		
		CODIGO_TEXT = new JTextField();		
		CODIGO_TEXT.setBounds(100, 120, 165, 25);		
		this.add(CODIGO_TEXT);
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int aux =-1;
				if (!CODIGO_TEXT.getText().equals("")) {
					aux = Integer.parseInt(CODIGO_TEXT.getText());
						
					
				}
				Controller.getInstance().action(aux, Evento.BAJA_PRODUCTO);	/*else {
					Controller.getInstance().action("No has introducido datos", Evento.DATOS_INCORRECTOS_PRODUCTO);
				}
				*/
				removeBox();
				setVisible(false);	
						
			}
			
		});		
		this.add(botonAceptar);
		
		///////BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 160, 90, 25);
		botonCancelar.addActionListener(new ActionListener() {

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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//salta exception aqui
		this.setLayout(null);
		this.setTitle("Baja Producto");
	}

	
	public void removeBox() {
		CODIGO_TEXT.setText(null);
	}
	
}
