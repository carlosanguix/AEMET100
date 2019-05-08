package dominio;

import java.util.HashMap;

public class Provincia {

	String codigo;
	String nombre;
	HashMap<String, String> municipios;
	
	public Provincia (String codigo, String nombre) {

		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	public String getNombre(){
		return this.nombre;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
