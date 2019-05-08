package dominio;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.Paths;

public class LectorMunicipio {

	private final String SEPARATOR = "\t";

	public void LectorMunicipio() {

	}

	public ArrayList<Municipio> leer(String ruta, String CodProvincia) throws IOException {

		ArrayList<Municipio> municipios = new ArrayList<Municipio>();

		BufferedReader lector;

		try {
			
			InputStream is = this.getClass().getResourceAsStream(ruta);
			lector = new BufferedReader(new InputStreamReader(is));
			
			//lector = new BufferedReader(new FileReader(ruta));
			String line = null;

			Municipio c = new Municipio("0", "-- Seleccione Municipio --");
			municipios.add(c);
			
			do {
				line = lector.readLine();
				if (line != null && line != "")
				{
					String[] partes = line.split(SEPARATOR);
					String codigo = partes[0];
					String codigoProv = codigo.substring(0, 2);
					String codigoMun = codigo;
					String nombre = partes[1];
					if (CodProvincia.equals(codigoProv)) {
						Municipio municipio = new Municipio(codigoMun, nombre);
						municipios.add(municipio);
					}
				}
			} while (line != null);

			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return municipios;
	}
}