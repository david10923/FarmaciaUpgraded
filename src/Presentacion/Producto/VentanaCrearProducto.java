package Presentacion.Producto;




import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JTextField;


import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Producto.TMedicamento;
import Negocio.Producto.TParafarmacia;
import Negocio.Producto.TProducto;

public class VentanaCrearProducto extends JDialog implements ActionListener {
	
	private JLabel CODIGO_Label; 
	private JTextField CODIGO_Text;
	private JLabel UNIDADES_Label; 
	private JTextField UNIDADES_Text;
	private JLabel DESCRIPCION_Label;
	private JTextField DESCRIPCION_Text;
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	private JLabel PRECIO_Label;
	private JTextField PRECIO_Text;
	private JCheckBox medCheck;
	private JCheckBox paraCheck;
	private JLabel ALERGENOS_Label;
	private JTextField ALERGENOS_Text;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public VentanaCrearProducto(){
		
		iniciarventana();
		
		
		CODIGO_Label = new JLabel("CODIGO_LAB:");		
		CODIGO_Label.setBounds(10, 20, 165, 25);		
		this.add(CODIGO_Label);		
		CODIGO_Text = new JTextField();		
		CODIGO_Text.setBounds(100, 20, 165, 25);		
		this.add(CODIGO_Text);
		
		
		/////NOMBRE //////		
		NOMBRE_Label = new JLabel("NOMBRE: ");		
		NOMBRE_Label.setBounds(10, 70, 165, 25);		
		this.add(NOMBRE_Label);		
		NOMBRE_Text = new JTextField();		
		NOMBRE_Text.setBounds(100, 70, 165, 25);		
		this.add(NOMBRE_Text);
		
		///////DESCRIPCION_Text////////		
		DESCRIPCION_Label = new JLabel("DESCRIPCION: ");		
		DESCRIPCION_Label.setBounds(10, 120, 80, 25);		
		this.add(DESCRIPCION_Label);		
		DESCRIPCION_Text = new JTextField();		
		DESCRIPCION_Text.setBounds(100, 120, 165, 25);		
		this.add(DESCRIPCION_Text);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		////////UNIDADES////////
		UNIDADES_Label = new JLabel("UNIDADES: ");		
		UNIDADES_Label.setBounds(10, 170, 80, 25);		
		this.add(UNIDADES_Label);		
		UNIDADES_Text = new JTextField();		
		UNIDADES_Text.setBounds(100, 170, 165, 25);		
		this.add(UNIDADES_Text);
		
		////////PRECIO////////
		PRECIO_Label = new JLabel("PRECIO: ");		
		PRECIO_Label.setBounds(10, 220, 80, 25);		
		this.add(PRECIO_Label);		
		PRECIO_Text = new JTextField();		
		PRECIO_Text.setBounds(100, 220, 165, 25);		
		this.add(PRECIO_Text);
		
		
		medCheck = new JCheckBox();
		medCheck.setText("Medicamento");
		medCheck.setBounds(20,250,120,40);
		this.add(medCheck);
		
		paraCheck = new JCheckBox();
		paraCheck.setText("Parafarmacia");
		paraCheck.setBounds(160,250,120,40);
		this.add(paraCheck);
		
		////////ALERGENOS////////
		ALERGENOS_Label = new JLabel("ALERGENOS: ");		
		ALERGENOS_Label.setBounds(10, 300, 80, 25);		
		this.add(ALERGENOS_Label);		
		ALERGENOS_Text = new JTextField();		
		ALERGENOS_Text.setBounds(100, 300, 165, 25);		
		this.add(ALERGENOS_Text);
		ALERGENOS_Label.setVisible(false);
		ALERGENOS_Text.setVisible(false);
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 300, 80, 25);
		botonAceptar.addActionListener(this);		
		this.add(botonAceptar);
		
		///////BOTON DE CANCELAR////////
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(170, 300, 90, 25);
		botonCancelar.addActionListener(this);			
		this.add(botonCancelar);
		
		
		paraCheck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(paraCheck.isSelected()) {
					botonAceptar.setBounds(80, 350, 80, 25);
					botonCancelar.setBounds(170, 350, 90, 25);
					ALERGENOS_Label.setVisible(true);
					ALERGENOS_Text.setVisible(true);
					
					
				}else {
					ALERGENOS_Label.setVisible(false);
					ALERGENOS_Text.setVisible(false);
					botonAceptar.setBounds(80, 300, 80, 25);
					botonCancelar.setBounds(170, 300, 90, 25);
				}
				
				
			}
			
		});	
	}
	
	void iniciarventana(){
		
		this.setBounds(350, 100,300,450);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Crear Producto");
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado == botonAceptar) {
			TProducto producto=null;
			if(!CODIGO_Text.getText().equals("") && !NOMBRE_Text.getText().equals("") &&
						!DESCRIPCION_Text.getText().equals("")  && !UNIDADES_Text.getText().equals("") && !PRECIO_Text.getText().equals("")){
				
				if (!ALERGENOS_Text.getText().equals(" ") && paraCheck.isSelected() && !medCheck.isSelected()) {
					
					producto = new TParafarmacia(Integer.parseInt(CODIGO_Text.getText()),NOMBRE_Text.getText(), DESCRIPCION_Text.getText(),
							Integer.parseInt(UNIDADES_Text.getText()), Double.parseDouble(PRECIO_Text.getText()),
							ALERGENOS_Text.getText());
				}else if (medCheck.isSelected() && !paraCheck.isSelected()) {

					producto = new TMedicamento(Integer.parseInt(CODIGO_Text.getText()), NOMBRE_Text.getText(), DESCRIPCION_Text.getText(),
							Integer.parseInt(UNIDADES_Text.getText()), Double.parseDouble(PRECIO_Text.getText()),
							true);
				}
				
			}
			
			
			Controller.getInstance().action(producto, Evento.ALTA_PRODUCTO);
			removeBox();
			setVisible(false);			
			
		}else if (botonPulsado == botonCancelar) {			
			setVisible(false);			
			
			
		}
		dispose();
		
		
	}
	
	public void removeBox() {
		UNIDADES_Text.setText(null);
		DESCRIPCION_Text.setText(null);
		NOMBRE_Text.setText(null);
		PRECIO_Text.setText(null);
		ALERGENOS_Text.setText(null);
	}

}
