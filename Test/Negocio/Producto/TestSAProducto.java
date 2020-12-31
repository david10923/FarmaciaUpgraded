package Negocio.Producto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import Negocio.SA.SAAbstractFactory;;


public class TestSAProducto {
	
	private static TProducto tproducto2= new TParafarmacia	(1,"frenadol","para aliviar el dolor",3,4,"lol");
	private static TProducto tproducto1= new TMedicamento(1, "paracetamol" ,"para el dolor de cabeza" ,3,4,true);
	private SAProducto sa = SAAbstractFactory.getInstance().createSAProducto();
	
	
	@Test
	public void testCreateProductoOk(){
		tproducto1.setEstado(true);
		assertEquals(5,sa.create(tproducto2)); // espero el 2 de la bd 
	}
	
	@Test
	public void testCreateProductoFail(){
		
		//c = new TProducto(2, "paracetamol" ,"para el dolor de cabeza" ,3,4,"lol");
		assertNotEquals(5,sa.create(tproducto2));
		
		tproducto2.setCodigoLaboratorio(0);
		assertNotEquals(1,sa.create(tproducto2));
		
		//c = new TProducto(1, "paracetamol" ,"para el dolor de cabeza" ,3,4,"lol");//habria q cambiarlo pq las unidades nos deja q sea 0
		tproducto2.setUnidades(0);
		assertNotEquals(6,sa.create(tproducto2));
		
		//assertNotEquals(1, sa.create(tproducto1));
	}
	
	@Test
	public void testDeleteProductoOk(){
		//existe y esta activo 
		assertEquals(1,sa.delete(1));	//devolveria 
		
	}
	
	@Test
	public void testDeleteProductoFailed(){
		// si no existe 
		assertNotEquals(11,sa.delete(11));
		// existe y no esta activo 
		assertNotEquals(1,sa.delete(1));
		// le pasas mal los datos 
		//assertNotEquals(1,sa.delete(null));
	}
	
	
	@Test
	public void testUpdateProductoOk(){
		//cliente existe y activo y validez 
		tproducto1.setUnidades(2);
		tproducto1.setCodigo(1);
		//c.setEstado(false);
		assertEquals(1,sa.update(tproducto1));
	}
	
	@Test
	public void testUpdateProductoFail(){
		TProducto c = tproducto2;
		c.setEstado(false);
		c.setCodigo(20);
		 
		//producto incorrecto 
		//assertEquals(1 ,sa.update(null));
		/// no es el cliente indicado 
		assertNotEquals(5,sa.update(c));
		
		/*//invalidez Sintactica
		c.setNombre("");
		assertEquals(5,sa.update(c));
		
		c.setNombre("JUANNNNN");
		assertEquals(5,sa.update(c));*/
	}
	
	
	@Test
	public void testReadProductoOk(){
		TProducto c = tproducto1;
		c.setCodigo(1);
		c.setEstado(false);
		assertEquals(c.toString() ,(sa.read(c.getCodigo()).toString()));
	}
	@Test
	public void testReadProductoFailed(){
		TProducto c = tproducto1;
		c.setCodigo(2);
		c.setEstado(true);
		//assertNotEquals(c ,(sa.read(c.())));
		assertNotEquals(c ,sa.read(0));
	}
	
}
