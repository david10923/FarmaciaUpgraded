package Negocio.Factura;

public class TContiene {
	
	private int codigoProducto; 
	private int codigoFactura; 
	private double precio; 
	private int cantidad;
	
	
	public TContiene(int codigoProducto,int codigoFactura){
		this.codigoProducto = codigoProducto;
		this.codigoFactura= codigoFactura;
	}
	
	
	public TContiene(){
		
	}
	public TContiene(int codigoProducto){
		this.codigoProducto = codigoProducto;
	}
	


	public int getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public int getCodigoFactura() {
		return codigoFactura;
	}


	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
