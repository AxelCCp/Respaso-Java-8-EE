package jee.master.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import jee.master.model.LoadMenu;
import jee.master.view.InterfaceGraphicUser;

public class LoadingMenuJCombo extends WindowAdapter{
	
	public LoadingMenuJCombo(InterfaceGraphicUser interfaceGraphicUser) {
		this.interfaceGraphicUser = interfaceGraphicUser;
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		loadMenu.ejecuteQuerys();
		try {
			
			while(loadMenu.getResultSet1().next()) {
				interfaceGraphicUser.getSecciones().addItem(loadMenu.getResultSet1().getString(1));
			}
			while(loadMenu.getResultSet2().next()) {
				interfaceGraphicUser.getPaises().addItem(loadMenu.getResultSet2().getString(1));
			}
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}


	private InterfaceGraphicUser interfaceGraphicUser;
	private LoadMenu loadMenu = new LoadMenu(); 
}
