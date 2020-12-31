package Integracion.DAOTrabajador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Trabajador.TTrabajador;


public class TestDAOTrabajador {
	
	
	private static TTrabajador ttrabajador1 = new TTrabajador("12345678P","Pedro","987562412");
	private static TTrabajador ttrabajador2= new TTrabajador("98765432Q","Juan","320145875");

	@Test 
	public void create() throws Exception{
		DAOTrabajadorImp dao = new DAOTrabajadorImp();
		
		int out_id = dao.create(ttrabajador1); 
		assertNotEquals(-1,out_id);
		assertEquals(1,out_id);
		
		int out_id2 = dao.create(ttrabajador2); 
		assertNotEquals(-1,out_id2);
		assertNotEquals(1,out_id2);
		
		
	}
	
	@Test
	public void update() throws Exception{
		DAOTrabajadorImp dao = new DAOTrabajadorImp();
		
		int out_idCreado = dao.create(ttrabajador1);
		ttrabajador1.setNombre("Clara");
		
		int out_idUpdated = dao.update(ttrabajador2, false); 
		assertEquals(out_idCreado,out_idUpdated);
		
	}
	
	@Test
	public void delete(){
		DAOTrabajadorImp dao = new DAOTrabajadorImp();
		
		int id_out = dao.delete(ttrabajador1.getCodigo());
		int id = ttrabajador1.getCodigo();
		
		assertEquals(id_out,id);
		
		
	}
	
	@Test
	public void readAll(){
		DAOTrabajadorImp dao = new DAOTrabajadorImp();
		
		ArrayList<TTrabajador> out_list = new ArrayList<TTrabajador>();
		ArrayList<TTrabajador> in_list = new ArrayList<TTrabajador>();
		
		ttrabajador1.setEstado(true);
		ttrabajador2.setEstado(true);
		
		dao.create(ttrabajador1);
		dao.create(ttrabajador2); 
		
		out_list = (ArrayList<TTrabajador>)dao.readAll();
		in_list.add(ttrabajador1); 
		in_list.add(ttrabajador2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
	public void iguales(TTrabajador first,  TTrabajador second){
		assertEquals(first.getNombre(),second.getNombre());
		assertEquals(first.getDni(),second.getDni());
		assertEquals(first.getTelefono(),second.getTelefono());
		assertEquals(first.getCodigo(),second.getCodigo());
	}

	
	

	
	
	
}
