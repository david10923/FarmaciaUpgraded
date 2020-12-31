package Integracion.DAO;


import Integracion.DAOContiene.DAOContiene;
import Integracion.DAOFactura.DAOFactura;
import Integracion.DAOLaboratorio.DAOLaboratorio;
import Integracion.DAOProducto.DAOProducto;
import Integracion.DAOTrabajador.DAOTrabajador;

public abstract class DAOAbstractFactory {

	private static DAOAbstractFactory instance;
	
	public static DAOAbstractFactory getInstance() {
		if (instance ==null) {
			instance = new DAOAbstractFactoryImp();
		}
		return instance;
	}
	
	
	
	public abstract DAOTrabajador createDAOTrabajador();	
	public abstract DAOProducto createDAOProducto();
	public abstract DAOFactura createDAOFactura();
	public abstract DAOLaboratorio createDAOLaboratorio();
	public abstract DAOContiene createDAOContiene();
	
}
