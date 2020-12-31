package Presentacion.Factura;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Negocio.Factura.TContiene;
import Negocio.SA.SAAbstractFactory;



public class VentanaModificarProductosFactura extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo;
	
	private JPanel tablePanel;
	private JPanel addDeletePanel;
	private JPanel mainPanel;
	
	
	private JLabel id_producto_label;
	private JTextField id_producto_text;	
	
	
	
	private JLabel cantidad_producto_label;
	private JSpinner cantidad_producto;	
	
	private JButton eliminarBoton;
	private JButton botonOK;
	private JButton botonCancelar;
	
	private JTable PRODUCTOS_TABLE;
	AbstractTableModel TABLE_MODEL;
	private String [] columnas = { "C_FACTURA" , "C_PRODUCTO" ,"CANTIDAD", "PVP"};
	
	
	private static List<TContiene> contienes;
	
	///// ???????? NO SE SI ESTARA BIEN 
	
	
	
	/*COMENTARIOS 
	 * 1.-He añadido el carrito como atributo de la ventana para poder añadir los productos al carrito pero no se si estara bien 
	 * 2.-Falta meter el precio del producto 
	 * 
	 * 
	 */
	//private TCarrito carrito ; 
	
	//private TContiene facturaContiene;
	
	public VentanaModificarProductosFactura(int codigo) {
		this.codigo = codigo;
		this.setTitle("Modificar Productos Factura");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		this.setContentPane(mainPanel);
		inicializaVentana();
		this.setBounds(250,100,700,600);
		this.setVisible(true);
		

	}
	
	private void PanelDerecha (){
		addDeletePanel          = new JPanel();
		addDeletePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	
		addDeletePanel.setLayout(new BoxLayout(addDeletePanel,BoxLayout.Y_AXIS));
		
		id_producto_label       = new JLabel("Codigo Producto:");
		id_producto_text        = new JTextField(10);

		cantidad_producto_label = new JLabel("Cantidad:");
		
		this.cantidad_producto = new JSpinner(new SpinnerNumberModel(0,0,20000,1));
		
		this.cantidad_producto.setMaximumSize(new Dimension(60,40));
		
		

		eliminarBoton = new JButton("DELETE");
		
		
		addDeletePanel.add(id_producto_label);
		addDeletePanel.add(id_producto_text);
		this.id_producto_text.setMaximumSize(new Dimension(200,100));

		addDeletePanel.add(cantidad_producto_label);
		addDeletePanel.add(cantidad_producto);
		addDeletePanel.add(Box.createRigidArea(new Dimension(100,10)));

			
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
		
		
		//contienes = Controller.getInstance().action(data, event);
		//contienes = SAAbstractFactory.getInstance().createSAFactura().readContieneDeFactura(codigo);
		Controller.getInstance().action(codigo, Evento.RELLENAR_CONTIENES);
		update(contienes);
		
		
	
		eliminarBoton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int unidadesQuitadas=0;
				
				TContiene cont  = null; 
				
				if(!id_producto_text.getText().equals("") && ((int)cantidad_producto.getValue()) != 0 ){
					

					for(TContiene contiene : contienes){
						if(contiene.getCodigoProducto() == Integer.parseInt(id_producto_text.getText())){
							cont = contiene;
						}
					}
					
					if(cont != null){
						
						if(cont.getCantidad() >= (int)cantidad_producto.getValue()){	
							double precioUnidad = cont.getPrecio() / cont.getCantidad();
							unidadesQuitadas = (int)cantidad_producto.getValue();
							int unidades = cont.getCantidad()-(int)cantidad_producto.getValue();
							cont.setPrecio(precioUnidad*unidades);
							cont.setCantidad(unidades);
							contienes.remove(cont);
							contienes.add(cont);
							
						}
					}	
					update(contienes);
					removeBox();
				}
							
				
			}
			
		});
		
		botonOK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(contienes.size()==0){
					Controller.getInstance().action("No se ha modificado la factura", Evento.DATOS_INCORRECTOS_FACTURA);
				}else{
				
					Controller.getInstance().action(contienes, Evento.MODIFICAR_FACTURA);
				}
				
				
				
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
			
			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TContiene) contienes.get(fila)).getCodigoFactura();
					break;
				case 1:
					o = ((TContiene) contienes.get(fila)).getCodigoProducto();
					break;
				case 2:
					o = ((TContiene) contienes.get(fila)).getCantidad();
					break;
				case 3:
					o = ((TContiene) contienes.get(fila)).getPrecio();
					break;
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return contienes == null ? 0 : contienes.size();
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
	

	public void update(Object l) {
		
		contienes = (List<TContiene>) l;
		TABLE_MODEL.fireTableDataChanged();
	}

	private void removeBox() {
		this.id_producto_text.setText(null);
		
	}
	
	public static void setContienes(List<TContiene> data) {
		contienes = data;
	}
}
