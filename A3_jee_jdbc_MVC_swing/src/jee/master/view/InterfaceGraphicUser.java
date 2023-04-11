package jee.master.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import jee.master.controller.ExecuteQueryButton;
import jee.master.controller.LoadingMenuJCombo;

public class InterfaceGraphicUser extends JFrame {

	public InterfaceGraphicUser() {
		
		setTitle ("Query Database");
		setBounds(600,200,700,700);
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		menus.setBackground(Color.DARK_GRAY);
		menus.setLayout(new FlowLayout());
		
		secciones =new JComboBox<String>();
		secciones.setBackground(Color.LIGHT_GRAY);
		secciones.setEditable(false);
		secciones.addItem("All");
		
		paises = new JComboBox<String>();
		paises.setBackground(Color.LIGHT_GRAY);
		paises.setEditable(false);
		paises.addItem("All");
		
		resultado= new JTextArea(7,50);
		resultado.setBackground(Color.GRAY);
		resultado.setForeground(Color.WHITE);
		resultado.setEditable(false);
		add(resultado);
		
		JLabel label1 = new JLabel("Sections: ");
		label1.setForeground(Color.LIGHT_GRAY);
		menus.add(label1);
		menus.add(secciones);
		JLabel label2 = new JLabel("Origin: ");
		label2.setForeground(Color.LIGHT_GRAY);
		menus.add(label2);
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Execute query");	
		botonConsulta.setBackground(Color.DARK_GRAY);
		botonConsulta.setForeground(Color.LIGHT_GRAY);
		
		add(botonConsulta, BorderLayout.SOUTH);
		botonConsulta.addActionListener(new ExecuteQueryButton(this));
		
		this.addWindowListener(new LoadingMenuJCombo(this));
	}
	
	
	
	
	public JComboBox<String> getSecciones() {
		return secciones;
	}
	public void setSecciones(JComboBox<String> secciones) {
		this.secciones = secciones;
	}
	public JComboBox<String> getPaises() {
		return paises;
	}
	public void setPaises(JComboBox<String> paises) {
		this.paises = paises;
	}
	public JTextArea getResultado() {
		return resultado;
	}
	public void setResultado(JTextArea resultado) {
		this.resultado = resultado;
	}




	private JComboBox<String> secciones;
	private JComboBox<String> paises;
	private JTextArea resultado;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
