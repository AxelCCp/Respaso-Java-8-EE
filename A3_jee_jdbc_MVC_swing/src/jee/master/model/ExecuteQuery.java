package jee.master.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExecuteQuery {
	
	public ExecuteQuery() {
		conection  = new Conection();
	}

	public ResultSet dataBaseFilter(String section, String origin) {
		Connection connect = conection.getConnection();
		resultSet = null;
		try {
		

			if(!section.equals("All") && origin.equals("All")) {
				enviaConsultaSeccion = connect.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1,section);    													
				resultSet = enviaConsultaSeccion.executeQuery();
				
			}else if(section.equals("All") && !origin.equals("All")) {
				enviaConsultaPais = connect.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1,origin);    													
				resultSet = enviaConsultaPais.executeQuery();
				
			}else if(!section.equals("All") && !origin.equals("All")) {
				enviaConsultaTodos = connect.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1,section); 
				enviaConsultaTodos.setString(2,origin);  													
				resultSet = enviaConsultaTodos.executeQuery();	
			}else {
				enviaConsultaTodos = connect.prepareStatement(consultaAllAll);
				resultSet = enviaConsultaTodos.executeQuery();	
			}
			
		}catch(Exception e){
			System.out.println("The query could not be executed!");
		}
		
		return resultSet;
	}
	
	
	private Conection conection;
	private ResultSet resultSet;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	private final String consultaSeccion =  "SELECT SKU, SECTION, NAME, PRICE, DATE, IMPORTED, ORIGIN FROM PRODUCTS WHERE SECTION=?";
	private final String consultaPais = 	"SELECT SKU, SECTION, NAME, PRICE, DATE, IMPORTED, ORIGIN FROM PRODUCTS WHERE ORIGIN=?";
	private final String consultaTodos = 	"SELECT SKU, SECTION, NAME, PRICE, DATE, IMPORTED, ORIGIN FROM PRODUCTS WHERE SECTION=? AND ORIGIN=?";
	private final String consultaAllAll = 	"SELECT SKU, SECTION, NAME, PRICE, DATE, IMPORTED, ORIGIN FROM PRODUCTS";
}