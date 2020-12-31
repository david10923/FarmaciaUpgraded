package Negocio.Trabajador;

public class TTrabajador {
	
	
	private int codigo; 
	private String dni; 
	private boolean estado; 
	private String nombre; 
	private String telefono; 
	
	
	public TTrabajador(String dni, String nombre, String telefono){
		this.dni= dni ; 
		this.nombre= nombre ; 
		this.telefono  =telefono ;		
	}
	
	
	public TTrabajador (String dni, String nombre , String telefono, int codigo){
		this.dni = dni ; 
		this.nombre = nombre ; 
		this.telefono = telefono ; 
		this.codigo = codigo ; 
	}

	public TTrabajador (){
		
	}
    public TTrabajador (String dni){
    	this.dni = dni ; 
	}
	
	
	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"Nombre: " + nombre + "\n" +
				"DNI: " + dni +  "\n" +
				"Telefono: " + telefono +"\n"+
				"Activo: " + act);		
	}
	
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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
