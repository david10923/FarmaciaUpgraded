package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;


public class OperationsPanel extends JPanel {

	private JButton altaBoton;
	private JButton bajaBoton;
	private JButton modificarBoton;
	private JToolBar jt;
	
	
	public OperationsPanel(String name) {
		super();
		initOperationPanel();
	}
	
	
	
	public void initOperationPanel() {	
			
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "Operations",
				TitledBorder.LEFT, TitledBorder.TOP));
		this.setPreferredSize(new Dimension(375, 275));
		
		
		this.setVisible(true);
		
		inicializarBotones();
	
	}
	
	
	public void inicializarBotones(){
		 jt = new JToolBar();
		
		
		this.add(jt,BorderLayout.CENTER);		
		
		//jt.setBackground(Color.CYAN);
		//Box caja1 = Box.createHorizontalBox();
		
		
		altaBoton      = new JButton("ALTA");
		bajaBoton      = new JButton("BAJA");
		modificarBoton = new JButton("MODIFICAR");

		jt.addSeparator(new Dimension(20,0));
		jt.add(altaBoton);
		jt.addSeparator();
		jt.add(bajaBoton);
		jt.addSeparator();
		jt.add(modificarBoton);
		
		
		altaBoton.setVisible(true);
		bajaBoton.setVisible(true);
		modificarBoton.setVisible(true);

		
	}
	


	public JButton getAltaBoton() {
		return altaBoton;
	}



	public JButton getBajaBoton() {
		return bajaBoton;
	}


	public JButton getModificarBoton() {
		return modificarBoton;
	}
	public JToolBar getToolBar() {
		
		return jt;
	}


	
}

