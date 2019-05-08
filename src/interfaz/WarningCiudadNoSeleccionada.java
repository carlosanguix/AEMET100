package interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class WarningCiudadNoSeleccionada  {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void warning() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarningCiudadNoSeleccionada window = new WarningCiudadNoSeleccionada();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarningCiudadNoSeleccionada(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		panel.setLayout(gbl_panel);
		
		ImageIcon imgWarning = new ImageIcon("ficheros/iconos/warning.png");
		
		JLabel label_1 = new JLabel(imgWarning);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		JLabel lblAa = new JLabel("¡Seleccione un municipio!");
		GridBagConstraints gbc_lblAa = new GridBagConstraints();
		gbc_lblAa.insets = new Insets(0, 0, 5, 5);
		gbc_lblAa.gridx = 2;
		gbc_lblAa.gridy = 1;
		panel.add(lblAa, gbc_lblAa);
		
		JLabel label = new JLabel(imgWarning);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		
	}
}
