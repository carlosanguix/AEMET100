package dominio;

public class SensacionTermica {

	
	String valorMax;
	String valorMin;
	
	public SensacionTermica () {

		
	}

	public String getValorMax() {
		return valorMax;
	}

	public void setValorMax(String valor) {
		this.valorMax = valor;
	}

	public String getValorMin() {
		return valorMin;
	}

	public void setValorMin(String valorMin) {
		this.valorMin = valorMin;
	}

	@Override
	public String toString() {
		return "SensTermMax" + valorMax + ", Min" + valorMin;
	}

	
	
}
