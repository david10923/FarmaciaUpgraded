package Negocio.Producto;

public class TMedicamento extends TProducto {

	public TMedicamento(Integer codigo, String nombre, String descripcion, Integer unidades,
			double precio, boolean receta) {
		super(codigo, nombre, descripcion, unidades, precio, receta);
		// TODO Auto-generated constructor stub
	}
	
	public TMedicamento( String nombre ,Integer codigo  , String descripcion , Integer unidades, double precio , boolean receta){
		super(nombre,descripcion , unidades,precio ,codigo, receta);
	}

}
