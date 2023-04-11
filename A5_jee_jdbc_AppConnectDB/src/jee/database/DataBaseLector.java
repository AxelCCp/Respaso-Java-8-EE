package jee.database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DataBaseLector {

	public static void main(String... readerDatabase) {
		MyFrame myframe = new MyFrame();
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setVisible(true);
	}

}

class MyFrame extends JFrame {

	public MyFrame() {
		this.setBounds(300, 300, 700, 700);
		MyPanel myPanel = new MyPanel();
		this.add(myPanel);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

class MyPanel extends JPanel {

	public MyPanel() {

		this.setLayout(new BorderLayout());
		comboTablas = new JComboBox<String>();
		areaInformacion = new JTextArea();
		this.add(areaInformacion, BorderLayout.CENTER);

		this.databaseConnect();
		this.getTables();

		comboTablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreTabla = (String) comboTablas.getSelectedItem();
				mostrarInfoTabla(nombreTabla);
			}
		});
		this.add(comboTablas, BorderLayout.NORTH);
	}

	public void databaseConnect() {
		miConexion = null;
		String datos[] = new String[3];

		try {
			entrada = new FileReader("C:/Users/Fanta/Documents/Za4.-JAVA_STANDARD_EDITION/A5_jee_jdbc_AppConnectDB/database-connection-data.txt");
		} catch (IOException e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}

		try {
			BufferedReader miBuffer = new BufferedReader(entrada);
			for (int i = 0; i <= 2; i++) {
				datos[i] = miBuffer.readLine();
			}
			miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);
			entrada.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getTables() {
		ResultSet miResultset = null;
		try {
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			miResultset = datosBBDD.getTables("java-ee-db", null, null, null);

			while (miResultset.next()) {
				comboTablas.addItem(miResultset.getString("TABLE_NAME"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarInfoTabla(String tabla) {

		ArrayList<String> campos = new ArrayList<String>();
		String consulta = "SELECT * FROM " + tabla;

		try {
			areaInformacion.setText("");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery(consulta);
			ResultSetMetaData rsBBDD = miResultset.getMetaData();

			for (int i = 1; i <= rsBBDD.getColumnCount(); i++) {

				campos.add(rsBBDD.getColumnLabel(i));
			}

			while (miResultset.next()) {

				for (String nombreCampo : campos) {
					areaInformacion.append(miResultset.getString(nombreCampo) + "  ");
				}

				areaInformacion.append("\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JComboBox<String> comboTablas;
	private JTextArea areaInformacion;
	private Connection miConexion;
	private FileReader entrada;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
