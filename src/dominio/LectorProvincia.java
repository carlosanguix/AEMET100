package dominio;

import java.util.ArrayList;
import java.io.*;
import java.nio.file.Paths;

public class LectorProvincia {

	private final String SEPARATOR = "\t";

	public void LectorProvincia() {

	}

	public ArrayList<Provincia> leer(String ruta, String codCCAA) throws IOException {

		ArrayList<Provincia> provincias = new ArrayList<Provincia>();

		BufferedReader lector;

		try {
			
			InputStream is = this.getClass().getResourceAsStream(ruta);
			lector = new BufferedReader(new InputStreamReader(is));
			
//			lector = new BufferedReader(new FileReader(ruta));
			String line = null;

			Provincia c = new Provincia("0", "-- Seleccione Provincia --");
			provincias.add(c);
			
			do {
				line = lector.readLine();
				if (line != null && line != "")
				{
					String[] partes = line.split(SEPARATOR);
					String codigo = partes[0];
					String codigoCCAA = codigo.substring(0, 2);
					String codProv = codigo.substring(2, codigo.length());
					String nombre = partes[1];
					if (codCCAA.equals(codigoCCAA)) {
						Provincia provincia = new Provincia(codProv, nombre);
						provincias.add(provincia);	
					}
				}
			}while (line != null);

			lector.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return provincias;
	}
}