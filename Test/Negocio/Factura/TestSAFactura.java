package Negocio.Factura;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Integracion.DAO.DAOAbstractFactory;
import Negocio.Laboratorio.SALaboratorio;
import Negocio.Laboratorio.TLaboratorio;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;
import Negocio.Trabajador.TTrabajador;

public class TestSAFactura {


	private static TFactura tfactura1= new TFactura(1,1);
	private static TFactura tfactura2 = new TFactura(2,2);
	
	
	private static TCarrito carrito1 = new TCarrito ();
	private static TCarrito carrito2 = new TCarrito ();
	
	
	private static TContiene contiene1  =new TContiene();
	private static TContiene contiene2 = new TContiene();
	
	private SAFactura sa = SAAbstractFactory.getInstance().createSAFactura();
	
	
	@Test
	public void testCreateFactura(){	// TERMINADO 
		// los contienes se crean en el cerrar factura
		carrito1.settFactura(tfactura1);
		
		for(int i = 0; i< 3 ; i++){ // le meto tres productos al carrito 
			carrito1.setUnidades(i);// le meto i unidades 
			carrito1.setCodigoProducto(i); //el coddigo del prodducto es i 
			carrito1 = sa.anadirProductosFactura(carrito1);
		}
		
		assertEquals(1,sa.cerrarFactura(carrito1)); // espero el 1 de la bd 
		assertNotEquals(2,sa.cerrarFactura(carrito1));
		
		/// segunda factura
		carrito2.settFactura(tfactura2);
		
		for(int i = 0; i< 3 ; i++){ // le meto tres productos al carrito 
			carrito2.setUnidades(i);// le meto i unidades 
			carrito2.setCodigoProducto(i); //el coddigo del prodducto es i 
			carrito2 = sa.anadirProductosFactura(carrito2);
		}
		
		assertEquals(1,sa.cerrarFactura(carrito2)); // espero el 1 de la bd 
		assertNotEquals(2,sa.cerrarFactura(carrito2));
		
		
		
	}
	
	@Test
	public void testDeleteFacturaOk(){// TERMINADO 
		
		assertEquals(1,sa.delete(tfactura1.getCodigo()));	
		assertEquals(2,sa.delete(tfactura1.getCodigo()));
		assertNotEquals(1,sa.delete(-1));
		 // si intento dar de baja dos veces una factura
		
		
		assertEquals(1,sa.delete(tfactura1.getCodigo()));
		assertEquals(2,sa.delete(tfactura2.getCodigo()));
		
		
		// las vuelvo a crear 
			
		testCreateFactura();
		
	}
	
	
	@Test
	public void testUpdateFActura(){
		
		List<TContiene> contienes = new ArrayList<TContiene>();
		contienes  = DAOAbstractFactory.getInstance().createDAOContiene().readById(tfactura1.getCodigo());
				
		
		for(TContiene contiene : contienes){
			if(contiene.getCodigoProducto() == 1){ // le voy a modificar unidades del primer producto 
				contiene1 = contiene;
			}
		}
		TProducto producto  = DAOAbstractFactory.getInstance().createDAOProducto().readById(1);
		
		contiene1.setPrecio(producto.getPrecio());
		contiene1.setCantidad(1); // le voy a quitar uno al producto con id = 1
		
		// he actualizado la lista de t contienes 
	
		contienes.remove(contiene1); 
		contienes.add(contiene1);
		
		// obtienes el id de la factura que has modificado 	
		assertEquals(1,sa.update(contienes));
		
	}
	
	
	
	@Test
	public void testReadFactura(){
		
		tfactura2.setEstado(true);
		assertEquals(tfactura2.toString() ,sa.readByCodigo(tfactura2.getCodigo()));
		
		assertNotEquals(tfactura2.toString(),sa.readByCodigo(tfactura1.getCodigo()));
		
	}
	
	@Test
	public void testReadAll(){
		List<TFactura> lista = new ArrayList<TFactura>();
		
		lista.add(tfactura1); 
		lista.add(tfactura2); 
		
		assertEquals(lista,sa.readAll());
		lista.remove(0); 
		assertNotEquals(lista,sa.readAll());
		
	}
	
	
	@Test 
	public void readFacturaConProductos(){
		
		
		
	}
	
}
