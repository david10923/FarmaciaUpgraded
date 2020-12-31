package Presentacion.Factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Factura.TFactura;
import Negocio.SA.SAAbstractFactory;

public class VentanaPedirCodigo extends JDialog{
	private JLabel ID_Label; 
	private JTextField ID_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	
	
	
	public VentanaPedirCodigo() {
		iniciarventana();
		
		
		ID_Label = new JLabel("CODIGO: ");		
		ID_Label.setBounds(10, 120, 165, 25);		
		this.add(ID_Label);		
		ID_Text = new JTextField();		
		ID_Text.setBounds(100, 120, 165, 25);		
		this.add(ID_Text);
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 160, 80, 25);
		botonAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int aux =-1;
				
				if (!ID_Text.getText().equals("")) {						
					
					 aux = Integer.parseInt(ID_Text.getText());												
					
				}
				
				
				Controller.getInstance().action(aux, Evento.PEDIR_CODIGO_FACTURA);
				
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
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//salta exception aqui
		this.setLayout(null);
		this.setTitle("Modificar Productos Factura");
	}
	
	
	public void removeBox() {
		ID_Text.setText(null);
	}
}
