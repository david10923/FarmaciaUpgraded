package Integracion.DAOProducto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Producto.TProducto;;


public class TestDAOProducto {
	
	private static TProducto tproducto1 =new TProducto(1,"pextox","para aliviar el dolor",3,4,"lol");
	private static TProducto tproducto2= new TProducto(1, "bilaxten" ,"para el dolor de cabeza" ,3,4,"lol");

	@Test 
	public void create() throws Exception{
		DAOProductoImp dao = new DAOProductoImp();
		
		int out_id = dao.create(tproducto1); 
		//assertNotEquals(-1,out_id);
		assertEquals(6,out_id);
		
		int out_id2 = dao.create(tproducto2); 
	//	assertNotEquals(-1,out_id2);
		assertNotEquals(7,out_id2);
		
	}
	
	@Test
	public void update() throws Exception{
		DAOProductoImp dao = new DAOProductoImp();
		
		int out_idCreado = dao.create(tproducto1);
		tproducto1.setNombre("lolo");
		
		/*int out_idUpdated = dao.update(tproducto2, false); 
		assertEquals(out_idCreado,out_idUpdated);*/
		
	}
	
	@Test
	public void delete(){
		DAOProductoImp dao = new DAOProductoImp();
		
		int id_out = dao.delete(tproducto1.getCodigo());
		int id = tproducto1.getCodigo();
		
		assertEquals(id_out,id);
		
		
	}
	
	@Test
	public void readAll(){
		DAOProductoImp dao = new DAOProductoImp();
		
		ArrayList<TProducto> out_list = new ArrayList<TProducto>();
		ArrayList<TProducto> in_list = new ArrayList<TProducto>();
		
		tproducto1.setEstado(true);
		tproducto2.setEstado(true);
		
		dao.create(tproducto1);
		dao.create(tproducto2); 
		
		out_list = (ArrayList<TProducto>)dao.readAll();
		in_list.add(tproducto1); 
		in_list.add(tproducto2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
  @Test
	public void iguales(TProducto first,  TProducto second){
		assertEquals(first.getNombre(),second.getNombre());
		assertEquals(first.getDescripcion(),second.getDescripcion());
		assertEquals(first.getCodigoLaboratorio(),second.getCodigoLaboratorio());
		assertEquals(first.getCodigo(),second.getCodigo());
		assertEquals(first.getAlergenos(),second.getAlergenos());
		assertEquals(first.isReceta(),second.isReceta());
		
		
	}

	
	

	
	

}
