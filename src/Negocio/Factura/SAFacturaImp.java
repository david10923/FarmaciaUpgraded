package Negocio.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Integracion.DAO.DAOAbstractFactory;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Producto.TProducto;
import Negocio.Trabajador.TTrabajador;

public class SAFacturaImp implements SAFactura {

	@Override
	public TCarrito create(TFactura factura) {
		if(factura!= null){		
			TCarrito carrito = new TCarrito();
			carrito.settFactura(factura);
		
			return carrito;
		}
		return null ; 
	}
	

	@Override
	public TCarrito read(int codigo) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TCarrito c = DAOAbstractFactory.getInstance().createDAOFactura().read(codigo);
		t.commit();
		return c;
		
	}

	public TFactura readByCodigo(int codigo) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TFactura f = DAOAbstractFactory.getInstance().createDAOFactura().readByCodigo(codigo);
		t.commit();
		return f;
	}
	
	@Override
	public List<TFactura> readAll() {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		List<TFactura> l = DAOAbstractFactory.getInstance().createDAOFactura().readAll();
		t.commit();
		return l;
	}

	public int update(List<TContiene> contienes) {
		
		int id=-1, cantidadQuitada=0;
		double precioTotal=0;
		TProducto tp;
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
	
		List<TContiene> contList = DAOAbstractFactory.getInstance().createDAOContiene().readAll();
		
		if (contienes != null) {
			
		
			for (int j=0; j<contList.size(); j++) {
				
				for (int i= 0; i < contienes.size(); i++) {
					if (contList.get(j).getCodigoProducto() == contienes.get(i).getCodigoProducto() &&
							contList.get(j).getCodigoFactura() == contienes.get(i).getCodigoFactura()) {
						
						cantidadQuitada = contList.get(j).getCantidad() - contienes.get(i).getCantidad();
						
						if (contienes.get(i).getCantidad()>0) {
							DAOAbstractFactory.getInstance().createDAOContiene().update(contienes.get(i));
							precioTotal = contienes.get(i).getPrecio() + precioTotal;
	
						}else {
							DAOAbstractFactory.getInstance().createDAOContiene().delete(contienes.get(i));
						}
						
						tp = DAOAbstractFactory.getInstance().createDAOProducto().readById(contienes.get(i).getCodigoProducto());
						
					
						tp.setUnidades(tp.getUnidades()+cantidadQuitada);
						
						DAOAbstractFactory.getInstance().createDAOProducto().update(tp, false);
			
						
					}
					
					
				}
			}
			
			
			
			TFactura aux = new TFactura();
			aux.setCodigo(contienes.get(0).getCodigoFactura());
			aux.setPrecioTotal(precioTotal);
			if (aux.getPrecioTotal() > 0) {
				id = DAOAbstractFactory.getInstance().createDAOFactura().update(aux);
			}else {
				DAOAbstractFactory.getInstance().createDAOFactura().update(aux);
				id = DAOAbstractFactory.getInstance().createDAOFactura().delete(aux.getCodigo());
			}
			
			t.commit();
		}else t.rollback();
		return id;
	}
	
	

	@Override
	public int delete(int tId) {
		
		int id = -1;
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		if(tId != -1){ 			
			TFactura aux = DAOAbstractFactory.getInstance().createDAOFactura().readByCodigo(tId);
			
			if (aux !=null) {
				id = DAOAbstractFactory.getInstance().createDAOFactura().delete(aux.getCodigo());
				t.commit();
			}
			
		}else t.rollback();
			
		return id;
		
	}

	
	
	
	@Override
	public TFacturaConProductos readFacturaConProductos(int codigo) {	
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		
		
		
		List<TProducto> listAux = new ArrayList<TProducto>();		
		
		TFacturaConProductos aux = new TFacturaConProductos();
		
		TCarrito carrito = (TCarrito) DAOAbstractFactory.getInstance().
				createDAOFactura().read(codigo);
		
		aux.settContiene(DAOAbstractFactory.getInstance()
				.createDAOContiene().readById(carrito.gettFactura().getCodigo()));
		
		aux.settFactura(carrito.gettFactura());
		
		listAux = DAOAbstractFactory.getInstance().createDAOProducto().readAll();
		
		for (int i=0; i<listAux.size();i++) {
			
			for (int j=0; j<aux.gettContiene().size();j++) {
				
				if (listAux.get(i).getCodigo() == aux.gettContiene().get(j).getCodigoProducto()) {
					listAux.get(i).setUnidades(aux.gettContiene().get(j).getCantidad());
					aux.gettProducto().add(listAux.get(i));
				}
			}
			
		}		
		
		aux.settTrabajador(DAOAbstractFactory.getInstance().createDAOTrabajador().readById(carrito.gettFactura().getCodigoTrabajador()));
		
		
		if(carrito.equals(null)) {
			t.commit();
		}
		else t.rollback();
		
		
		
		return aux;
	}

	@Override
	public TCarrito anadirProductosFactura(TCarrito carrito) {
		TContiene contiene; 
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TProducto aux = DAOAbstractFactory.getInstance().createDAOProducto().readById(carrito.getCodigoProducto());
		
		if (aux != null && aux.isEstado()) {
			if(carrito.getMapa().size()>0){	
				
				if(carrito.getMapa().containsKey(carrito.getCodigoProducto())){ // si ya contiene la clave 
					 contiene = carrito.getMapa().get(carrito.getCodigoProducto()); // coges el tContiene y aumentas su cantidad 
					 contiene.setCantidad(contiene.getCantidad() + carrito.getUnidades());
					
				}else{			
					contiene = new TContiene(carrito.getCodigoProducto());//carrito.gettFactura().getCodigo());
					contiene.setCantidad(carrito.getUnidades());
				
				}
			}
			else{
				contiene = new TContiene(carrito.getCodigoProducto());
				contiene.setCantidad(carrito.getUnidades());
			}
			
			carrito.getMapa().put(carrito.getCodigoProducto(), contiene);
			t.commit();
		}else t.rollback();
		
		
		
		return carrito;
	}

	@Override
	public TCarrito eliminarProductosFactura(TCarrito carrito) {		
		TContiene contiene; 
		
		if(carrito.getMapa().size()>0){
			
			if(carrito.getMapa().containsKey(carrito.getCodigoProducto())){ 
				
				 contiene = carrito.getMapa().get(carrito.getCodigoProducto());				 
				 if(carrito.getUnidades()> contiene.getCantidad()){ // no se puede eliminar el producto 
					 return null;
				 }else{
					 contiene.setCantidad(contiene.getCantidad() - carrito.getUnidades());
					 carrito.getMapa().put(carrito.getCodigoProducto(), contiene);					
					 
				 }
				
			}
		}		
		
		return carrito;
		
		
	}

	@Override
	public int cerrarFactura(TCarrito carrito) {
		int id = -1, ok=0;
		double precioTotal = 0;
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
	
		if(carrito != null && carrito.getMapa().size() > 0){
			
			TTrabajador trabajador = DAOAbstractFactory.getInstance().createDAOTrabajador().readById(carrito.gettFactura().getCodigoTrabajador());				
		
			
			if(trabajador != null && trabajador.isEstado()){ // si existen y estan activos 
				
				
				carrito.gettFactura().setCodigo(DAOAbstractFactory.getInstance().createDAOFactura().create(carrito).gettFactura().getCodigo()); 
				
				id = carrito.gettFactura().getCodigo();
				
				if(id > 0) {
					
					for(Map.Entry<Integer, TContiene> contiene : carrito.getMapa().entrySet()){
						
						int idProducto = contiene.getValue().getCodigoProducto(); 
						TProducto producto  = DAOAbstractFactory.getInstance().createDAOProducto().readById(idProducto);
						int cantidadAnadida = contiene.getValue().getCantidad();
						if(producto!= null){
							
							boolean activo = producto.isEstado(); 
							int num = producto.getUnidades();
							
							if(activo && num >= contiene.getValue().getCantidad()){							
								precioTotal += cantidadAnadida * producto.getPrecio();
								DAOAbstractFactory.getInstance().createDAOContiene().create(producto, id, cantidadAnadida);
								int unidades = producto.getUnidades() - cantidadAnadida; 
								producto.setUnidades(unidades);
								DAOAbstractFactory.getInstance().createDAOProducto().update(producto,false);
							}
						
						}
					}
					
					if (precioTotal > 0) {
						carrito.gettFactura().setPrecioTotal(precioTotal);
						DAOAbstractFactory.getInstance().createDAOFactura().update(carrito.gettFactura());						
					}
				}
			}
		}
		
		if(id != -1) t.commit();
		else t.rollback();
		
		return id;
	}

	public List<TContiene> readContieneDeFactura(int codigo){
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		List<TContiene> aux = DAOAbstractFactory.getInstance().createDAOContiene().readById(codigo);
		t.commit();
		return aux;
		
	}
	
}
