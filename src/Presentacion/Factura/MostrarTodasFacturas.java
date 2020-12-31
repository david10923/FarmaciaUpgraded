package Presentacion.Factura;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Negocio.Factura.TFactura;
import Presentacion.Vista.MostrarTodos;

public class MostrarTodasFacturas extends MostrarTodos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String [] columnas = {"CODIGO","CODIGOTRABAJADOR", "FECHA", "PRECIOTOTAL","ESTADO"};
	private List<Object> facturas;
	AbstractTableModel table;
	
	public MostrarTodasFacturas(String nameId, List<Object> l) {
		super(nameId);
		facturas = l;

		init();
		
	}


	
	public void init() {
		table = new AbstractTableModel() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TFactura) facturas.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TFactura) facturas.get(fila)).getCodigoTrabajador();
					
					break;
				case 2:
					o = ((TFactura) facturas.get(fila)).getFecha();
					break;
				case 3:
					o = ((TFactura) facturas.get(fila)).getPrecioTotal();
					
					break;
				case 4:
					o=((TFactura) facturas.get(fila)).isEstado();
					break;
				
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return facturas == null ? 0 : facturas.size();
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
		super.table.getColumnModel().getColumn(0).setPreferredWidth(60);
		super.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(3).setPreferredWidth(60);
		super.table.getColumnModel().getColumn(4).setPreferredWidth(30);
	}
	

	@SuppressWarnings("unchecked")
	public void update(Object l) {
		
		facturas = (List<Object>) l;
		table.fireTableDataChanged();
	}

}
