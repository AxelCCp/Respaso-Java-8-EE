package jee.master.main;

import javax.swing.JFrame;

import jee.master.view.InterfaceGraphicUser;

public class Principal {
		
	public static void main(String ...mvc) {
	
		InterfaceGraphicUser gui = new InterfaceGraphicUser();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		
	}
}
