package connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDatabaseConnection {

	public static void main(String[] args) {
		
		try {
			Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("SELECT * FROM products");
			
			while(miResultset.next()) {																					//getDouble() : para precio decimal(10,2) en mysql.
				
				System.out.println(miResultset.getString("sku") + " " + miResultset.getString("section") + " " + 
				
									miResultset.getString("name") + " " + miResultset.getString("price") + " " + 
									
									miResultset.getString("date")  + " " + miResultset.getString("imported") + " " +
									
									miResultset.getString("origin"));
				
			}
			
		}catch(Exception e) {
			System.out.println("No conection!!!");
			e.printStackTrace();
		}

	}

}
