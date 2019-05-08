package dominio;

public class Viento {

	String direccion;
	String velocidad;
	
	public Viento () {

		this.direccion = " ";
		this.velocidad = " ";
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "direccion" + direccion + ", velocidad" + velocidad;
	}

	
	
}
