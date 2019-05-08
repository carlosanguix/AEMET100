package dominio;

import java.util.ArrayList;

public class Municipio<ClimaDia> {

	String codigo;
	String nombre;
	ArrayList<ClimaDia> dias;
	
	public Municipio (String codigo, String nombre) {

		this.codigo = codigo;
		this.nombre = nombre;		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<ClimaDia> getDias() {
		return dias;
	}

	public void setDias(ArrayList<ClimaDia> dias) {
		this.dias = dias;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
	

}
