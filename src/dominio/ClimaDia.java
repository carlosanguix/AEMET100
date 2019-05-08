package dominio;

public class ClimaDia {

	

	String fecha;
	ProbabildiadPrecipitacion probPrecipitacion;
	CotaNieve cotaNieve;
	EstadoCielo estadoCielo;
	Viento viento;
	RachaMaxima rachaMaxima;
	Temperatura temperatura;
	SensacionTermica sensTermica;
	Humedad humedad;
	IndiceUV indiceUV;
	
	

	public ClimaDia() {
		
		this.probPrecipitacion = new ProbabildiadPrecipitacion();
		this.cotaNieve = new CotaNieve();
		this.estadoCielo = new EstadoCielo();
		this.viento = new Viento();
		this.rachaMaxima = new RachaMaxima();
		this.temperatura = new Temperatura();
		this.sensTermica = new SensacionTermica();
		this.humedad = new Humedad();
		this.indiceUV = new IndiceUV();
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ProbabildiadPrecipitacion getProbPrecipitacion() {
		return probPrecipitacion;
	}

	public void setProbPrecipitacion(ProbabildiadPrecipitacion probPrecipitacion) {
		this.probPrecipitacion = probPrecipitacion;
	}

	public CotaNieve getCotaNieve() {
		return cotaNieve;
	}

	public void setCotaNieve(CotaNieve cotaNieve) {
		this.cotaNieve = cotaNieve;
	}

	public EstadoCielo getEstadoCielo() {
		return estadoCielo;
	}

	public void setEstadoCielo(EstadoCielo estadoCielo) {
		this.estadoCielo = estadoCielo;
	}

	public Viento getViento() {
		return viento;
	}

	public void setViento(Viento viento) {
		this.viento = viento;
	}

	public RachaMaxima getRachaMaxima() {
		return rachaMaxima;
	}

	public void setRachaMaxima(RachaMaxima rachaMaxima) {
		this.rachaMaxima = rachaMaxima;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	public SensacionTermica getSensTermica() {
		return sensTermica;
	}

	public void setSensTermica(SensacionTermica sensTermica) {
		this.sensTermica = sensTermica;
	}

	public Humedad getHumedad() {
		return humedad;
	}

	public void setHumedad(Humedad humedad) {
		this.humedad = humedad;
	}
	
	public IndiceUV getIndiceUV() {
		return indiceUV;
	}

	public void setIndiceUV(IndiceUV indiceUV) {
		this.indiceUV = indiceUV;
	}
	
	@Override
	public String toString() {
		return fecha + " / " + probPrecipitacion + " / " + cotaNieve
				+ " / " + estadoCielo + " / " + viento + " / " + rachaMaxima
				+ " / " + temperatura + " / " + sensTermica + " / " + humedad
				+ " / " + indiceUV + "]";
	}
	
}
