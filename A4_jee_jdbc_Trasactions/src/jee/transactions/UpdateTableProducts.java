package jee.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateTableProducts {

	public static void main(String ...transactions) {
		
		Connection myconnection = null;
		
		try {
			myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			myconnection.setAutoCommit(false);
			Statement statement = myconnection.createStatement();
			String sentence1="DELETE FROM PRODUCTS2 WHERE ORIGIN = 'ITALY'";
			String sentence2="DELETE FROM PRODUCTS2 WHERE PRICE>300";
			String sentence3="UPDATE PRODUCTS2 SET PRICE=PRICE*1.15";
			Boolean execute = UpdateTableProducts.executeTransaction();
			
			if(execute == true) {
				statement.executeUpdate(sentence1);
				statement.executeUpdate(sentence2);
				statement.executeUpdate(sentence3);
				myconnection.commit();
				System.out.println("The MySQL sentences was executed successfully!");
			}else {
				System.out.println("The MySQL sentences was not executed! You have errors on your code!");
			}
			
		}catch(Exception e) {
			try {
				myconnection.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
				System.out.println("The code has errors. No changes made.");
			}
			
		}
		
	}
	
	public static boolean executeTransaction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ejecutar transacción ¿? ingresa si o no : ");
		String response = scan.next();
		scan.close();
		if(response.equalsIgnoreCase("si")) {
			return true;
		} else {
			return false;
		}
		
	}
}
