package Negocio.Hospital;

public class THospital {
	
	
	private int codigo; 
	private boolean estado; 
	private String nombre; 
	private String direccion; 
	
	
	public THospital(String nombre, String direccion){ 
		this.nombre= nombre ; 
		this.direccion  =direccion ;		
	}
	
	
	public THospital ( String nombre ,String direccion, String telefono, int codigo){
		this.nombre = nombre ; 
		this.direccion = direccion ; 
		this.codigo = codigo ; 
	}

	public THospital (){
		
	}

	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"Nombre: " + nombre + "\n" +
				"Direccion: " + direccion +  "\n" +
				"Activo: " + act);		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}
