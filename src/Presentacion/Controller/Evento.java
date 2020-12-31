package Presentacion.Controller;

public class Evento {
	
	
	
	//////////////////////////////////////////////////////////////////////////
	public static final int ALTA_TRABAJADOR= 100; 
	public static final int BAJA_TRABAJADOR= 101; 
	public static final int MODIFICAR_TRABAJADOR = 102;
	public static final int MOSTRAR_TRABAJADOR = 103; 
	public static final int MOSTRAR_TODOS_TRABAJADORES = 104; 
	public static final int RES_ALTA_TRABAJADOR_OK =105; 
	public static final int RES_ALTA_TRABAJADOR_FAILED= -105;
	public static final int RES_BAJA_TRABAJADOR_OK=106;
	public static final int RES_BAJA_TRABAJADOR_FAILED = -106;
	public static final int RES_MODIFICAR_TRABAJADOR_OK = 107;
	public static final int RES_MODIFICAR_TRABAJADOR_FAILED= -107;
	public static final int RES_MOSTRAR_TRABAJADOR_OK=108;
	public static final int	RES_MOSTRAR_TRABAJADOR_FAILED =-108;
	public static final int RES_MOSTRAR_TODOS_TRABAJADORES_OK=109;
	public static final int	RES_MOSTRAR_TODOS_TRABAJADORES_FAILED =-109;
	public static final int RES_REACTIVAR_TRABAJADOR_OK = 110;
	public static final int DATOS_INCORRECTOS_TRABAJADOR = 120;
	public static final int MOSTRAR_PRODUCTOS_TRABAJADOR=121;
	public static final int RES_MOSTRAR_PRODUCTOS_TRABAJADOR_OK=122;
	public static final int RES_MOSTRAR_PRODUCTOS_TRABAJADOR_FAILED=-122;


	/////////////////////////////////////////////////////////////////////////
	public static final int ALTA_LABORATORIO= 200; 
	public static final int BAJA_LABORATORIO= 201; 
	public static final int MODIFICAR_LABORATORIO = 202;
	public static final int MOSTRAR_LABORATORIO = 203; 
	public static final int MOSTRAR_TODOS_LABORATORIOS = 204; 
	public static final int RES_ALTA_LABORATORIO_OK =205; 
	public static final int RES_ALTA_LABORATORIO_FAILED= -205;
	public static final int RES_BAJA_LABORATORIO_OK=206;
	public static final int RES_BAJA_LABORATORIO_FAILED = -206;
	public static final int RES_MODIFICAR_LABORATORIO_OK = 207;
	public static final int RES_MODIFICAR_LABORATORIO_FAILED= -207;
	public static final int RES_MOSTRAR_LABORATORIO_OK=208;
	public static final int	RES_MOSTRAR_LABORATORIO_FAILED =-208;
	public static final int RES_MOSTRAR_TODOS_LABORATORIOS_OK=209;
	public static final int	RES_MOSTRAR_TODOS_LABORATORIOS_FAILED =-209;
	public static final int RES_REACTIVAR_LABORATORIO_OK = 210;
	public static final int MOSTRAR_TODOS_PRODUCTOS_LABORATORIO = 211;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_OK = 212;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_LABORATORIO_FAIL = 213;
	public static final int DATOS_INCORRECTOS_LABORATORIO = 220;
	public static final int REACTIVAR_PRODUCTOS_LABORATORIO = 214;
	public static final int RES_REACTIVAR_PRODUCTOS_LABORATORIO_OK =215;
	public static final int RES_REACTIVAR_PRODUCTOS_LABORATORIO_FAIL = 216;
	/////////////////////////////////////////////////////////////////////////
	public static final int ALTA_PRODUCTO= 300; 
	public static final int BAJA_PRODUCTO= 301; 
	public static final int MODIFICAR_PRODUCTO = 302;
	public static final int MOSTRAR_PRODUCTO = 303; 
	public static final int MOSTRAR_TODOS_PRODUCTOS = 304; 
	public static final int BAJA_PRODUCTOS_POR_LABORATORIO = 311;
	public static final int RES_BAJA_PRODUCTOS_POR_LABORATORIO_OK = 312;
	public static final int RES_BAJA_PRODUCTOS_POR_LABORATORIO_FAIL = 313;


	public static final int RES_ALTA_PRODUCTO_OK =305; 
	public static final int RES_ALTA_PRODUCTO_FAILED= -305;
	public static final int RES_BAJA_PRODUCTO_OK=306;
	public static final int RES_BAJA_PRODUCTO_FAILED = -306;
	public static final int RES_MODIFICAR_PRODUCTO_OK = 307;
	public static final int RES_MODIFICAR_PRODUCTO_FAILED= -307;
	public static final int RES_MOSTRAR_PRODUCTO_OK=308;
	public static final int	RES_MOSTRAR_PRODUCTO_FAILED =-308;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_OK=309;
	public static final int	RES_MOSTRAR_TODOS_PRODUCTOS_FAILED =-309;
	public static final int RES_REACTIVAR_PRODUCTO_OK = 310;
	public static final int DATOS_INCORRECTOS_PRODUCTO = 320;
	public static final int MOSTRAR_TRABAJADORES_PRODUCTO = 321;
	public static final int RES_MOSTRAR_TRABAJADORES_PRODUCTO_OK = 322;
	public static final int RES_MOSTRAR_TRABAJADORES_PRODUCTO_FAILED = -322;
	/////////////////////////////////////////////////////////////////////////
	public static final int CREAR_FACTURA= 400; 
	public static final int BAJA_FACTURA= 401; 
	public static final int MODIFICAR_FACTURA = 402;
	public static final int MOSTRAR_FACTURA = 403; 
	public static final int MOSTRAR_TODOS_FACTURAS = 404; 
	public static final int RES_ALTA_FACTURA_OK =405; 
	public static final int RES_ALTA_FACTURA_FAILED= -405;
	public static final int RES_BAJA_FACTURA_OK=406;
	public static final int RES_BAJA_FACTURA_FAILED = -406;
	public static final int RES_MODIFICAR_FACTURA_OK = 407;
	public static final int RES_MODIFICAR_FACTURA_FAILED= -407;
	public static final int RES_MOSTRAR_FACTURA_OK=408;
	public static final int	RES_MOSTRAR_FACTURA_FAILED =-408;
	public static final int RES_MOSTRAR_TODOS_FACTURAS_OK=409;
	public static final int	RES_MOSTRAR_TODOS_FACTURAS_FAILED =-409;
	public static final int RES_REACTIVAR_FACTURA_OK = 410;
	
	public static final int MOSTRAR_TODOS_PRODUCTOS_FACTURA= 414;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_OK = 415;
	public static final int RES_MOSTRAR_TODOS_PRODUCTOS_FACTURA_FAILED = -410;
	public static final int DATOS_INCORRECTOS_FACTURA = 420;
	public static final int RELLENAR_CONTIENES = 426;
	public static final int RES_RELLENAR_CONTIENES_FAILED = -427;
	public static final int RES_RELLENAR_CONTIENES_OK = 427;
	
	
	public static final int DATOS_PRODUCTOS_ANNADIDOS_CORRECTOS= 423;
	public static final int DATOS_PRODUCTOS_ANADIDOS_INCORRECTOS= -423;
	public static final int DATOS_PRODUCTOS_ELIMINADOS_CORRECTOS=424;
	public static final int DATOS_PRODUCTOS_ELIMINADOS_INCORRECTOS=-424;
	public static final int ACTUALIZAR_TODOS= 425;
	
	
	
	public static final int ANADIR_PRODUCTOS_FACTURA = 411;
	public static final int ELIMINAR_PRODUCTOS_FACTURA = 412;
	public static final int CERRAR_FACTURA = 413;
	public static final int RES_CERRAR_FACTURA_OK = 421;
	public static final int RES_CERRAR_FACTURA_FAIL =422;
	public static final int RES_PEDIR_CODIGO_FACTURA_OK = 450;
	public static final int RES_PEDIR_CODIGO_FACTURA_FAILED = -450;
	public static final int RES_PEDIR_CODIGO_FACTURA_INEXISTENTE = -451;
	public static final int PEDIR_CODIGO_FACTURA = 451;
	
	
//////////////////////////////////////////////////////////////////////////
public static final int ALTA_SALA= 500; 
public static final int BAJA_SALA= 501; 
public static final int MODIFICAR_SALA = 502;
public static final int MOSTRAR_SALA = 503; 
public static final int MOSTRAR_TODAS_SALAS = 504; 
public static final int RES_ALTA_SALA_OK =505; 
public static final int RES_ALTA_SALA_FAILED= -505;
public static final int RES_BAJA_SALA_OK=506;
public static final int RES_BAJA_SALA_FAILED = -506;
public static final int RES_MODIFICAR_SALA_OK = 507;
public static final int RES_MODIFICAR_SALA_FAILED= -507;
public static final int RES_MOSTRAR_SALA_OK=508;
public static final int	RES_MOSTRAR_SALA_FAILED =-508;
public static final int RES_MOSTRAR_TODAS_SALAS_OK=509;
public static final int	RES_MOSTRAR_TODAS_SALAS_FAILED =-509;
public static final int RES_REACTIVAR_SALA_OK = 510;
public static final int DATOS_INCORRECTOS_SALA = 520;
//////////////////////////////////////////////////////////////////////////
public static final int ALTA_DOCTOR= 600; 
public static final int BAJA_DOCTOR= 601; 
public static final int MODIFICAR_DOCTOR = 602;
public static final int MOSTRAR_DOCTOR = 603; 
public static final int MOSTRAR_TODOS_DOCTORES = 604; 
public static final int RES_ALTA_DOCTOR_OK =605; 
public static final int RES_ALTA_DOCTOR_FAILED= -605;
public static final int RES_BAJA_DOCTOR_OK=606;
public static final int RES_BAJA_DOCTOR_FAILED = -606;
public static final int RES_MODIFICAR_DOCTOR_OK = 607;
public static final int RES_MODIFICAR_DOCTOR_FAILED= -607;
public static final int RES_MOSTRAR_DOCTOR_OK=608;
public static final int	RES_MOSTRAR_DOCTOR_FAILED =-608;
public static final int RES_MOSTRAR_TODOS_DOCTORES_OK=609;
public static final int	RES_MOSTRAR_TODOS_DOCTORES_FAILED =-609;
public static final int RES_REACTIVAR_DOCTOR_OK = 610;
public static final int DATOS_INCORRECTOS_DOCTOR = 620;
//////////////////////////////////////////////////////////////////////////
public static final int ALTA_HOSPITAL= 700; 
public static final int BAJA_HOSPITAL= 701; 
public static final int MODIFICAR_HOSPITAL = 702;
public static final int MOSTRAR_HOSPITAL = 703; 
public static final int MOSTRAR_TODOS_HOSPITALES = 704; 
public static final int RES_ALTA_HOSPITAL_OK =705; 
public static final int RES_ALTA_HOSPITAL_FAILED= -705;
public static final int RES_BAJA_HOSPITAL_OK=706;
public static final int RES_BAJA_HOSPITAL_FAILED = -706;
public static final int RES_MODIFICAR_HOSPITAL_OK = 707;
public static final int RES_MODIFICAR_HOSPITAL_FAILED= -707;
public static final int RES_MOSTRAR_HOSPITAL_OK=708;
public static final int	RES_MOSTRAR_HOSPITAL_FAILED =-708;
public static final int RES_MOSTRAR_TODOS_HOSPITALES_OK=709;
public static final int	RES_MOSTRAR_TODOS_HOSPITALES_FAILED =-709;
public static final int RES_REACTIVAR_HOSPITAL_OK = 710;
public static final int DATOS_INCORRECTOS_HOSPITAL = 720;
//////////////////////////////////////////////////////////////////////////
public static final int ALTA_ESPECIALIDAD= 800; 
public static final int BAJA_ESPECIALIDAD= 801; 
public static final int MODIFICAR_ESPECIALIDAD = 802;
public static final int MOSTRAR_ESPECIALIDAD = 803; 
public static final int MOSTRAR_TODAS_ESPECIALIDADES = 804; 
public static final int RES_ALTA_ESPECIALIDAD_OK =805; 
public static final int RES_ALTA_ESPECIALIDAD_FAILED= -805;
public static final int RES_BAJA_ESPECIALIDAD_OK=806;
public static final int RES_BAJA_ESPECIALIDAD_FAILED = -806;
public static final int RES_MODIFICAR_ESPECIALIDAD_OK = 807;
public static final int RES_MODIFICAR_ESPECIALIDAD_FAILED= -807;
public static final int RES_MOSTRAR_ESPECIALIDAD_OK=808;
public static final int	RES_MOSTRAR_ESPECIALIDAD_FAILED =-808;
public static final int RES_MOSTRAR_TODAS_ESPECIALIDADES_OK=809;
public static final int	RES_MOSTRAR_TODAS_ESPECIALIDADES_FAILED =-809;
public static final int RES_REACTIVAR_ESPECIALIDAD_OK = 810;
public static final int DATOS_INCORRECTOS_ESPECIALIDAD = 820;	
	
	
	
	
	
}
