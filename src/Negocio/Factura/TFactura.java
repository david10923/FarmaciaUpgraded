package Negocio.Factura;

public class TFactura {
	
	private int codigo ; 
	private double precioTotal; 
	private String fecha; 
	private boolean estado ;
	private int codigoTrabajador;
	
	
	
	public TFactura(){
		
	}
	
	public TFactura(int codigo , int precioTotal, String fecha,boolean estado, int codigoTrabajador){
		this.codigo= codigo;
		this.precioTotal = precioTotal; 
		this.fecha = fecha ; 
		this.estado = estado; 
		this.codigoTrabajador = codigoTrabajador;	
	}
	
	public TFactura(int codigoTrabajador){		 
		this.codigoTrabajador = codigoTrabajador;	
	}
	
	public TFactura(int codigo,int codigoTrabajador){
		this.codigo = codigo;	 
		this.codigoTrabajador = codigoTrabajador;	
	}
	
	
	
	public String toString(){//// habria que mostrar todos los productos asociados a la factura para ello habria que utilizar la factua con productos 
		String act = estado ? "Si" : "No";	
		
		return ("Codigo: " + codigo + "\n" + 
				"PrecioTotal: " + precioTotal + "\n" +
				"Fecha: " + fecha +  "\n" +
				"CodigoTrabajador: "+ codigoTrabajador + "\n" +
				"Activo: " + act);
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCodigoTrabajador() {
		return codigoTrabajador;
	}

	public void setCodigoTrabajador(int codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}

}
