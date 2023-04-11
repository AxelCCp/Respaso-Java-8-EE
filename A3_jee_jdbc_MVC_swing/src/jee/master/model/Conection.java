package jee.master.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {
	
	public Conection() {}
	
	public Connection getConnection() {
		 try {
			 conection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
		 }catch(Exception e) {
			 System.out.println("Does not connect!");
		 }
		 return conection;
	}
	
	Connection conection = null;

}
