package dominio;

public class ProbabildiadPrecipitacion {

	String porcentaje;
	
	public ProbabildiadPrecipitacion () {

		
	}
	
	public void setPorcentaje(String porcentaje) {
		
		this.porcentaje = porcentaje;
	}

	public String getPorcentaje() {
		
		return this.porcentaje;
	}

	@Override
	public String toString() {
		return "ProbPrec" + porcentaje;
	}
	
	
	
}
