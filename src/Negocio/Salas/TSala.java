package Negocio.Salas;


public class TSala {
	
	
	private int codigo; 
	private String aforo; 
	private boolean estado; 
	private String nombre; 
	private String planta; 
	
	
	public TSala(String nombre, String planta,String aforo){
		this.aforo= aforo ; 
		this.nombre= nombre ; 
		this.planta  =planta ;		
	}
	
	
	public TSala (String aforo, String nombre , String planta, int codigo){
		this.aforo = aforo ; 
		this.nombre = nombre ; 
		this.planta = planta ; 
		this.codigo = codigo ; 
	}

	public TSala (){
		
	}
	
	
	
	public String toString() {
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"Nombre: " + nombre + "\n" +
				"Planta: " + planta +  "\n" +
				"Aforo: " + aforo +"\n"+
				"Activo: " + act);		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getAforo() {
		return aforo;
	}


	public void setAforo(String aforo) {
		this.aforo = aforo;
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


	public String getPlanta() {
		return planta;
	}


	public void setPlanta(String planta) {
		this.planta = planta;
	}
	
	

	
	
}

