package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import dominio.ClimaDia;
import dominio.ComunidadAutonoma;
import dominio.LectorComunidad;
import dominio.LectorMunicipio;
import dominio.LectorProvincia;
import dominio.LectorXmlMunicipio;
import dominio.Municipio;
import dominio.Provincia;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SeleccionCiudad extends JFrame {

	private LectorComunidad lectorCCAA = new LectorComunidad();
	private LectorProvincia lectorProvincia = new LectorProvincia();
	private LectorMunicipio lectorMunicipio = new LectorMunicipio();

	private String ficheroCCAA = "/datos/01CodCCAA";
	private String ficheroProvincias = "/datos/02CodProv";
	private String ficheroMunicipios = "/datos/03CodMun";

	private ArrayList<ComunidadAutonoma> comunidadesAutonomas;
	private ArrayList<Provincia> provincias;
	private ArrayList<Municipio> municipios;

	private String codigoCCAA;
	private String codigoProvincia;
	private String nombreProvincia;
	private String codigoMunicipio;
	private String nombreMunicipio;

	private ArrayList<ClimaDia> climaSemana = new ArrayList<ClimaDia>();

	private DefaultComboBoxModel<ComunidadAutonoma> modelCCAA;

	private JComboBox comBoxCCAA;
	private JComboBox comBoxProvincias;
	private JComboBox comBoxMunicipios;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionCiudad frame = new SeleccionCiudad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws MunicipioNoSeleccionadoException 
	 */
	public SeleccionCiudad() throws IOException {


		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 400, 400, 300);
		setTitle("AEMET");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblCCAA = new JLabel("Comunidades Autónomas");
		lblCCAA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCCAA.setVerticalAlignment(SwingConstants.CENTER);
		lblCCAA.setBounds(98, 12, 187, 31);
		panel.add(lblCCAA);

		JLabel lblProvincias = new JLabel("Provincias");
		lblProvincias.setVerticalAlignment(SwingConstants.CENTER);
		lblProvincias.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvincias.setBounds(98, 65, 187, 31);
		panel.add(lblProvincias);

		JLabel lblMunicipios = new JLabel("Municipios");
		lblMunicipios.setVerticalAlignment(SwingConstants.CENTER);
		lblMunicipios.setHorizontalAlignment(SwingConstants.CENTER);
		lblMunicipios.setBounds(98, 115, 187, 31);
		panel.add(lblMunicipios);

		comBoxCCAA = new JComboBox();
		comBoxCCAA.setBounds(46, 42, 303, 24);
		comunidadesAutonomas = lectorCCAA.leer(ficheroCCAA);
		comBoxCCAA.setModel(new DefaultComboBoxModel(comunidadesAutonomas.toArray()));
		ActionListener actionCCAA = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Nos quedamos con el código de la CCAA que hemos elegido
				averiguarCodigoCCAA(comBoxCCAA.getSelectedIndex());
				comBoxCCAA.setSelectedItem(comunidadesAutonomas.get(comBoxCCAA.getSelectedIndex()));
				try {
					provincias = lectorProvincia.leer(ficheroProvincias, codigoCCAA);
				} catch (IOException e) {
					e.printStackTrace();
				}
				comBoxProvincias.setModel(new DefaultComboBoxModel(provincias.toArray()));
			}
		};
		comBoxCCAA.addActionListener(actionCCAA);
		panel.add(comBoxCCAA);

		comBoxProvincias = new JComboBox();
		comBoxProvincias.setBounds(46, 91, 303, 24);
		ActionListener actionProvincias = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Nos quedamos con el código de la CCAA que hemos elegido
				averiguarCodigoProvincia(comBoxProvincias.getSelectedIndex());
				comBoxProvincias.setSelectedItem(provincias.get(comBoxProvincias.getSelectedIndex()));
				try {
					municipios = lectorMunicipio.leer(ficheroMunicipios, codigoProvincia);
				} catch (IOException e) {
					e.printStackTrace();
				}
				comBoxMunicipios.setModel(new DefaultComboBoxModel(municipios.toArray()));
			}
		};
		comBoxProvincias.addActionListener(actionProvincias);
		panel.add(comBoxProvincias);

		comBoxMunicipios = new JComboBox();
		comBoxMunicipios.setBounds(46, 142, 303, 24);
		ActionListener actionMunicipios = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// Nos quedamos con el código de la CCAA que hemos elegido
				averiguarCodigoMunicipio(comBoxMunicipios.getSelectedItem());
				LectorXmlMunicipio lectorXml = new LectorXmlMunicipio();
				climaSemana = new ArrayList<>(lectorXml.Leer("http://www.aemet.es/xml/municipios/localidad_" + codigoMunicipio + ".xml"));
			}
		};
		comBoxMunicipios.addActionListener(actionMunicipios);
		panel.add(comBoxMunicipios);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//MostrarClima.mostrar(climaSemana, nombreMunicipio);
				if (climaSemana.size() != 0) {
					MostrarClima frameMostrarClima = new MostrarClima(climaSemana, nombreMunicipio);
					frameMostrarClima.setVisible(true);
				} else {
					WarningCiudadNoSeleccionada.warning();
				}
			}
		});
		btnAceptar.setBounds(139, 205, 114, 25);
		panel.add(btnAceptar);

		JLabel lblNewLabel = new JLabel("");
		
		URL url = getClass().getResource("/ficheros/logoAemet.jpg");
		ImageIcon imagen = new ImageIcon(url);		
		
		lblNewLabel.setIcon(imagen);
		lblNewLabel.setBounds(0, 0, 390, 260);
		panel.add(lblNewLabel);
		
	}

	private void averiguarCodigoCCAA(int indiceCCAA) {

		this.codigoCCAA = this.comunidadesAutonomas.get(indiceCCAA).getCodigo();
	}

	private void averiguarCodigoProvincia(int indiceProvincia) {

		this.codigoProvincia = this.provincias.get(indiceProvincia).getCodigo();
		this.nombreProvincia = this.provincias.get(indiceProvincia).getNombre();
	}

	private void averiguarCodigoMunicipio(Object item) {

		for (int i = 0; i < municipios.size(); i++) {
			if (item.toString().equals(municipios.get(i).getNombre())) {
				codigoMunicipio = municipios.get(i).getCodigo();
				nombreMunicipio = municipios.get(i).getNombre();
				break;
			}
		}
	}
}
