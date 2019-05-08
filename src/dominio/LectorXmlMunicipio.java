package dominio;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.io.InputStream;

public class LectorXmlMunicipio {


	public LectorXmlMunicipio() {

	} 

	public ArrayList<ClimaDia> Leer(String uri) {
		
		ArrayList<ClimaDia> climaSemana = new ArrayList<>();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
			// Le pasamos la URL del XML
			URL url = new URL(uri);
			InputStream stream = url.openStream();
			Document document = documentBuilder.parse(stream);
			document.getDocumentElement().normalize();

//			NodeList municipios = document.getElementsByTagName("nombre");
//			Node nombreMun = municipios.item(0);
//			if (nombreMun.getNodeType() == Node.ELEMENT_NODE) {
//				String nombreMunucipio = nombreMun.getTextContent();
//			}
//			NodeList provincias = document.getElementsByTagName("provincia");
//			Node nombreProv = provincias.item(0);
//			if (nombreProv.getNodeType() == Node.ELEMENT_NODE) {
//				String nombreProvincia = nombreProv.getTextContent();
//			}

			// Iteración 7 días
			NodeList listaDias = document.getElementsByTagName("dia");
			for (int i = 0; i < 7; i++) {
				
				ClimaDia clima = new ClimaDia();
				
				Node dia = listaDias.item(i);
				Element elementos = (Element) dia;

				// Nos quedamos con el atributo fecha
				String fechaDia = dia.getAttributes().item(0).getNodeValue();
				clima.setFecha(fechaDia);

				// Probabilidad de precipitacion
				NodeList listaProbPrec = elementos.getElementsByTagName("prob_precipitacion");
				// Nos quedamos con el primer valor no nulo de la lista
				String porcentajeProbPrec = "0%";
				for (int j = 0; j < listaProbPrec.getLength(); j++) {
					Node probPrec = listaProbPrec.item(j);
					Element valorProbPrec = (Element) probPrec;
					if (!valorProbPrec.getTextContent().isEmpty()) {
						porcentajeProbPrec = valorProbPrec.getTextContent() + "%";
						break;
					}
				}
				// Le damos valor al atributo de la clase ProbPrec de la clase ClimaDia
				clima.getProbPrecipitacion().setPorcentaje(porcentajeProbPrec);

				// Cota de nieve
				NodeList listaCotaNieve = elementos.getElementsByTagName("cota_nieve_prov");
				String metrosCotaNieve = "0m";
				for (int j = 0; j < listaCotaNieve.getLength(); j++) {
					Node cotaNieve = listaCotaNieve.item(j);
					Element valorCotaNieve = (Element) cotaNieve;
					if (!valorCotaNieve.getTextContent().isEmpty()) {
						metrosCotaNieve = valorCotaNieve.getTextContent() + "m";
						break;
					}
				}
				clima.getCotaNieve().setMetros(metrosCotaNieve);

				// Probabilidad de precipitacion
				NodeList listaEstadoCielo = elementos.getElementsByTagName("estado_cielo");
				String valorEC = "Despejado";
				for (int j = 0; j < listaProbPrec.getLength(); j++) {
					Node nodoEstadoCielo = listaEstadoCielo.item(j);
					Element atributoEstadoCielo = (Element) nodoEstadoCielo;
					if (!atributoEstadoCielo.getAttribute("descripcion").equals("")) {
						valorEC = atributoEstadoCielo.getAttribute("descripcion");
						break;
					}
				}
				// Le damos valor al atributo de la clase EstadoCielo de la clase ClimaDia
				clima.getEstadoCielo().setDescripcion(valorEC);

				// Viento
				NodeList listaViento = elementos.getElementsByTagName("viento");
				String direccionViento = "";
				String velocidadViento = "";
				for (int j = 0; j < listaViento.getLength(); j++) {

					Node nodeViento = listaViento.item(j);
					Element elementoViento = (Element) nodeViento;

					if (direccionViento.isEmpty()) {
						direccionViento = elementoViento.getElementsByTagName("direccion").item(0).getTextContent();
					}
					
					if (velocidadViento.isEmpty()) {
						velocidadViento = elementoViento.getElementsByTagName("velocidad").item(0).getTextContent();
					}
					
					if (!direccionViento.isEmpty() && !velocidadViento.isEmpty()) {
						break;
					}
				}
				clima.getViento().setDireccion(direccionViento);
				clima.getViento().setVelocidad(velocidadViento);

				// Racha maxima
				NodeList listaRachas = elementos.getElementsByTagName("racha_max");
				String velocidadRacha = "0km/h";
				for (int j = 0; j < listaRachas.getLength(); j++) {
					
					if (velocidadRacha.equals("0km/h") && !listaRachas.item(j).getTextContent().equals("")) {
						velocidadRacha = listaRachas.item(j).getTextContent() + "km/h";
					}
					
					if (!velocidadRacha.equals("0km/h")) {
						break;
					}
					
				}
				clima.getRachaMaxima().setValor(velocidadRacha);
				
				// Temperatura
				NodeList listaTemperatura = elementos.getElementsByTagName("temperatura");
				Element elementoTemperatura = (Element) listaTemperatura.item(0);
				String temperaturaMax = elementoTemperatura.getElementsByTagName("maxima").item(0).getTextContent();
				String temperaturaMin = elementoTemperatura.getElementsByTagName("minima").item(0).getTextContent();
				clima.getTemperatura().setMaxima(temperaturaMax);
				clima.getTemperatura().setMinima(temperaturaMin);
				
				// Sensacion termica
				NodeList listaSensTermica = elementos.getElementsByTagName("sens_termica");
				Element elementoSensTermica = (Element) listaSensTermica.item(0);
				String sensacionMaxima = elementoSensTermica.getElementsByTagName("maxima").item(0).getTextContent();
				String sensacionMinima = elementoSensTermica.getElementsByTagName("minima").item(0).getTextContent();
				clima.getSensTermica().setValorMax(sensacionMaxima);
				clima.getSensTermica().setValorMin(sensacionMinima);
				
				// Humedad
				NodeList listaHumedad = elementos.getElementsByTagName("humedad_relativa");
				Element elementoHumedad = (Element) listaHumedad.item(0);
				String humedadMaxima = elementoHumedad.getElementsByTagName("maxima").item(0).getTextContent();
				String humedadMinima = elementoHumedad.getElementsByTagName("minima").item(0).getTextContent();
				// TODO coge solo la maxima
				clima.getHumedad().setMaxima(humedadMaxima);
				clima.getHumedad().setMinima(humedadMinima);
				
				// Indice ultravioleta
				NodeList listaUV = elementos.getElementsByTagName("uv_max");
				Element elementoUV = (Element) listaUV.item(0);
				String indiceUV = "0";
				if (elementoUV != null) {
					indiceUV = listaUV.item(0).getTextContent().toString();
				}
				// TODO NULLPOINTEREXCEPTION no lo recoge
				clima.getIndiceUV().setValor(indiceUV);
				// Añadimos el clima de ese dia al arraylist
				climaSemana.add(i, clima);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return climaSemana;

	}

}