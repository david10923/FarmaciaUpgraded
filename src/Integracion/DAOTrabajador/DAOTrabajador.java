package Integracion.DAOTrabajador;

import java.util.List;

import Negocio.Producto.TProducto;
import Negocio.Trabajador.TTrabajador;

public interface DAOTrabajador {
	
	public int create(TTrabajador tUsuario);
	public TTrabajador read(String nif);
	public List<TTrabajador> readAll();
	public TTrabajador readByDNI(String DNI);
	public int update(TTrabajador tUsuario,boolean reactivar);
	public int delete (int codigo);
	public TTrabajador readById(int id);
	public List<TTrabajador> mostrarTrabajadoresProducto(int codigo);

}
