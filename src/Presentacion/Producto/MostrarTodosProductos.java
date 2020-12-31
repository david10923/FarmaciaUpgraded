package Presentacion.Producto;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Negocio.Producto.TProducto;
import Presentacion.Vista.MostrarTodos;

@SuppressWarnings("serial")
public class MostrarTodosProductos extends MostrarTodos{

	private String [] columnas = {"CODIGO", "COD_LAB", "NOMBRE", "UNIDADES", "DESCRIPCION"
			, "PRECIO", "ESTADO", "RECETA", "ALERGENOS"};
	private List<Object> productos;
	AbstractTableModel table;
	
	public MostrarTodosProductos(String nameId, List<Object> l) {
		super(nameId);
		
		productos = l;
		
		init();
		
	}


	
	public void init() {
		table = new AbstractTableModel() {
			
			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TProducto) productos.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TProducto) productos.get(fila)).getCodigoLaboratorio();
					break;
				case 2:
					o = ((TProducto) productos.get(fila)).getNombre();
					break;
				case 3:
					o = ((TProducto) productos.get(fila)).getUnidades();
					break;
				case 4:
					o = ((TProducto) productos.get(fila)).getDescripcion();
					break;
				case 5:
					o = ((TProducto) productos.get(fila)).getPrecio();
					break;
				case 6:
					o = ((TProducto) productos.get(fila)).isEstado();
					break;
				case 7:
					o = ((TProducto) productos.get(fila)).isReceta();
					break;
				case 8:
					o = ((TProducto) productos.get(fila)).getAlergenos();
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
		super.table = new JTable(table);
		anchoColumna();
		super.table.setShowGrid(false);
		super.table.setIntercellSpacing(new Dimension(0,0));
		super.table.setVisible(true);
		this.add(new JScrollPane(super.table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	}
	
	public void anchoColumna() {
		super.table.getColumnModel().getColumn(0).setPreferredWidth(20);
		super.table.getColumnModel().getColumn(1).setPreferredWidth(50);
		super.table.getColumnModel().getColumn(2).setPreferredWidth(50);
		super.table.getColumnModel().getColumn(3).setPreferredWidth(50);
		super.table.getColumnModel().getColumn(4).setPreferredWidth(30);
		super.table.getColumnModel().getColumn(5).setPreferredWidth(30);
		super.table.getColumnModel().getColumn(6).setPreferredWidth(30);
		super.table.getColumnModel().getColumn(7).setPreferredWidth(30);
		super.table.getColumnModel().getColumn(8).setPreferredWidth(30);
	}
	

	public void update(Object l) {
		
		productos = (List<Object>) l;
		table.fireTableDataChanged();
		
	}
	
	

}
