package dominio;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.Paths;

public class LectorComunidad {

	private final String SEPARATOR = "\t";

	public void LectorComunidad() {

	}

	public ArrayList<ComunidadAutonoma> leer(String ruta) throws IOException {

		ArrayList<ComunidadAutonoma> comunidadesAutonomas = new ArrayList<ComunidadAutonoma>();

		try {

			InputStream is = this.getClass().getResourceAsStream(ruta);
			BufferedReader lector = new BufferedReader(new InputStreamReader(is));		
			
			//TODO lo de Carlos
			//lector = new BufferedReader(new FileReader(ruta));
			String line = null;

			ComunidadAutonoma c = new ComunidadAutonoma("0", "-- Seleccione Comunidad --");
			comunidadesAutonomas.add(c);
			
			do {				
				line = lector.readLine();				
				
				if (line != null && line != "")
				{
					String[] partes = line.split(SEPARATOR);
					String codigo = partes[0];
					String nombre = partes[1];
					ComunidadAutonoma comunidad = new ComunidadAutonoma(codigo, nombre);
					comunidadesAutonomas.add(comunidad);	
				}
			}while (line != null);

			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return comunidadesAutonomas;
	}
}