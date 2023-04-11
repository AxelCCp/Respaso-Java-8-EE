package jee.master.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoadMenu {
	
	public LoadMenu() {
		conection = new Conection();
	}
	
	
	public String ejecuteQuerys() {
		Products product = null;
		Connection dataBaseAccess = conection.getConnection();
		try {
			Statement sections = dataBaseAccess.createStatement();
			Statement origins = dataBaseAccess.createStatement();
			resultSet1 = sections.executeQuery("SELECT DISTINCTROW SECTION FROM PRODUCTS");
			resultSet2 = origins.executeQuery("SELECT DISTINCTROW ORIGIN FROM PRODUCTS");
			product = new Products();
			product.setSection(resultSet1.getString(1));
			product.setOrigin(resultSet2.getString(1));
			resultSet1.close();
			resultSet2.close();
			dataBaseAccess.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product.getSection();
	}
	
	
	
	public ResultSet getResultSet1() {
		return resultSet1;
	}


	public void setResultSet1(ResultSet resultSet1) {
		this.resultSet1 = resultSet1;
	}


	public ResultSet getResultSet2() {
		return resultSet2;
	}


	public void setResultSet2(ResultSet resultSet2) {
		this.resultSet2 = resultSet2;
	}





	private Conection conection;
	private ResultSet resultSet1;
	private ResultSet resultSet2;
	
}
