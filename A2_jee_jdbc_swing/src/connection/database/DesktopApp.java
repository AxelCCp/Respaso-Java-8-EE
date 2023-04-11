package connection.database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DesktopApp {

	public static void main(String ...args) {
		
			JFrame mimarco = new Marco_Aplicacion();
			mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mimarco.setVisible(true);
		}
	}
	
	class Marco_Aplicacion extends JFrame{
		
		public Marco_Aplicacion(){
			
			setTitle ("Query Database");
			setBounds(700,700,700,700);
			setLayout(new BorderLayout());
			
			JPanel menus=new JPanel();
			menus.setBackground(Color.DARK_GRAY);
			menus.setLayout(new FlowLayout());
			
			secciones =new JComboBox();
			secciones.setBackground(Color.LIGHT_GRAY);
			secciones.setEditable(false);
			secciones.addItem("All");
			
			paises = new JComboBox();
			paises.setBackground(Color.LIGHT_GRAY);
			paises.setEditable(false);
			paises.addItem("All");
			
			resultado= new JTextArea(4,50);
			resultado.setBackground(Color.GRAY);
			resultado.setForeground(Color.WHITE);
			resultado.setEditable(false);
			add(resultado);
			
			JLabel label1 = new JLabel("Sections: ");
			label1.setForeground(Color.LIGHT_GRAY);
			menus.add(label1);
			menus.add(secciones);
			JLabel label2 = new JLabel("Origin: ");
			label2.setForeground(Color.LIGHT_GRAY);
			menus.add(label2);
			menus.add(paises);	
			
			add(menus, BorderLayout.NORTH);
			add(resultado, BorderLayout.CENTER);
			
			JButton botonConsulta=new JButton("Execute query");	
			botonConsulta.setBackground(Color.DARK_GRAY);
			botonConsulta.setForeground(Color.LIGHT_GRAY);
			botonConsulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ejecutaConsulta();
					}
				});
			add(botonConsulta, BorderLayout.SOUTH);
			
				
			try {
				miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
				Statement sentencia = miConexion.createStatement();
				String consulta = "SELECT DISTINCTROW SECTION FROM PRODUCTS";									
				ResultSet rs = sentencia.executeQuery(consulta);
				while(rs.next()) {
					secciones.addItem(rs.getString(1)); 												    	 
				}
				rs.close();
				
			//------

				consulta = "SELECT DISTINCTROW ORIGIN FROM PRODUCTS";									
				rs = sentencia.executeQuery(consulta);
				while(rs.next()) {
					paises.addItem(rs.getString(1)); 															
				}
				rs.close();
				
			} catch(Exception e) {
				System.out.println("DOES NOT CONECT");
			}
		
		}
		
		
		
		private void ejecutaConsulta() {
			ResultSet rs = null;
			try {
				String seccion = (String) secciones.getSelectedItem();
				System.out.println(seccion);
				String pais = (String)paises.getSelectedItem();
				System.out.println(pais);

				if(!seccion.equals("All") && pais.equals("All")) {
					enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);
					enviaConsultaSeccion.setString(1,seccion);    													
					rs = enviaConsultaSeccion.executeQuery();
					resultado.setText("");	
									
				}else if(seccion.equals("All") && !pais.equals("All")) {
					enviaConsultaPais = miConexion.prepareStatement(consultaPais);
					enviaConsultaPais.setString(1,pais);    													
					rs = enviaConsultaPais.executeQuery();
					resultado.setText("");	
					
				}else if(!seccion.equals("All") && !pais.equals("All")) {
					enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);
					enviaConsultaTodos.setString(1,seccion); 
					enviaConsultaTodos.setString(2,pais);  													
					rs = enviaConsultaTodos.executeQuery();
					resultado.setText("");	
				
				}
				
				while(rs.next()) {	
					resultado.append(rs.getString(1));
					resultado.append(", "); 											
					resultado.append(rs.getString(2));
					resultado.append(", "); 
					resultado.append(rs.getString(3));
					resultado.append(", "); 
					resultado.append(rs.getString(4));
					resultado.append(", "); 
					resultado.append("\n");
				}
				
			}catch(Exception e){
				System.out.println("The query could not be executed!");
			}		
		}
		

		private Connection miConexion;
		private JComboBox secciones;
		private JComboBox paises;
		private JTextArea resultado;
		

		private PreparedStatement enviaConsultaSeccion;
		private PreparedStatement enviaConsultaPais;
		private PreparedStatement enviaConsultaTodos;
		
	
		private final String consultaSeccion = "SELECT NAME, SECTION, PRICE, ORIGIN FROM PRODUCTS WHERE SECTION=?";
		private final String consultaPais = "SELECT NAME, SECTION, PRICE, ORIGIN FROM PRODUCTS WHERE ORIGIN=?";
		private final String consultaTodos = "SELECT NAME, SECTION, PRICE, ORIGIN FROM PRODUCTS WHERE SECTION=? AND ORIGIN=?";
		
}



