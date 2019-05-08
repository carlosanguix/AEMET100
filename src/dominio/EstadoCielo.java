package dominio;

public class EstadoCielo {

	String descripcion;
	
	public EstadoCielo () {

		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	
	
}
