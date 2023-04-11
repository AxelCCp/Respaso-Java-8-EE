package jee.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertClientesPedidos {
	
	public static void main(String[]arg) {
		
		
		Connection myconnection = null;
		
		try {
			myconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-ee-db","root","sasa");
			myconnection.setAutoCommit(false);
			Statement statement = myconnection.createStatement();
			
			String sentence1="INSERT INTO CLIENTES (id, company, address, city, phone, contact) VALUES ('6', '2rr.sa', 'Av. 2sdfgd 123', '2rtyrtr', '21176535645', '2una persona')";
			String sentence2="INSERT INTO PEDIDOS (numeropedido, codigocliente, fechapedido, formadepago, descuento, enviado) VALUES('40', 'CT84', '25/12/2022','credit card', 15, 'si')";
			
			statement.executeUpdate(sentence1);
			statement.executeUpdate(sentence2);
			myconnection.commit();
			System.out.println("The MySQL sentences was executed successfully!");
			
		}catch(Exception e) {
			try {
				myconnection.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
				System.out.println("The code has errors. No changes made.");
			}
			e.printStackTrace();
		}
		
	}

}
