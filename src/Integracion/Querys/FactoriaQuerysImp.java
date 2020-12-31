package Integracion.Querys;

public class FactoriaQuerysImp  extends FactoriaQuerys{

	public ProductosVendidosPorUnTrabajador crearProductosQueHanSidoVendidosPorCadaTrabajador(){
		return new ProductosVendidosPorUnTrabajador();
	}
	public TrabajadoresQueHanVendidoCadaProducto crearTrabajadoresQueHanVendidoCadaProducto(){
		return new TrabajadoresQueHanVendidoCadaProducto();
	}

}
