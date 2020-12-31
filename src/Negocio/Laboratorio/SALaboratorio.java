package Negocio.Laboratorio;

import java.util.List;

public interface SALaboratorio {	

	public int create (TLaboratorio tLaboratorio);
	public TLaboratorio readByName(String name);
	public List<TLaboratorio> readAll();
	public int update(TLaboratorio tLaboratorio);
	public int delete(int tId);
	public TLaboratorio readById(int id);
	public String readProductosLaboratorio(int idLaboratorio);
	
}
