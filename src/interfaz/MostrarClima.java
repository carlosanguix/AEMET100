package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import dominio.ClimaDia;

import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class MostrarClima extends JFrame {

	///////////
	private JPanel contentPane;
	
	Date fechaRecibida;
	String fechaFormateada;
	SimpleDateFormat formatoRecivido = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatoDia = new SimpleDateFormat("EEEE dd");
	JLabel lblDia;
	GridBagConstraints gbc_lblDia;
	
	String descEstCielo;
	URL rutaEstCielo;
	ImageIcon imgEstCielo;
	JLabel imagEstadoCielo;
	GridBagConstraints gbc_imagen;
	
	JLabel probPrec;
	GridBagConstraints gbc_probPrec;
	
	JLabel CotNieve;
	GridBagConstraints gbc_CotNieve;
	
	String tempMax;
	String tempMin;
	JLabel temperatura;
	GridBagConstraints gbc_temperatura;
	
	String sensMax;
	String sensMin;
	JLabel sensTerm;
	GridBagConstraints gbc_sensTerm;
	
	String humeMax;
	String humeMin;
	JLabel humedad;
	GridBagConstraints gbc_humedad;
	
	String direcViento;
	String velViento;
	String rutaImagenViento;
	ImageIcon imgDirViento;
	JLabel dirVelViento;
	GridBagConstraints gbc_dirVelViento;
	
	String valorRacha;
	JLabel racha;
	GridBagConstraints gbc_racha;
	
	JLabel uV;
	GridBagConstraints gbc_uV;

	/**
	 * Create the frame.
	 */
	public MostrarClima(ArrayList<ClimaDia> climaSemana, String nombreMunicipio) {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 200, 1750, 850);
		this.setTitle("El tiempo en " + nombreMunicipio);
//		this.setExtendedState(MAXIMIZED_BOTH);
		this.setResizable(false);

		contentPane = new JPanel(new GridLayout(10, 10, -1, -1));
		contentPane.setBackground(new Color(255, 255, 224));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {250, 250, 250, 250, 250, 250, 250};
		gbl_contentPane.rowHeights = new int[] {30, 100, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel probPrecText = new JLabel("-------------------------------------------------------------------------------------- Probabilidad de precipitación --------------------------------------------------------------------------------------");
		probPrecText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_probPrecText = new GridBagConstraints();
		gbc_probPrecText.anchor = GridBagConstraints.CENTER;
		gbc_probPrecText.insets = new Insets(0, 0, 5, 0);
		gbc_probPrecText.gridx = 0;
		gbc_probPrecText.gridy = 2;
		gbc_probPrecText.gridwidth = 7;
		contentPane.add(probPrecText, gbc_probPrecText);
		
		JLabel CotNievText = new JLabel("-------------------------------------------------------------------------------- Cota de nieve a nivel de provincia (m) --------------------------------------------------------------------------------");
		CotNievText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_CotNievText = new GridBagConstraints();
		gbc_CotNievText.anchor = GridBagConstraints.CENTER;
		gbc_CotNievText.insets = new Insets(0, 0, 5, 0);
		gbc_CotNievText.gridx = 0;
		gbc_CotNievText.gridy = 4;
		gbc_CotNievText.gridwidth = 7;
		contentPane.add(CotNievText, gbc_CotNievText);
		
		JLabel tempText = new JLabel("---------------------------------------------------------------------------------- Temperatura mínima y máxima (ºC) ---------------------------------------------------------------------------------");
		tempText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_tempText = new GridBagConstraints();
		gbc_tempText.anchor = GridBagConstraints.CENTER;
		gbc_tempText.insets = new Insets(0, 0, 5, 0);
		gbc_tempText.gridx = 0;
		gbc_tempText.gridy = 6;
		gbc_tempText.gridwidth = 7;
		contentPane.add(tempText, gbc_tempText);

		JLabel sensTermicaText = new JLabel("------------------------------------------------------------------------------------------ Sensación térmica (ºC) -------------------------------------------------------------------------------------------");
		sensTermicaText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_sensTermicaText = new GridBagConstraints();
		gbc_sensTermicaText.anchor = GridBagConstraints.CENTER;
		gbc_sensTermicaText.gridwidth = 7;
		gbc_sensTermicaText.insets = new Insets(0, 0, 5, 5);
		gbc_sensTermicaText.gridx = 0;
		gbc_sensTermicaText.gridy = 8;
		contentPane.add(sensTermicaText, gbc_sensTermicaText);

		JLabel humedadText = new JLabel("------------------------------------------------------------------------------- Humedad relativa mínima y máxima (%) ------------------------------------------------------------------------------");
		humedadText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_humedadText = new GridBagConstraints();
		gbc_humedadText.anchor = GridBagConstraints.CENTER;
		gbc_humedadText.gridwidth = 7;
		gbc_humedadText.insets = new Insets(0, 0, 5, 5);
		gbc_humedadText.gridx = 0;
		gbc_humedadText.gridy = 10;
		contentPane.add(humedadText, gbc_humedadText);

		JLabel vientoText = new JLabel("------------------------------------------------------------------------------- Dirección y velocidad del viento (km/h) -------------------------------------------------------------------------------");
		vientoText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_vientoText = new GridBagConstraints();
		gbc_vientoText.anchor = GridBagConstraints.CENTER;
		gbc_vientoText.gridwidth = 7;
		gbc_vientoText.insets = new Insets(0, 0, 5, 5);
		gbc_vientoText.gridx = 0;
		gbc_vientoText.gridy = 12;
		contentPane.add(vientoText, gbc_vientoText);

		JLabel rachaText = new JLabel("------------------------------------------------------------------------------------------- Racha máxima (km/h) --------------------------------------------------------------------------------------------");
		rachaText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_rachaText = new GridBagConstraints();
		gbc_rachaText.anchor = GridBagConstraints.CENTER;
		gbc_rachaText.gridwidth = 7;
		gbc_rachaText.insets = new Insets(0, 0, 5, 5);
		gbc_rachaText.gridx = 0;
		gbc_rachaText.gridy = 14;
		contentPane.add(rachaText, gbc_rachaText);

		JLabel indiceUVText = new JLabel("--------------------------------------------------------------------------------------------- Indice ultravioleta ----------------------------------------------------------------------------------------------");
		indiceUVText.setFont(probPrecText.getFont().deriveFont(20.0f));
		GridBagConstraints gbc_indiceUVText = new GridBagConstraints();
		gbc_indiceUVText.anchor = GridBagConstraints.CENTER;
		gbc_indiceUVText.gridwidth = 7;
		gbc_indiceUVText.insets = new Insets(0, 0, 5, 5);
		gbc_indiceUVText.gridx = 0;
		gbc_indiceUVText.gridy = 16;
		contentPane.add(indiceUVText, gbc_indiceUVText);

		for (int x = 0; x < 7; x++) {

			try {
				fechaRecibida   = formatoRecivido.parse(climaSemana.get(x).getFecha());
				fechaFormateada = formatoDia.format(fechaRecibida);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			lblDia = new JLabel(fechaFormateada);
			gbc_lblDia = new GridBagConstraints();
			lblDia.setFont(lblDia.getFont().deriveFont(25.0f));
			gbc_lblDia.insets = new Insets(0, 0, 5, 5);
			gbc_lblDia.gridx  = x;
			gbc_lblDia.gridy  = 0; 
			contentPane.add(lblDia, gbc_lblDia);

			descEstCielo    = climaSemana.get(x).getEstadoCielo().getDescripcion();
			try {
				// URL devuelta con .getClass().getResources(ruta);
				rutaEstCielo    = insertarImagenEstadoCielo(descEstCielo);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			// Creamos la imagen con la url
			imgEstCielo     = new ImageIcon(rutaEstCielo);
			imagEstadoCielo = new JLabel(imgEstCielo);
			gbc_imagen      = new GridBagConstraints();
			gbc_imagen.insets = new Insets(0, 0, 5, 5);
			gbc_imagen.gridx = x;
			gbc_imagen.gridy = 1;
			contentPane.add(imagEstadoCielo, gbc_imagen);
			
			probPrec = new JLabel(climaSemana.get(x).getProbPrecipitacion().getPorcentaje());
			gbc_probPrec = new GridBagConstraints();
			gbc_probPrec.insets = new Insets(0, 0, 5, 5);
			gbc_probPrec.gridx = x;
			gbc_probPrec.gridy = 3;
			contentPane.add(probPrec, gbc_probPrec);
			
			CotNieve = new JLabel(climaSemana.get(x).getCotaNieve().getMetros());
			gbc_CotNieve = new GridBagConstraints();
			gbc_CotNieve.insets = new Insets(0, 0, 5, 5);
			gbc_CotNieve.gridx = x;
			gbc_CotNieve.gridy = 5;
			contentPane.add(CotNieve, gbc_CotNieve);
			
			tempMax = climaSemana.get(x).getTemperatura().getMaxima();
			tempMin = climaSemana.get(x).getTemperatura().getMinima();
			temperatura = new JLabel(tempMax + " / " + tempMin);
			gbc_temperatura = new GridBagConstraints();
			gbc_temperatura.insets = new Insets(0, 0, 5, 5);
			gbc_temperatura.gridx = x;
			gbc_temperatura.gridy = 7;
			contentPane.add(temperatura, gbc_temperatura);
			
			sensMax = climaSemana.get(x).getSensTermica().getValorMax();
			sensMin = climaSemana.get(x).getSensTermica().getValorMin();
			sensTerm = new JLabel(sensMax + " / " + sensMin);
			gbc_sensTerm = new GridBagConstraints();
			gbc_sensTerm.insets = new Insets(0, 0, 5, 5);
			gbc_sensTerm.gridx = x;
			gbc_sensTerm.gridy = 9;
			contentPane.add(sensTerm, gbc_sensTerm);
			
			humeMax = climaSemana.get(x).getHumedad().getMaxima();
			humeMin = climaSemana.get(x).getHumedad().getMinima();
			humedad = new JLabel(humeMax + " / " + humeMin);
			gbc_humedad = new GridBagConstraints();
			gbc_humedad.insets = new Insets(0, 0, 5, 5);
			gbc_humedad.gridx = x;
			gbc_humedad.gridy = 11;
			contentPane.add(humedad, gbc_humedad);
			
			direcViento = climaSemana.get(x).getViento().getDireccion();
			velViento = climaSemana.get(x).getViento().getVelocidad();
			rutaImagenViento = insertarImagenDireccionViento(direcViento);
			imgDirViento = new ImageIcon(rutaImagenViento);
			dirVelViento = new JLabel(velViento);
			dirVelViento.setIcon(imgDirViento);
			gbc_dirVelViento = new GridBagConstraints();
			gbc_dirVelViento.insets = new Insets(0, 0, 5, 5);
			gbc_dirVelViento.gridx = x;
			gbc_dirVelViento.gridy = 13;
			contentPane.add(dirVelViento, gbc_dirVelViento);
			
			valorRacha = climaSemana.get(x).getRachaMaxima().getValor();
			racha = new JLabel(valorRacha);
			gbc_racha = new GridBagConstraints();
			gbc_racha.insets = new Insets(0, 0, 5, 5);
			gbc_racha.gridx = x;
			gbc_racha.gridy = 15;
			contentPane.add(racha, gbc_racha);
			
			uV = new JLabel(climaSemana.get(x).getIndiceUV().getValor());
			gbc_uV = new GridBagConstraints();
			gbc_uV.insets = new Insets(0, 0, 5, 5);
			gbc_uV.gridx = x;
			gbc_uV.gridy = 17;
			contentPane.add(uV, gbc_uV);
			
		}
	}

	private URL insertarImagenEstadoCielo(String estadoCielo) throws MalformedURLException {

		URL rutaImagen;

		switch (estadoCielo) {

		case "Despejado":
			rutaImagen = getClass().getResource("/ficheros/iconos/despejado.png");
			break;

		case "Cubierto con lluvia":
			rutaImagen = getClass().getResource("/ficheros/iconos/cubiertoConLluvia.png");
			break;

		case "Intervalos nuvosos con lluvia":
			rutaImagen = getClass().getResource("/ficheros/iconos/intervalosNuvososConLluvia.png");
			break;

		case "Intervalos nuvosos con lluvia escasa":
			rutaImagen = getClass().getResource("/ficheros/iconos/intervalosNuvososConLluviaEscasa.png");
			break;

		case "Muy nuboso con lluvia":
			rutaImagen = getClass().getResource("/ficheros/iconos/muyNubosoConLluvia.png");
			break;

		case "Muy nuboso con lluvia escasa":
			rutaImagen = getClass().getResource("/ficheros/iconos/muyNubosoConLluviaEscasa.png");
			break;

		case "Nuboso con lluvia escasa":
			rutaImagen = getClass().getResource("/ficheros/iconos/nubosoConLluviaEscasa.png");
			break;

		case "Nuboso con lluvia":
			rutaImagen = getClass().getResource("/ficheros/iconos/nubosoConLluvia.png");
			break;

		case "Cubierto con nieve":
			rutaImagen = getClass().getResource("/ficheros/iconos/cubiertoConNieve.png");
			break;

		case "Intervalos nubosos con lluvia escasa":
			rutaImagen = getClass().getResource("/ficheros/iconos/intervalosNuvososConLluviaEscasa.png");
			break;

		case "Intervalos nubosos con nieve":
			rutaImagen = getClass().getResource("/ficheros/iconos/intervalosNubososConNieve.png");
			break;

		case "Nuboso con nieve":
			rutaImagen = getClass().getResource("/ficheros/iconos/nubosoConNieve.png");
			break;

		case "Cielo despejado":
			rutaImagen = getClass().getResource("/ficheros/iconos/cieloDespejado.png");
			break;

		case "Muy nuboso":
			rutaImagen = getClass().getResource("/ficheros/iconos/muyNuboso.png");
			break;

		case "Cubierto":
			rutaImagen = getClass().getResource("/ficheros/iconos/Cubierto.png");
			break;

		case "Intervalos nubosos":
			rutaImagen = getClass().getResource("/ficheros/iconos/intervalosNubosos.png");
			break;

		case "Nubes altas":
			rutaImagen = getClass().getResource("/ficheros/iconos/nubesAltas.png");
			break;

		case "Nuboso":
			rutaImagen = getClass().getResource("/ficheros/iconos/nuboso.png");
			break;

		case "Poco nuboso":
			rutaImagen = getClass().getResource("/ficheros/iconos/pocoNuboso.png");
			break;

		case "Tormenta":
			rutaImagen = getClass().getResource("/ficheros/iconos/tormenta.png");
			break;

		default:
			rutaImagen = getClass().getResource("/ficheros/iconos/caca.png");
			break;

		}
		return rutaImagen;

	}

	private String insertarImagenDireccionViento(String direcVientoDia1) {

		String rutaImagen = "";

		switch (direcVientoDia1) {

		case "N":
			rutaImagen = "ficheros/iconos/norte.png";
			break;

		case "S":
			rutaImagen = "ficheros/iconos/sur.png";
			break;

		case "E":
			rutaImagen = "ficheros/iconos/este.png";
			break;

		case "O":
			rutaImagen = "ficheros/iconos/oeste.png";
			break;

		case "NO":
			rutaImagen = "ficheros/iconos/noroeste.png";
			break;

		case "NE":
			rutaImagen = "ficheros/iconos/noreste.png";
			break;

		case "SO":
			rutaImagen = "ficheros/iconos/suroeste.png";
			break;

		case "SE":
			rutaImagen = "ficheros/iconos/sureste.png";
			break;

		case "C":
			rutaImagen = "ficheros/iconos/c.png";


		default:
			break;
		}

		return rutaImagen;

	}

}