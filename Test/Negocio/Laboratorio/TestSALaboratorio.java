package Negocio.Laboratorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Negocio.Producto.SAProducto;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;

public class TestSALaboratorio {
	
	private static TLaboratorio tlaboratorio1= new TLaboratorio("lab1","123456789","calle lab1");
	private static TLaboratorio tlaboratorio2= new TLaboratorio("lab2","987654321", "calle lab2");
	private SALaboratorio sa = SAAbstractFactory.getInstance().createSALaboratorio();
	
	
	@Test
	public void testCreateLAboratorioOk(){	
		
		assertEquals(27,sa.create(tlaboratorio1)); // espero el 2 de la bd 
	}
	
	@Test
	public void testCreateLaboratorioFail(){
		
		assertNotEquals(27, sa.create(tlaboratorio1));
		assertNotEquals(1,tlaboratorio2);
		assertNotEquals(1,tlaboratorio2);
		assertNotEquals(1, sa.create(tlaboratorio1));
	}
	
	@Test
	public void testDeleteLaboratorioOk(){
		//existe y esta activo 
		assertEquals(1,sa.delete(1));	
		
	}
	
	@Test
	public void testDeleteLaboratorioFailed(){
		// si no existe 
		assertNotEquals(55,sa.delete(55));
		// existe y no esta activo 
		assertEquals(11,sa.delete(11));
	
	}
	
	
	@Test
	public void testUpdateLaboratorioOk(){
		//cliente existe y activo y validez 
		tlaboratorio1.setEstado(false);
		//assertEquals(3,sa.update(tlaboratorio1,false));
	}
	
	@Test
	public void testUpdateLaboratorioFail(){
		tlaboratorio2.setEstado(false);
		/*
		 
		//producto incorrecto 
		//assertEquals(1 ,sa.update(null));
		/// no es el cliente indicado 
		assertEquals(3,sa.update(c));
		
		//invalidez Sintactica
		c.setNombre("");
		assertEquals(3,sa.update(c));
		
		c.setNombre("JUANNNNN");
		assertEquals(3,sa.update(c));
		*/
	}
	
	
	@Test
	public void testReadLaboratorioOk(){
		TLaboratorio c = tlaboratorio1;
		c.setCodigo(1);
		c.setEstado(true);
		assertEquals(c.toString() ,(sa.readByName(c.getNombre()).toString()));
	}
	@Test
	public void testReadLaboratorioFailed(){
		TLaboratorio c = tlaboratorio1;
		
		tlaboratorio1.setCodigo(2);
		tlaboratorio1.setEstado(true);
		//assertNotEquals(c ,(sa.read(c.())));
		assertNotEquals(c ,sa.readById(0));
	}
	
}

