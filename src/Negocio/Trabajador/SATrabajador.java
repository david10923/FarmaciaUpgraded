package Negocio.Trabajador;

import java.util.List;

import Negocio.Producto.TProducto;

public interface SATrabajador {	

	public int create (TTrabajador tTrabajador);
	public TTrabajador read(String nif);
	public List<TTrabajador> readAll();
	public int update(TTrabajador tTrabajador);
	public int delete(String dni);
	public TTrabajador readById(int id);
	public List<TTrabajador> mostrarTodosTrabajadoresProducto(int codigo);
}
