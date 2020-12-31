package Presentacion.Producto;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Producto.TMedicamento;
import Negocio.Producto.TParafarmacia;
import Negocio.Producto.TProducto;

public class VentanaModificarProducto extends JDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//private JPanel mainPanel;
	
	private JLabel CODIGO_LABEL; 
	private JTextField CODIGO_Text;
	private JLabel DESCRIPCION_LABEL;
	private JTextField DESCRIPCION_TEXT;
	private JLabel NOMBRE_Label;
	private JTextField NOMBRE_Text;
	
	private JLabel UNIDADES_LABEL; 
	private JTextField UNIDADES_TEXT;
	private JLabel PRECIO_LABEL; 
	private JTextField PRECIO_TEXT;
	
	private JCheckBox medCheck;
	private JCheckBox paraCheck;
	private JLabel ALERGENOS_Label;
	private JTextField ALERGENOS_Text;
	
	//	private boolean receta;
	
	private JButton botonAceptar;
	private JButton botonCancelar;
	//private Dimension TEXTFIELD_DIMENSION;
	
	public VentanaModificarProducto(){
		
		iniciarventana();
		
		
		
		/////NOMBRE //////		
		NOMBRE_Label = new JLabel("NOMBRE: ");		
		NOMBRE_Label.setBounds(10, 160, 165, 25);		
		this.add(NOMBRE_Label);
		//mainPanel.add(NOMBRE_Label);
		NOMBRE_Text = new JTextField();		
		NOMBRE_Text.setBounds(100, 160, 165, 25);		
		this.add(NOMBRE_Text);
		//NOMBRE_Text.setSize(TEXTFIELD_DIMENSION);
		//mainPanel.add(NOMBRE_Text);
		
		////////DNI////////
		CODIGO_LABEL = new JLabel("CODIGO: ");		
		CODIGO_LABEL.setBounds(10, 20, 80, 25);		
		this.add(CODIGO_LABEL);
		//mainPanel.add(CODIGO_LABEL);
		CODIGO_Text = new JTextField();		
		CODIGO_Text.setBounds(100, 20, 165, 25);		
		this.add(CODIGO_Text);
		//CODIGO_Text.setSize(TEXTFIELD_DIMENSION);
		//mainPanel.add(CODIGO_Text);
		
		
		
		///////DESCRIPCION////////		
		DESCRIPCION_LABEL = new JLabel("DESCRIPCION: ");		
		//mainPanel.add(DESCRIPCION_LABEL);
		DESCRIPCION_LABEL.setBounds(10, 70, 110, 25);		
		this.add(DESCRIPCION_LABEL);		
		DESCRIPCION_TEXT = new JTextField();
		//DESCRIPCION_TEXT.setSize(TEXTFIELD_DIMENSION);
		//mainPanel.add(DESCRIPCION_TEXT);
		DESCRIPCION_TEXT.setBounds(100, 70, 165, 25);		
		this.add(DESCRIPCION_TEXT);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		

		UNIDADES_LABEL = new JLabel("UNIDADES: ");		
		UNIDADES_LABEL.setBounds(10, 110, 80, 25);		
		this.add(UNIDADES_LABEL);	
		//mainPanel.add(UNIDADES_LABEL);
		UNIDADES_TEXT = new JTextField();		
		//UNIDADES_TEXT.setSize(TEXTFIELD_DIMENSION);
		//mainPanel.add(UNIDADES_TEXT);
		UNIDADES_TEXT.setBounds(100, 110, 165, 25);		
		this.add(UNIDADES_TEXT);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		PRECIO_LABEL = new JLabel("PRECIO: ");
		//mainPanel.add(PRECIO_LABEL);
		PRECIO_LABEL.setBounds(10, 200, 80, 25);		
		this.add(PRECIO_LABEL);		
		PRECIO_TEXT = new JTextField();
		//PRECIO_TEXT.setSize(TEXTFIELD_DIMENSION);
		//mainPanel.add(PRECIO_TEXT);
		PRECIO_TEXT.setBounds(100, 200, 165, 25);		
		this.add(PRECIO_TEXT);
		this.add(Box.createRigidArea(new Dimension(5,5)));
		
		
		medCheck = new JCheckBox();
		medCheck.setText("Medicamento");
		//mainPanel.add(medCheck);
		medCheck.setBounds(20,250,120,40);
		this.add(medCheck);
		
		paraCheck = new JCheckBox();
		paraCheck.setText("Parafarmacia");
		paraCheck.setBounds(160,250,120,40);
		this.add(paraCheck);
		//mainPanel.add(paraCheck);
		
		ALERGENOS_Label = new JLabel("ALERGENOS: ");		
		ALERGENOS_Label.setBounds(10, 300, 90, 25);		
	    this.add(ALERGENOS_Label);		
		ALERGENOS_Text = new JTextField();		
		ALERGENOS_Text.setBounds(100, 300, 165, 25);		
		this.add(ALERGENOS_Text);
		//ALERGENOS_Text.setSize(TEXTFIELD_DIMENSION);
		ALERGENOS_Label.setVisible(false);
		ALERGENOS_Text.setVisible(false);
		//mainPanel.add(ALERGENOS_Label);
	    //mainPanel.add(ALERGENOS_Text);
		
		
		paraCheck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(paraCheck.isSelected()) {
					//botonAceptar.setBounds(80, 450, 80, 25);
					//botonCancelar.setBounds(170, 450, 90, 25);
					ALERGENOS_Label.setVisible(true);
					ALERGENOS_Text.setVisible(true);
					
					
				}else {
					ALERGENOS_Label.setVisible(false);
					ALERGENOS_Text.setVisible(false);
					//botonAceptar.setBounds(80, 350, 80, 25);
					//botonCancelar.setBounds(170, 350, 90, 25);
				}
				
				
			}
			
		});	
		
		
		//////BOTON DE ACEPTAR/////
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(80, 350, 80, 25);
		botonAceptar.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TProducto producto=null;
				
				if(!CODIGO_Text.getText().equals("") && !NOMBRE_Text.getText().equals("") &&
						!DESCRIPCION_TEXT.getText().equals("")  && !UNIDADES_TEXT.getText().equals("") && !PRECIO_TEXT.getText().equals("")){
					
					
					if (!ALERGENOS_Text.getText().equals("") && paraCheck.isSelected() && !medCheck.isSelected()) {					
						producto = new TParafarmacia(NOMBRE_Text.getText(),Integer.parseInt(CODIGO_Text.getText()), DESCRIPCION_TEXT.getText(),
								Integer.parseInt(UNIDADES_TEXT.getText()), Double.parseDouble(PRECIO_TEXT.getText()),
								ALERGENOS_Text.getText());
					}else if (medCheck.isSelected() && !paraCheck.isSelected()) {						
						producto = new TMedicamento( NOMBRE_Text.getText(),Integer.parseInt(CODIGO_Text.getText()), DESCRIPCION_TEXT.getText(),
								Integer.parseInt(UNIDADES_TEXT.getText()), Double.parseDouble(PRECIO_TEXT.getText()),
								true);
				
					}				
					
				}
				Controller.getInstance().action(producto, Evento.MODIFICAR_PRODUCTO);
				/*else {
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
		botonCancelar.setBounds(170, 350, 90, 25);
		botonCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);			
				dispose();				
			}
			
		});			
		this.add(botonCancelar);
		
		
		
	}
	
	void iniciarventana(){
		
		this.setBounds(350, 100,300,450);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Modificar Producto");
	}
	

	
	
	public void removeBox() {
		CODIGO_Text.setText(null);
		DESCRIPCION_TEXT.setText(null);
		NOMBRE_Text.setText(null);
		DESCRIPCION_TEXT.setText(null);
		PRECIO_TEXT.setText(null);
	}
	

}
