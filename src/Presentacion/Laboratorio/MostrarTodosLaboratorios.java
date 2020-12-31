package Presentacion.Laboratorio;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Negocio.Laboratorio.TLaboratorio;
import Presentacion.Vista.MostrarTodos;

@SuppressWarnings("serial")
public class MostrarTodosLaboratorios extends MostrarTodos {
	

	private String [] columnas = {"CODIGO", "NOMBRE","TELEFONO", "DIRECCION", "ESTADO"};
	private List<Object> laboratorios;
	AbstractTableModel table;
	
	public MostrarTodosLaboratorios(String nameId, List<Object> l) {
		super(nameId);
		laboratorios = l;
		
		init();
		
	}
	
	public void init() {
		table = new AbstractTableModel() {

			@Override
			public Object getValueAt(int fila, int columna) {
				Object o = null;
				
				switch (columna) {
				case 0:
					o = ((TLaboratorio) laboratorios.get(fila)).getCodigo();
					break;
				case 1:
					o = ((TLaboratorio) laboratorios.get(fila)).getNombre();
					break;
				case 2:
					o = ((TLaboratorio) laboratorios.get(fila)).getTelefono();
					break;
				case 3:
					o = ((TLaboratorio) laboratorios.get(fila)).getDireccion();
					break;
				case 4:
					o = ((TLaboratorio) laboratorios.get(fila)).isEstado();
					break;
				
				}
				return o;
			}
			
			@Override
			public int getRowCount() {
				
				return laboratorios == null ? 0 : laboratorios.size();
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
		super.table.getColumnModel().getColumn(1).setPreferredWidth(60);
		super.table.getColumnModel().getColumn(2).setPreferredWidth(60);
		super.table.getColumnModel().getColumn(3).setPreferredWidth(60);
		super.table.getColumnModel().getColumn(4).setPreferredWidth(50);
	}
	

	@Override
	public void update(Object l) {
		laboratorios = (List<Object>) l;
		table.fireTableDataChanged();
		
	}
	
	

}
