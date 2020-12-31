package Negocio.Producto;

public class TProducto {

	private int codigo; 
	private int codigoLaboratorio;
	private String nombre;
	private String descripcion;
	private int unidades; 
	private double precio;
	private boolean estado;
	private boolean receta;
	private String alergenos;

	public TProducto(Integer codigo,Integer codigoLab, String nombre, 
			 Integer unidades,String descripcion, double precio,boolean estado,boolean receta, String alergenos) {
		this.codigo = codigo;
		this.codigoLaboratorio = codigoLab;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.precio = precio;
		this.receta = receta;
		this.estado = estado;
		this.alergenos = alergenos;
		
	}
	
	public TProducto(Integer codigo, String nombre,Integer unidades) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.unidades = unidades;
	}
	
	public TProducto(Integer codigo, Integer unidades) {
		this.codigo = codigo;
		this.unidades = unidades;
	}
	public TProducto( String nombre) {
		this.nombre=nombre;
		
	}
	///opara modificar el producto
	
	public TProducto (String nombre , String descripcion, Integer unidades ,double precio,Integer codigo, boolean receta){
		this.codigo = codigo; 
		this.descripcion = descripcion; 
		this.nombre = nombre; 
		this.unidades = unidades ; 
		this.precio = precio ; 
		this.receta = receta;
		
	}
	
	// para modicar producto
	public TProducto (String nombre , String descripcion, Integer unidades ,double precio,Integer codigo, String  alergenos){
		this.codigo = codigo; 
		this.descripcion = descripcion; 
		this.nombre = nombre; 
		this.unidades = unidades ; 
		this.precio = precio ; 
		this.alergenos = alergenos;		
	}
	
	
	
	public TProducto(Integer codigo,String nombre, 
			String descripcion, Integer unidades, double precio, boolean receta) {
		
		this.codigoLaboratorio = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.precio = precio;
		this.receta = receta;
		
	}
	
	
	public TProducto(Integer codigoLab, String nombre, 
			String descripcion, Integer unidades, double precio, String alergenos) {
		this.codigoLaboratorio = codigoLab;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.precio = precio;
		this.alergenos = alergenos;
		
	}
	

	
	
	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("- " +"CodigoProducto: "+ this.codigo + "\n" + 
				"- " +"CodigoLaboratorio: " + this.codigoLaboratorio + "\n" +
				"- " +"Nombre: " + this.nombre +  "\n" +
				"- " +"Unidades: " + this.unidades +  "\n" +
				"- " +"Descripcion: " + this.descripcion +  "\n" +
				"- " +"Precio: " + this.precio +  "\n" +
				"- " +"RecetaMedicamento: " + this.receta +  "\n" +
				"- " +"AlergenosParafarmacia: " + this.alergenos +  "\n" +
				"- " +"Activo: " + act);
		
	}
	
	public String toAlterString() {
		String act = estado ? "Si" : "No";	
		
		return ("	PRODUCTO : "+"\n"+ "C_Producto:  " + this.codigo + "  -  " + 
				"C_Laboratorio: " + this.codigoLaboratorio + "  -  " +
				"Nombre: " + this.nombre +  "  -  "  +
				"Unidades: " + this.unidades +  "  -  " +
				"Descripcion: " + this.descripcion +  "\n" +
				"Precio: " + this.precio +  "  -  " +
				"RecetaMedicamento: " + this.receta +  "  -  " +
				"AlergenosParafarmacia: " + this.alergenos +  "  -  " +
				"Activo: " + act + "\n" + "----------------------" + "\n");
		
	}
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoLaboratorio() {
		return codigoLaboratorio;
	}

	public void setCodigoLaboratorio(Integer codigoLaboratorio) {
		this.codigoLaboratorio = codigoLaboratorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isReceta() {
		return receta;
	}

	public void setReceta(boolean receta) {
		this.receta = receta;
	}

	public String getAlergenos() {
		return alergenos;
	}

	public void setAlergenos(String alergenos) {
		this.alergenos = alergenos;
	}
	
	
	
	
	
	
	
}
