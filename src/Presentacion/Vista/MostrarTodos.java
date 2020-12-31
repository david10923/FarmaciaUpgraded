package Presentacion.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public abstract class  MostrarTodos extends JPanel {
	
	private String nameId;
	
	protected JTable table;
	
	public MostrarTodos(String nameId){
		super();
		this.nameId = nameId;
		initMostrarTodos();
		
	}
	
	public void initMostrarTodos(){		
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1), "MostrarTodos",
				TitledBorder.LEFT, TitledBorder.TOP));		
		
		this.setPreferredSize(new Dimension(775, 250));		
		

		
		this.setVisible(true);
		
	}

	
	public abstract void update(Object l);
	
	
}
