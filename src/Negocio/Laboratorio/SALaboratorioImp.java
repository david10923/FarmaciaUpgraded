package Negocio.Laboratorio;

import java.util.List;

import Presentacion.Controller.Controller;
import Presentacion.Controller.Evento;
import Integracion.DAO.DAOAbstractFactory;
import Integracion.Transaction.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Producto.TProducto;
import Negocio.SA.SAAbstractFactory;


public class SALaboratorioImp implements SALaboratorio {

	@Override
	public int create(TLaboratorio tLaboratorio) {		
		int id = -1, ok = 0; 
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		if(tLaboratorio!= null){		
			t.start();
			
			TLaboratorio aux =DAOAbstractFactory.getInstance().createDAOLaboratorio().readByName(tLaboratorio.getNombre());		
			
			
			if (aux ==null) {
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().create(tLaboratorio);
				
				if(id != -1) t.commit();
				else t.rollback();
				
			}else if (aux !=null && !aux.isEstado()) {
				ok = DAOAbstractFactory.getInstance().createDAOLaboratorio().update(aux,true);				
				id = SAAbstractFactory.getInstance().createSAProducto().reactivarProductoslaboratorio(ok);
				
				if(id!=-1) {
					id=0;
					t.commit();
				}else t.rollback();
					
			}	
			
		
	
		}
		
		
		return id;
	}


	@Override
	public List<TLaboratorio> readAll() {
		List<TLaboratorio> aux = null;
		
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		t.start();
		
		aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readAll();
		
		t.commit();
		
		return aux;
	}

	@Override
	public int update(TLaboratorio laboratorio) {
		int id = -1;
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		
		TLaboratorio aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(laboratorio.getCodigo());
		
		if (aux != null && aux.isEstado()) {
			
			if(laboratorio.getCodigo() == aux.getCodigo()){ 

				laboratorio.setCodigo(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().update(laboratorio,false);	
				t.commit();
			}
		}
		else t.rollback();
			
		return id;
	}

	@Override
	public int delete(int tId) {
		
		int ok = -1, id = -1;
		Transaction t = TransactionManager.getInstance().newTransaction();
		
		if(tId!= 0){		
			t.start();
			
			TLaboratorio aux =DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(tId);
			
			List<TProducto> lista = DAOAbstractFactory.getInstance().createDAOLaboratorio().readProductosLaboratorio(tId);
			
			if (aux !=null && !lista.isEmpty()) {
				//hay que comprobar si hay productos
				ok = DAOAbstractFactory.getInstance().createDAOProducto().bajaTodosProductosLaboratorio(aux.getCodigo());
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().delete(aux.getCodigo());
				
				if(ok != -1 && id != -1) t.commit();
				else t.rollback();
				
			}
			else {
				id = DAOAbstractFactory.getInstance().createDAOLaboratorio().delete(aux.getCodigo());
				if(id != -1) t.commit();
				else t.rollback();
			}
		}
				
		
		return id;
	}

	@Override
	public TLaboratorio readByName(String name) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TLaboratorio aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readByName(name);
		if(aux == null) t.rollback();
		else t.commit();
		return aux;
	}
	
	
	public String readProductosLaboratorio(int idLaboratorio){
		
	
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		List<TProducto> aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readProductosLaboratorio(idLaboratorio);
		StringBuilder sb = new StringBuilder();
		if(aux != null) {
			for (TProducto nuevo : aux) {
				sb.append(nuevo.toAlterString());
			}
			t.commit();
		}else t.rollback();
		
		return sb.toString();	
	}


	@Override
	public TLaboratorio readById(int id) {
		Transaction t = TransactionManager.getInstance().newTransaction();
		t.start();
		TLaboratorio aux = DAOAbstractFactory.getInstance().createDAOLaboratorio().readById(id);
		if(aux == null) t.rollback();
		else t.commit();
		return aux;
	}	

}
