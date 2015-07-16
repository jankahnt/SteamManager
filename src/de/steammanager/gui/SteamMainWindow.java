package de.steammanager.gui;

import javax.swing.JFrame;

public class SteamMainWindow extends JFrame{
	
	public SteamMainWindow(){
		this.setTitle("SteamManager");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setSize(200, 320);
	}

}
