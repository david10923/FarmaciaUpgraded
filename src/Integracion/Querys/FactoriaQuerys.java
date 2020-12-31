package Integracion.Querys;

public abstract class FactoriaQuerys {
	
	
	private static FactoriaQuerys instance;
	
	public static FactoriaQuerys getInstance() {
		if(instance == null) {
			instance = new FactoriaQuerysImp();
		}
		return instance;
	}
	
	public abstract ProductosVendidosPorUnTrabajador crearProductosQueHanSidoVendidosPorCadaTrabajador();
	public abstract TrabajadoresQueHanVendidoCadaProducto crearTrabajadoresQueHanVendidoCadaProducto();
	
}
