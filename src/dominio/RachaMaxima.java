package dominio;

public class RachaMaxima {

	String velocidad;
	
	public RachaMaxima () {

		
	}

	public String getValor() {
		return velocidad;
	}

	public void setValor(String valor) {
		this.velocidad = valor;
	}

	@Override
	public String toString() {
		return "RachMax" + velocidad;
	}

	
	
}
