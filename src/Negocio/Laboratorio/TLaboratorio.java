package Negocio.Laboratorio;

public class TLaboratorio {
	
	
	private int codigo; 
	private String direccion; 
	private boolean estado; 
	private String nombre; 
	private String telefono;
	
	
	public TLaboratorio( String nombre, String telefono, String direccion){
		this.nombre= nombre;
		this.telefono=telefono;
		this.direccion= direccion ; 
	}
	
	public TLaboratorio (int codigo, String nombre , String telefono , String direccion){
		this.codigo = codigo; 
		this.nombre = nombre ;
		this.telefono = telefono;
		this.direccion= direccion;
	
	}
	

	public TLaboratorio (){
		
	}
	
	
	
	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"Nombre: " + nombre + "\n" +
				"Direccion: " + direccion +  "\n" +
				"Telefono: " + telefono +"\n"+
				"Activo: " + act);		
	}
	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	
	
}


