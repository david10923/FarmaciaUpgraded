package Presentacion.Laboratorio;

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
import Negocio.Laboratorio.TLaboratorio;

public class VentanaModificarLaboratorio extends JDialog {

	private JLabel ID_Label;
	private JTextField ID_Text;
	
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	
	private JLabel TELEFONO_Label;
	private JTextField TELEFONO_Text;

	private JLabel DIRECCION_Label;
	private JTextField DIRECCION_Text;

	private JButton botonAceptar;
	private JButton botonCancelar;

	public VentanaModificarLaboratorio() {

		iniciarventana();

		///// NOMBRE //////
		ID_Label = new JLabel("CODIGO: ");
		ID_Label.setBounds(10, 20, 165, 25);
		this.add(ID_Label);
		ID_Text = new JTextField();
		ID_Text.setBounds(100, 20, 165, 25);
		this.add(ID_Text);
		
		
		///// NOMBRE //////
		NOMBRE_Label = new JLabel("NOMBRE: ");
		NOMBRE_Label.setBounds(10, 70, 165, 25);
		this.add(NOMBRE_Label);
		NOMBRE_Text = new JTextField();
		NOMBRE_Text.setBounds(100, 70, 165, 25);
		this.add(NOMBRE_Text);

				
		//////// DNI////////
		TELEFONO_Label = new JLabel("TELEFONO: ");
		TELEFONO_Label.setBounds(10, 120, 80, 25);
		this.add(TELEFONO_Label);
		TELEFONO_Text = new JTextField();
		TELEFONO_Text.setBounds(100, 120, 165, 25);
		this.add(TELEFONO_Text);

		/////// TARJETA SANITARIA////////
		DIRECCION_Label = new JLabel("DIRECCION: ");
		DIRECCION_Label.setBounds(10, 170, 80, 25);
		this.add(DIRECCION_Label);
		DIRECCION_Text = new JTextField();
		DIRECCION_Text.setBounds(100, 170, 165, 25);
		this.add(DIRECCION_Text);
		this.add(Box.createRigidArea(new Dimension(5, 5)));

		////// BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 220, 80, 25);
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TLaboratorio aux = null; 
				
				if(!ID_Text.getText().equals("") && !NOMBRE_Text.getText().equals("")){
					int idL = Integer.parseInt(ID_Text.getText());
					
					 aux = new TLaboratorio(idL, NOMBRE_Text.getText(), TELEFONO_Text.getText(),
							DIRECCION_Text.getText());

				}
				
				Controller.getInstance().action(aux, Evento.MODIFICAR_LABORATORIO);

				removeBox();
				setVisible(false);			

			}

		});
		this.add(botonAceptar);

		/////// BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 220, 90, 25);
		botonCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});
		this.add(botonCancelar);

	}

	void iniciarventana() {

		this.setBounds(350, 100, 300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Modificar Laboratorio");
	}

	public void removeBox() {
		ID_Text.setText(null);
		NOMBRE_Text.setText(null);
		TELEFONO_Text.setText(null);
		NOMBRE_Text.setText(null);
		DIRECCION_Text.setText(null);
	}
}