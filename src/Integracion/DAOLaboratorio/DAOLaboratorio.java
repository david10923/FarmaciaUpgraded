package Integracion.DAOLaboratorio;

import java.util.List;

import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;

public interface DAOLaboratorio {
	
	public int create(TLaboratorio tLaboratorio);
	public List<TLaboratorio> readAll();
	public TLaboratorio readById(int id);
	public int update(TLaboratorio tLaboratorio,boolean reactivar);
	public int delete (int codigo);
	public List<TProducto> readProductosLaboratorio(int idLaboratorio);
	public TLaboratorio readByName(String name);

}
