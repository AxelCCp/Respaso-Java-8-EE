package prepared.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedQuery {

	public static void main(String[] args) {
		
		try {
			Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			
			//  -------------------
			
			System.out.println("First Query:");										
			PreparedStatement myQuery = (PreparedStatement) miConexion.prepareStatement("select name, section, origin from products where section=? and origin=?");
			myQuery.setString(1,"SPORT"); 	
			myQuery.setString(2, "USA");
			ResultSet rs = myQuery.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			
			//  -------------------
			
			System.out.println("\nSecond Query:");
			myQuery.setString(1,"SPORT"); 	
			myQuery.setString(2, "CHINA");
			rs = myQuery.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
