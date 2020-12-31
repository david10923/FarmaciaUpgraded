package Presentacion.Command;



import Presentacion.Command.*;
import Presentacion.Command.ComandosTrabajador.*;
import Presentacion.Command.ComandosFactura.*;
import Presentacion.Command.ComandosLaboratorio.*;
import Presentacion.Command.ComandosProducto.*;

import Presentacion.Controller.Evento;

public class CommandFactoryImp  extends CommandFactory{

	@Override
	public Command getCommand(Integer commandName) {
		Command c = null;
		
		switch (commandName) {		
		case Evento.ALTA_TRABAJADOR: {
			c = new ComandoAltaTrabajador();			
			break;
		}
		case Evento.BAJA_TRABAJADOR: {

			c = new ComandoBajaTrabajador();
			
			break;
		}
		case Evento.MODIFICAR_TRABAJADOR: {

			c = new ComandoModificarTrabajador();	
			break;

		}
		case Evento.MOSTRAR_TRABAJADOR: {
			
			c = new ComandosMostrarUnTrabajador();	
			break;
		}
		case Evento.MOSTRAR_TODOS_TRABAJADORES: {
			c = new ComandoMostrarTodosTrabajadores();	
			break;
		}
		case Evento.ALTA_LABORATORIO: {
			c = new ComandoAltaLaboratorio();	
			break;
		}
		case Evento.BAJA_LABORATORIO: {
			c = new ComandoBajaLaboratorio();	
			

			break;
		}
		case Evento.MODIFICAR_LABORATORIO: {

			c = new ComandoModificarLaboratorio();	

			break;

		}
		case Evento.MOSTRAR_LABORATORIO: {
			c = new ComandoMostrarUnLaboratorio();	
			
			break;

		}
		case Evento.MOSTRAR_TODOS_LABORATORIOS: {
			c = new ComandoMostrarTodosLaboratorios();	
			break;
		}

		case Evento.MOSTRAR_TODOS_PRODUCTOS_LABORATORIO:
			c = new ComandoMostrarTodosProductosLaboratorio();
			
			break;
		
		case Evento.ALTA_PRODUCTO: {
			c = new ComandoAltaProducto();	
			break;
		}
		case Evento.BAJA_PRODUCTO: {
			c = new ComandoBajaProducto();	
			

			break;
		}
		case Evento.MODIFICAR_PRODUCTO: {

			c = new ComandoModificarProducto();	

			break;

		}
		case Evento.MOSTRAR_PRODUCTO: {
			c = new ComandosMostrarUnProducto();	
			
			break;

		}
		case Evento.MOSTRAR_TODOS_PRODUCTOS: {
			c = new ComandoMostrarTodosProductos();	
			break;
		}
		
		case Evento.CREAR_FACTURA: {
			c = new ComandoAltaFactura();	

			break;
		}
		case Evento.CERRAR_FACTURA:{
			c = new ComandoCerrarFactura();	
			break;
		}
		
		case Evento.BAJA_FACTURA: {
			c = new ComandoBajaFactura();	
			
			break;
		}
		case Evento.MODIFICAR_FACTURA: {			
			c = new ComandoModificarFactura();	
			

			break;

		}
		case Evento.MOSTRAR_FACTURA: {
			c = new ComandoMostrarUnaFactura();	
			
			break;
		

		}
		case Evento.MOSTRAR_TODOS_PRODUCTOS_FACTURA:{ 
			
			c = new ComandoMostrarTodosProductosFactura();
			
			break;
		}
		case Evento.MOSTRAR_TODOS_FACTURAS: {
			
			c = new ComandoMostrarTodasFacturas();	
			
			break;
		}
		case Evento.RELLENAR_CONTIENES: {
			c = new ComandoRellenarContienes();
			
			break;
		}
		case Evento.ANADIR_PRODUCTOS_FACTURA:{
			c = new ComandoAñadirProductosFactura();
			break;
		}
		case Evento.ELIMINAR_PRODUCTOS_FACTURA:{
			c = new ComandoEliminarProductosFactura();
			break;
		}
		case Evento.MOSTRAR_PRODUCTOS_TRABAJADOR:{
			c = new ComandoMostrarProductosVendidosTrabajador();
			
			break;
		}
		case Evento.MOSTRAR_TRABAJADORES_PRODUCTO: {
			c = new ComandoMostrarTodosTrabajadoresProducto();
			
			break;
		}
		case Evento.PEDIR_CODIGO_FACTURA:{
			c = new ComandoMostrarUnaFacturaPorId();
			break;
		}
		
			
	}
		return c;

	}
}
