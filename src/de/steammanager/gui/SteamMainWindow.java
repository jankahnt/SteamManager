package de.steammanager.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class SteamMainWindow extends JFrame implements ActionListener{
	
	private Container contentPane;
	private JPanel mainPanel;
	
	public SteamMainWindow(){
		this.contentPane = this.getContentPane();
		this.mainPanel = new JPanel();
		
		this.setTitle("SteamManager");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setSize(200, 320);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
