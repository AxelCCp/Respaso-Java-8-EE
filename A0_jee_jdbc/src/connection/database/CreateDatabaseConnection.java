package connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseConnection {

	public static void main(String[]args) {
		
		try {
			Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			Statement miStatement = miConexion.createStatement();
			String instruccionSql = "INSERT INTO PRODUCTS (sku, section, name, price, date, imported, origin) VALUES ('AR02','SPORT','POLERA', '10.00', '22/11/2022', 'TRUE', 'CHINA')";  
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Data inserted correctly");
		}catch(Exception e) {
			System.out.println("Does not connect!");
			e.printStackTrace();
		}
	}
	
	
}
