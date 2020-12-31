package Negocio.Trabajador;

import java.util.List;

import Integracion.DAO.DAOAbstractFactory;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Producto.TProducto;

public class SATrabajadorImp implements SATrabajador {

	@Override
	public int create(TTrabajador trabajador) {		
		int id = -1, ok = -1;
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		
		
		if(trabajador!= null){			
			t.start();
			TTrabajador aux =DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(trabajador.getDni());
			
			if (aux ==null) {
				id = DAOAbstractFactory.getInstance().createDAOTrabajador().create(trabajador);
				t.commit();
				
			}else if (aux !=null && !aux.isEstado()) {
				ok = DAOAbstractFactory.getInstance().createDAOTrabajador().update(aux,true);
				
				if(ok >= 0) id = 0;
				t.commit();
			}else {
				t.rollback();
			}
		}	
		
		return id;
	}

	@Override
	public TTrabajador read(String nif) {
		
		return null; 
	}

	@Override
	public List<TTrabajador> readAll() {
		List<TTrabajador> aux = null;
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();		
		
		aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readAll();
		
		t.commit();
		
		return aux;
	}

	@Override
	public int update(TTrabajador trabajador) {
		int id = -1;

		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		
		TTrabajador aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(trabajador.getDni());
		
		if(trabajador.getDni().equals(aux.getDni())){ 
			trabajador.setCodigo(aux.getCodigo());
			id = DAOAbstractFactory.getInstance().createDAOTrabajador().update(trabajador,false);	
			t.commit();
		}
		else t.rollback();
			
		return id;
	}

	@Override
	public int delete(String dni) {
		int id = -1;
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		if(dni!= null){ 	
			t.start();
			TTrabajador aux = DAOAbstractFactory.getInstance().createDAOTrabajador().readByDNI(dni);
			
			if (aux !=null) 	{				
				id = DAOAbstractFactory.getInstance().createDAOTrabajador().delete(aux.getCodigo());
				if(id == -1) t.rollback();		
				else 		 t.commit();
			}
		}	
		return id;
	}

	@Override
	public TTrabajador readById(int id) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TTrabajador aux=DAOAbstractFactory.getInstance().createDAOTrabajador().readById(id);
		if(aux==null)t.rollback();
		else t.commit();
		return aux;
	}

	public List<TTrabajador> mostrarTodosTrabajadoresProducto(int codigo){
		Transaction t=TransactionManager.getInstance().newTransaction();
		t.start();
		List<TTrabajador> aux=DAOAbstractFactory.getInstance().createDAOTrabajador().mostrarTrabajadoresProducto(codigo);
		if(aux==null)t.rollback();
		else t.commit();
		return aux;
	}
	
	
	

}
