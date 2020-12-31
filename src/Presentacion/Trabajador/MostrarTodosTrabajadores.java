package Presentacion.Trabajador;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Negocio.Trabajador.TTrabajador;
import Presentacion.Vista.MostrarTodos;

@SuppressWarnings("serial")
public class MostrarTodosTrabajadores extends MostrarTodos {
	

	private String [] columnas = {"CODIGO", "DNI", "TELEFONO", "NOMBRE", "ESTADO"};
	private List<Object> trabajadores;
	AbstractTableModel table;
	
	public MostrarTodosTrabajadores(String nameId, List<Object> l) {
		super(nameId);
		trabajadores = l;
		
		init();
		
	}
	
	public void init() {
		table = new AbstractTableModel() {

			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TTrabajador) trabajadores.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TTrabajador) trabajadores.get(fila)).getDni();
					break;
				case 2:
					o = ((TTrabajador) trabajadores.get(fila)).getTelefono();
					break;
				case 3:
					o = ((TTrabajador) trabajadores.get(fila)).getNombre();
					break;
				case 4:
					o = ((TTrabajador) trabajadores.get(fila)).isEstado();
					break;
				
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return trabajadores == null ? 0 : trabajadores.size();
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
		super.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(3).setPreferredWidth(100);
		super.table.getColumnModel().getColumn(4).setPreferredWidth(30);
	}
	

	@Override
	public void update(Object l) {
		trabajadores = (List<Object>) l;
		table.fireTableDataChanged();
		
	}
	
	

}
