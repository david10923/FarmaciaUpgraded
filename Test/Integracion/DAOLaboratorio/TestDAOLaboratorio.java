package Integracion.DAOLaboratorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Laboratorio.TLaboratorio;


public class TestDAOLaboratorio {
	
	private static TLaboratorio tLaboratorio1 = new TLaboratorio("Pedro","652014526","calle del mar");
	private static TLaboratorio tLAboratorio2= new TLaboratorio("Juan","320145875","calle del pez");

	@Test 
	public void create() throws Exception{
		DAOLaboratorioImp dao = new DAOLaboratorioImp();
		
		int out_id = dao.create(tLaboratorio1); 
		assertNotEquals(-1,out_id);
		assertEquals(1,out_id);
		
		int out_id2 = dao.create(tLAboratorio2); 
		assertNotEquals(-1,out_id2);
		assertNotEquals(1,out_id2);
		
		
	}
	
	@Test
	public void update() throws Exception{
		DAOLaboratorioImp dao = new DAOLaboratorioImp();
		
		int out_idCreado = dao.create(tLaboratorio1);
		tLaboratorio1.setNombre("Clara");
		
		int out_idUpdated = dao.update(tLAboratorio2, false); 
		assertEquals(out_idCreado,out_idUpdated);
		
	}
	
	@Test
	public void delete(){
		DAOLaboratorioImp dao = new DAOLaboratorioImp();
		
		int id_out = dao.delete(tLaboratorio1.getCodigo());
		int id = tLaboratorio1.getCodigo();
		
		assertEquals(id_out,id);
		
		
	}
	
	@Test
	public void readAll(){
		DAOLaboratorioImp dao = new DAOLaboratorioImp();
		
		ArrayList<TLaboratorio> out_list = new ArrayList<TLaboratorio>();
		ArrayList<TLaboratorio> in_list = new ArrayList<TLaboratorio>();
		
		tLaboratorio1.setEstado(true);
		tLAboratorio2.setEstado(true);
		
		dao.create(tLaboratorio1);
		dao.create(tLAboratorio2); 
		
		out_list = (ArrayList<TLaboratorio>)dao.readAll();
		in_list.add(tLaboratorio1); 
		in_list.add(tLAboratorio2);
		
		for(int i =0 ; i < in_list.size();i++){
			iguales(in_list.get(i), out_list.get(i));
		}		
		
		
	}
	
	public void iguales(TLaboratorio first,  TLaboratorio second){
		assertEquals(first.getNombre(),second.getNombre());
		assertEquals(first.getDireccion(),second.getDireccion());
		assertEquals(first.getTelefono(),second.getTelefono());
		assertEquals(first.getCodigo(),second.getCodigo());
	}

	
	

	
	

}
