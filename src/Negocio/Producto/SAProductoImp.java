package Negocio.Producto;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Laboratorio.TLaboratorio;

public class SAProductoImp implements SAProducto{

	@Override
	public int create(TProducto producto) {
		int codigo=-1;
		
		Transaction t = TransactionManager.getInstance().newTransaction();		
		t.start();
		
		if(producto!=null) {
			
			TLaboratorio laboratorio=DAOAbstractFactory.getInstance().
					createDAOLaboratorio().readById(producto.getCodigoLaboratorio());
			if(laboratorio!=null && laboratorio.isEstado()) {
				
				TProducto productoAux=DAOAbstractFactory.getInstance().
						createDAOProducto().readByNombreYLaboratorio(producto.getNombre(), laboratorio.getCodigo());
				
				if(productoAux==null) {
					codigo=DAOAbstractFactory.getInstance().createDAOProducto().create(producto);
					producto.setCodigo(codigo);
					if(producto.isReceta()){
						DAOAbstractFactory.getInstance().createDAOProducto().createMedicamento((TMedicamento)producto);
					}
					else{
						DAOAbstractFactory.getInstance().createDAOProducto().createParafarmacia((TParafarmacia)producto);
					}
					t.commit();
					
				}
				else if(productoAux!=null&&!productoAux.isEstado())	{
					producto.setCodigo(productoAux.getCodigo());
					int ok = DAOAbstractFactory.getInstance().createDAOProducto().update(producto, true);
					
					if(ok >= 0){
						if(producto.isReceta()){
							ok = DAOAbstractFactory.getInstance().createDAOProducto().createMedicamento(((TMedicamento)producto));
						}else{
							ok = DAOAbstractFactory.getInstance().createDAOProducto().createParafarmacia(((TParafarmacia)producto));
						}
						t.commit();
					
						codigo = 0;
					}
				
				

				}
				
			}
			else t.rollback();
		}
			return codigo;
			
	}

	@Override
	public int delete(int tId) {
		int id = -1;
		Transaction t = TransactionManager.getInstance().newTransaction();		
		t.start();
		
		if(tId!= 0){ 			
			TProducto aux = DAOAbstractFactory.getInstance().createDAOProducto().readById(tId);
			
			if (aux !=null) {
	
				id = DAOAbstractFactory.getInstance().createDAOProducto().delete(aux.getCodigo());
				
				if(id >= 0){
					if(aux.isReceta()) {
						DAOAbstractFactory.getInstance().createDAOProducto().deleteMedicamento(aux.getCodigo());
						t.commit();
					}
					else {
						DAOAbstractFactory.getInstance().createDAOProducto().deleteParafarmacia(aux.getCodigo());
						t.commit();
					}
				}	
			}else {
				t.rollback();
			}
		}
			
		return id;
	}

	@Override
	public int update(TProducto producto) {
		int id = -1;
		Transaction t = TransactionManager.getInstance().newTransaction();		
		t.start();
		
		TProducto aux = DAOAbstractFactory.getInstance().createDAOProducto().readById(producto.getCodigo());
		
		if (aux != null) {
			
			if(producto.getCodigo() == aux.getCodigo()){ 
				producto.setCodigo(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOProducto().update(producto,false);	
				t.commit();
			}else {
				t.rollback();
			}
		}
		
		
			
		return id;
	}

	@Override
	public TProducto read(int id) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();
		TProducto p = DAOAbstractFactory.getInstance().createDAOProducto().readById(id);
		t.commit();
		return p;
	}

	@Override
	public List<TProducto> readAll() {
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();
		List<TProducto> aux =  DAOAbstractFactory.getInstance().createDAOProducto().readAll();
		t.commit();
		
		return aux;
	}
	
	public int bajaTodosProductosLaboratorio(int codigo) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();

		int id = DAOAbstractFactory.getInstance().createDAOProducto().bajaTodosProductosLaboratorio(codigo);
		if(id==-1) {
			t.rollback();
		}else {
			t.commit();
		}
		
		return id;
	}

	@Override
	public int reactivarProductoslaboratorio(int codigo) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();
		int id = DAOAbstractFactory.getInstance().createDAOProducto().reactivarProductoslaboratorio(codigo);
		
		if(id ==-1) {
			t.rollback();
		}else {
			t.commit();
		}
		return id ; 
	}
	
	public List<TProducto> mostrarTodosProductosTrabajador(int codigo) {
		Transaction t=TransactionManager.getInstance().newTransaction();
		t.start();
		List<TProducto> aux=DAOAbstractFactory.getInstance().createDAOProducto().MostrarProductosTrabajador(codigo);
		if(aux==null)t.rollback();
		else t.commit();
		return aux;
	}
	
	

}
