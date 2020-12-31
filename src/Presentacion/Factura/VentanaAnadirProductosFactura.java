package Presentacion.Factura;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.AbstractTableModel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Factura.TCarrito;
import Negocio.Producto.TProducto;



public class VentanaAnadirProductosFactura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel tablePanel;
	private JPanel addDeletePanel;
	private JPanel mainPanel;
	
	
	private JLabel id_producto_label;
	private JTextField id_producto_text;	
	
	private JLabel nombre_producto_label;
	private JTextField nombre_producto_text;
	
	
	private JLabel cantidad_producto_label;
	private JSpinner cantidad_producto;	
	
	private JButton anadirBoton;
	private JButton eliminarBoton;
	private JButton botonOK;
	private JButton botonCancelar;
	
	private JTable PRODUCTOS_TABLE;
	AbstractTableModel TABLE_MODEL;
	private String [] columnas = { "CODIGO_PRODUCTO" , "NOMBRE" ,"CANTIDAD"};
	
	private List<TProducto> productos;
	private TCarrito carrito ; 

	public VentanaAnadirProductosFactura(TCarrito carrito ) {
		this.setTitle("Anadir Productos Factura");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);
		inicializaVentana();
		this.setBounds(250,100,700,600);
		this.setVisible(true);
		
		productos = new ArrayList<TProducto>();		
		this.carrito = carrito ;
	}
	
	private void PanelDerecha (){
		addDeletePanel          = new JPanel();
		addDeletePanel.setLayout(new FlowLayout(FlowLayout.CENTER));	
		addDeletePanel.setLayout(new BoxLayout(addDeletePanel,BoxLayout.Y_AXIS));
		
		id_producto_label       = new JLabel("Codigo Producto:");
		id_producto_text        = new JTextField(10);
		nombre_producto_label   = new JLabel("Nombre Producto:");
		nombre_producto_text    = new JTextField(10);
		this.nombre_producto_text.setMaximumSize(new Dimension(200,100));
		cantidad_producto_label = new JLabel("Cantidad:");
		
		this.cantidad_producto = new JSpinner(new SpinnerNumberModel(0,0,20000,1));
		
		this.cantidad_producto.setMaximumSize(new Dimension(60,40));
		
		
		anadirBoton   = new JButton("ADD");		
		anadirBoton.setPreferredSize(new Dimension(100, 30));
		eliminarBoton = new JButton("DELETE");
		
		
		addDeletePanel.add(id_producto_label);
		addDeletePanel.add(id_producto_text);
		this.id_producto_text.setMaximumSize(new Dimension(200,100));
		addDeletePanel.add(nombre_producto_label);
		addDeletePanel.add(nombre_producto_text);
		addDeletePanel.add(cantidad_producto_label);
		addDeletePanel.add(cantidad_producto);
		addDeletePanel.add(Box.createRigidArea(new Dimension(100,10)));
		addDeletePanel.add(anadirBoton);		
		addDeletePanel.add(eliminarBoton);		
		mainPanel.add(addDeletePanel, BorderLayout.EAST);
		
	}
	
	
	private void PanelIzquierda(){

		tablePanel = new JPanel();
		tablePanel.setSize(new Dimension(250,300));
		init();
		mainPanel.add(tablePanel, BorderLayout.WEST);
		PRODUCTOS_TABLE.setVisible(true);
		JPanel bot = new JPanel();
		bot.setLayout(new FlowLayout(FlowLayout.CENTER));
		botonOK = new JButton("OK");
		botonOK.setPreferredSize(new Dimension(90, 25));
		botonCancelar = new JButton("CANCEL");
		botonCancelar.setPreferredSize(new Dimension(90, 25));
		bot.add(botonOK);
		bot.add(botonCancelar);
		mainPanel.add(bot, BorderLayout.SOUTH);
		
	}
	
	
	
	private void inicializaVentana() {
		
		PanelDerecha();
		PanelIzquierda();
		
		
		///PARA ANADIR LOS PRODUCTOS AL CARRITO ///
		anadirBoton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TProducto prod  = null; 
				
				if(!id_producto_text.getText().equals("") && ((int)cantidad_producto.getValue()) != 0 && !nombre_producto_text.getText().equals("")){
					
					carrito.setCodigoProducto(Integer.parseInt(id_producto_text.getText()));
					carrito.setUnidades((int)cantidad_producto.getValue());
					// anadido para ver si esta activo en bd 
		
					
							for(TProducto producto : productos){ // para ver si existe 
								if(producto.getCodigo() == carrito.getCodigoProducto()){
									prod = producto;
								}
							}
							
							if(prod != null){ // si existe 
								int unidades = prod.getUnidades() + carrito.getUnidades();
								prod.setUnidades(unidades);
								productos.remove(prod);
								productos.add(prod);
								update(productos);
								
							}
							else{				
								
								
								productos.add(new TProducto(Integer.parseInt(id_producto_text.getText()),
										nombre_producto_text.getText(), (int)cantidad_producto.getValue() ));
								update(productos);
								
								removeBox();
								
							}
							
							
							//SAAbstractFactory.getInstance().createSAFactura().anadirProductosFactura(carrito);
							Controller.getInstance().action(carrito, Evento.ANADIR_PRODUCTOS_FACTURA);
						
				}
				else{
					//Controller.getInstance().action("Debes introducir datos ", Evento.DATOS_INCORRECTOS_FACTURA);
					Controller.getInstance().action(carrito, Evento.ANADIR_PRODUCTOS_FACTURA);
				}
				
			}
			
		});
	
		eliminarBoton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!id_producto_text.getText().equals("") && ((int)cantidad_producto.getValue()) != 0 && !nombre_producto_text.getText().equals("")){
					carrito.setCodigoProducto(Integer.parseInt(id_producto_text.getText()));
					carrito.setUnidades((int)cantidad_producto.getValue());
					
					
					TProducto prod  = null; 

					for(TProducto producto : productos){
						if(producto.getCodigo() == carrito.getCodigoProducto()){
							prod = producto;
						}
					}
					
					if(prod != null ){
						if(prod.getUnidades() > carrito.getUnidades()){			
							int unidades = prod.getUnidades()-carrito.getUnidades();
							prod.setUnidades(unidades);
							productos.remove(prod);
							productos.add(prod);
							
						}else if (prod.getUnidades() == carrito.getUnidades()){
							productos.remove(prod);
						}
					}
					
					//SAAbstractFactory.getInstance().createSAFactura().eliminarProductosFactura(carrito);					
					Controller.getInstance().action(carrito,Evento.ELIMINAR_PRODUCTOS_FACTURA);
					
					update(productos);
					removeBox();
					
				}else {
					//Controller.getInstance().action("Debes introducir datos ", Evento.DATOS_INCORRECTOS_FACTURA);
					Controller.getInstance().action(carrito,Evento.ELIMINAR_PRODUCTOS_FACTURA);
				}
				
				
			}
			
		});
		
		botonOK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().action(carrito,Evento.CERRAR_FACTURA);
				setVisible(false);
			}
			
		});
		
		botonCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Se ha cancelado la operacion de añadir los productos");
				setVisible(false);
				
				
			}
			
		});
	}
	
	public void init() {
		TABLE_MODEL = new AbstractTableModel() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TProducto) productos.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TProducto) productos.get(fila)).getNombre();
					break;
				case 2:
					o = ((TProducto) productos.get(fila)).getUnidades();
					break;
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return productos == null ? 0 : productos.size();
			}
			
			@Override
			public int getColumnCount() {
				
				return columnas.length;
			}
			
			@Override
			public String getColumnName(int column) {
				
				return columnas[column];
			}
		};
		PRODUCTOS_TABLE = new JTable(TABLE_MODEL);
		anchoColumna();
		PRODUCTOS_TABLE.setShowGrid(false);
		PRODUCTOS_TABLE.setIntercellSpacing(new Dimension(0,0));
		PRODUCTOS_TABLE.setVisible(true);
		this.add(new JScrollPane(PRODUCTOS_TABLE,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
	
	public void anchoColumna() {
		PRODUCTOS_TABLE.getColumnModel().getColumn(0).setPreferredWidth(20);
		PRODUCTOS_TABLE.getColumnModel().getColumn(1).setPreferredWidth(20);
		PRODUCTOS_TABLE.getColumnModel().getColumn(2).setPreferredWidth(20);
	}
	

	@SuppressWarnings("unchecked")
	public void update(Object l) {
		
		productos = (List<TProducto>) l;
		TABLE_MODEL.fireTableDataChanged();
	}

	private void removeBox() {
		this.id_producto_text.setText(null);
		this.nombre_producto_text.setText(null);
		
	}
	
	
	
}
