package jee.master.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import jee.master.model.ExecuteQuery;
import jee.master.view.InterfaceGraphicUser;

public class ExecuteQueryButton implements ActionListener{

	public ExecuteQueryButton(InterfaceGraphicUser interfaceGraphicUser) {
		// TODO Auto-generated constructor stub
		this.interfaceGraphicUser = interfaceGraphicUser;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sectionSelected = (String)interfaceGraphicUser.getSecciones().getSelectedItem();
		String originSelected = (String)interfaceGraphicUser.getPaises().getSelectedItem();
		resultset = executeQuery.dataBaseFilter(sectionSelected, originSelected);
		try {
			interfaceGraphicUser.getResultado().setText("sku	section	name	price	date	imported	origin\n");
			while(resultset.next()) {
				
				interfaceGraphicUser.getResultado().append(resultset.getString(1));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(2));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(3));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(4));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(5));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(6));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append(resultset.getString(7));
				interfaceGraphicUser.getResultado().append("	");
				interfaceGraphicUser.getResultado().append("\n");
			}
		}catch(SQLException e2) {
			e2.printStackTrace();
		}	
	}
	
	
	private InterfaceGraphicUser interfaceGraphicUser;
	ExecuteQuery executeQuery = new ExecuteQuery();
	private ResultSet resultset; 
}
