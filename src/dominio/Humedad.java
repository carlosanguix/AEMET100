package dominio;

public class Humedad {

	String minima;
	String maxima;
	
	public Humedad () {

		
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
		return "Hmin" + minima + "Hmax" + maxima;
	}
	
	
	
}
