package Negocio.Producto;

public class TParafarmacia extends TProducto{

	public TParafarmacia(Integer codigo, String nombre, String descripcion, Integer unidades,
			double precio, String alergenos) {
		super(codigo, nombre, descripcion, unidades, precio, alergenos);

	}
	
	
	public TParafarmacia(String nombre,Integer codigo ,String descripcion, Integer unidades,
			double precio, String alergenos) {
		super(nombre, descripcion, unidades, precio, codigo, alergenos);

	}

}
