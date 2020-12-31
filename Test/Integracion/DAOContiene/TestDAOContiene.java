package Integracion.DAOContiene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Factura.TCarrito;
import Negocio.Factura.TContiene;
import Negocio.Factura.TFactura;
import Negocio.Producto.TProducto;


public class TestDAOContiene {
	
	private static TContiene tContiene1 = new TContiene(1,1);
	private static TContiene tContiene2= new TContiene(2,2);
	
	private static TProducto producto1= new TProducto("Ibuprofeno", "Pastillas",50,5.0,1,true);
	private static TProducto producto2= new TProducto("Vendas", "Curan",50,7,1,"irritacion piel");
	
	@Test 
	public void create() throws Exception{
		DAOContieneImp dao = new DAOContieneImp();

	
		
		int out_contiene = dao.create(producto1, 1, 5); 
		
		assertNotEquals(-1,out_contiene);
		assertEquals(1,out_contiene);
		
		
	}
	
	@Test
	public void update() throws Exception{
		DAOContieneImp dao = new DAOContieneImp();
		
		
		tContiene1.setPrecio(6);
		tContiene1.setCantidad(50);
		
		int out_idUpdated = dao.update(tContiene1);
		assertNotEquals(-1,out_idUpdated);
		assertEquals(1,out_idUpdated);
		
	}
	
	@Test
	public void delete(){
		DAOContieneImp dao = new DAOContieneImp();
		
		int id_out = dao.delete(tContiene1);
		
		assertEquals(5,id_out);
		assertNotEquals(-1,id_out);
		
	}
	
	@Test
	public void readAll(){
		DAOContieneImp dao = new DAOContieneImp();
		
		ArrayList<TContiene> out_list = new ArrayList<TContiene>();
		ArrayList<TContiene> in_list = new ArrayList<TContiene>();
		
		
		out_list = (ArrayList<TContiene>)dao.readAll();
		in_list.add(tContiene1); 
		in_list.add(tContiene2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
	public void iguales(TContiene first,  TContiene second){
		assertEquals(first.getCantidad(),second.getCantidad());
		assertEquals(first.getCodigoFactura(),second.getCodigoFactura());
		assertEquals(first.getCodigoProducto(),second.getCodigoProducto());

	}

	
	

	
	

}
