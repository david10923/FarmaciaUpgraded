package Integracion.DAOFactura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TFactura;


public class TestDAOFactura {
	
	private static TFactura tFactura1 = new TFactura(1,1);
	private static TFactura tFactura2= new TFactura(2,2);
	
	private static TCarrito tCarrito = new TCarrito();
	
	@Test 
	public void create() throws Exception{
		DAOFacturaImp dao = new DAOFacturaImp();

		tCarrito.settFactura(tFactura1);
		
		TCarrito out_carrito = dao.create(tCarrito); 
		assertNotEquals(-1,out_carrito);
		assertEquals(6,out_carrito.gettFactura().getCodigo());
		
		
	}
	
	@Test
	public void update() throws Exception{
		DAOFacturaImp dao = new DAOFacturaImp();
		
		
		tFactura1.setEstado(true);
		tFactura1.setPrecioTotal(45);
		
		int out_idUpdated = dao.update(tFactura1);
		assertNotEquals(-1,out_idUpdated);
		assertEquals(1,out_idUpdated);
		
	}
	
	@Test
	public void delete(){
		DAOFacturaImp dao = new DAOFacturaImp();
		
		int id_out = dao.delete(tFactura1.getCodigo());
		int id = tFactura1.getCodigo();
		
		assertEquals(id_out,id);
		
		
	}
	
	@Test
	public void readAll(){
		DAOFacturaImp dao = new DAOFacturaImp();
		
		ArrayList<TFactura> out_list = new ArrayList<TFactura>();
		ArrayList<TFactura> in_list = new ArrayList<TFactura>();
		
		tFactura1.setEstado(true);
		tFactura2.setEstado(true);

		
		out_list = (ArrayList<TFactura>)dao.readAll();
		in_list.add(tFactura1); 
		in_list.add(tFactura2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
	public void iguales(TFactura first,  TFactura second){
		assertEquals(first.getCodigo(),second.getCodigo());
		assertEquals(first.getCodigoTrabajador(),second.getCodigoTrabajador());
		assertEquals(first.getFecha(),second.getFecha());

	}

	
	

	
	

}
