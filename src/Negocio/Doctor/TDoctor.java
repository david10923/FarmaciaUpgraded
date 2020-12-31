package Negocio.Doctor;

public class TDoctor {
	
	
	private int codigo; 
	private String dni; 
	private boolean estado; 
	private String telefono;
	private String email; 
	
	
	public TDoctor(String dni, String telefono, String email){
		this.dni= dni ; 
		this.telefono  =telefono ;	
		this.email = email;
	}
	
	
	public TDoctor (String dni, String telefono, String email, int codigo){
		this.dni = dni ; 
		this.telefono = telefono ;
		this.email = email;
		this.codigo = codigo ; 
	}

	public TDoctor (){
		
	}

	
	
	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"DNI: " + dni +  "\n" +
				"Telefono: " + telefono +"\n"+
				"Email: " + email +"\n"+
				"Activo: " + act);		
	}
	
	
	
	
}

