package Negocio.Trabajador;

import Negocio.SA.*;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;

import org.junit.*;



public class TestSATrabajador {
	
	private SATrabajador sa = SAAbstractFactory.getInstance().createSATrabajador();
	
	
	@Test
	public void testCreateTrabajadorOk(){
		TTrabajador tt = new TTrabajador("56932456P", "David", "657894523");
		tt.setEstado(true);
		assertEquals(5, sa.create(tt)); // espero el 3 de la bd 
	}
	
	@Test
	public void testCreateTrabajadorFail(){
		TTrabajador t = new TTrabajador();
		assertNotEquals(1, sa.create(t));
		
		/*
		t = new TTrabajador("","25695482P","657894523");
		assertNotEquals(1,sa.create(t));*/
		
		t = new TTrabajador("David",null,"657894523");
		assertNotEquals(1,sa.create(t));
		
		t = new TTrabajador("David","25695482P","6562321");
		assertNotEquals(1,sa.create(t));
		
		assertNotEquals(1, sa.create(t));
	}
	@Test
	public void testDeleteEmployeeOk(){
		//existe y esta activo 
		assertEquals(2,sa.delete("56932456P"));	
		
	}
	
	@Test
	public void testDeleteTrabajadorFailed(){
		// si no existe 
		assertNotEquals(1,sa.delete("11111111A"));
		// existe y no esta activo 
		assertNotEquals(1,sa.delete("54695245P"));
		// le pasas mal los datos 
		assertNotEquals(1,sa.delete(null));
	}
	
	
	@Test
	public void testUpdateTrabajadorOk(){
		//empleado existe y activo y validez 
		TTrabajador tt = new TTrabajador("56932456P", "David", "657894523");
		tt.setEstado(false);
		assertEquals(2,sa.update(tt));
	}
	
	@Test
	public void testUpdateTrabajadorFail(){
		TTrabajador tt = new TTrabajador("56932456P", "David", "657894523");
		tt.setEstado(false);
		tt.setCodigo(20);
		 
		
		//empleado incorrecto
		
		assertEquals(-1 ,sa.update(null));
		/// no es el empleado indicado 
		assertEquals(2,sa.update(tt));
		
		//invalidez Sintactica
		tt.setNombre("");
		assertEquals(2,sa.update(tt));
		
		tt.setNombre("JUANNNNN");
		assertEquals(2,sa.update(tt));
	}
	
	@Test
	public void testReadTrabajadorOk(){
		TTrabajador tt = new TTrabajador("12345678P", "Pedro", "987562412");
		tt.setCodigo(3);
		tt.setEstado(true);
		assertEquals(tt.toString(),(sa.readById(tt.getCodigo()).toString()));
		
	}
	
	public void testReadTrabajadorFailed(){
		TTrabajador tt = new TTrabajador("56932456P", "Ss", "657894523");
		tt.setCodigo(3);
		tt.setEstado(true);
		assertNotEquals(tt ,(sa.read(tt.getDni())));
		assertNotEquals(tt ,sa.read(null));
	}
	
	
	

}
