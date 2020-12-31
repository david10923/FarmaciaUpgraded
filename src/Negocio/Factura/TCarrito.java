package Negocio.Factura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TCarrito {
	
	private int codigoProducto; 
	private int unidades; 	
	private Map<Integer,TContiene> mapa = new HashMap<Integer,TContiene>();	
	private TFactura tFactura;
	
	
	
	public TCarrito() {
		
		tFactura = new TFactura();
		
	}
	
	public TCarrito(int codigoProducto,int unidades){
		this.unidades = unidades; 
		this.codigoProducto = codigoProducto;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public int getUnidades() {
		return unidades;
	}


	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}


	public TFactura gettFactura() {
		return tFactura;
	}


	public void settFactura(TFactura tFactura) {
		this.tFactura = tFactura;
	}

	public Map<Integer,TContiene> getMapa() {
		return mapa;
	}

	public void setMapa(Map<Integer,TContiene> mapa) {
		this.mapa = mapa;
	}
	
	public void setCodigoFactura(int codigo) {
		this.tFactura.setCodigo(codigo);
	}
	
}
