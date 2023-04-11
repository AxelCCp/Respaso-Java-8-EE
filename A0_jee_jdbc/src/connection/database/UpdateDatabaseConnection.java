package connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDatabaseConnection {

	public static void main(String[]args) {
		
		try {
			Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			Statement miStatement = miConexion.createStatement();		
			String instruccionSql = "UPDATE PRODUCTS SET price = '200' WHERE sku='AR02'";
			miStatement.executeUpdate(instruccionSql);
			System.out.println("data modified successfully");
		}catch(Exception e) {
			System.out.println("Does not connect!");
			e.printStackTrace();
		
		}
	}
	
}
