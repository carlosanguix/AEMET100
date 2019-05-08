package dominio;

public class Temperatura {

	String minima;
	String maxima;
	
	public Temperatura () {

		
	}

	public String getMinima() {
		return minima;
	}

	public void setMinima(String minima) {
		this.minima = minima;
	}

	public String getMaxima() {
		return maxima;
	}

	public void setMaxima(String maxima) {
		this.maxima = maxima;
	}

	@Override
	public String toString() {
		return "Tempmin" + minima + ", max" + maxima;
	}

	
	
}
