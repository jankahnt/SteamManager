package de.steammanager.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class SteamMainWindow extends JFrame{
	
	private Container contentPane;
	private JPanel mainPanel;
    private JLabel sourceLabel;
    private JList<String> sourceList;
    private JScrollPane sourceScrollPane;
    private JTextField sourceText;
    private JLabel targetLabel;
    private JList<String> targetList;
    private JScrollPane targetScrollPane;
    private JTextField targetText;
    private JButton toSourceButton;
    private JButton toTargetButton;
	
	public SteamMainWindow(){
		initComponents();
	}
	
	private void initComponents(){
		contentPane = this.getContentPane();
		mainPanel = new JPanel();
		
		sourceLabel = new JLabel();
		sourceText = new JTextField();
		sourceScrollPane = new JScrollPane();
		sourceList = new JList<String>();
		
		targetLabel = new JLabel();
		targetText = new JTextField();
		targetScrollPane = new JScrollPane();
		targetList = new JList<String>();
		
		toSourceButton = new JButton("<");
		toTargetButton = new JButton(">");
		
		sourceLabel.setText("Quelle:");		
		targetLabel.setText("Ziel:");
		
		toSourceButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent event) {
				toSourceButtonActionPerformed(event);				
			}
		});
		
		toTargetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				toTargetButtonActionPerformed(event);				
			}
		});	
		
		setTitle("SteamManager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(10, 10);
		setSize(200, 320);
	}

	public void toSourceButtonActionPerformed(ActionEvent event){
		// TODO fill action listener		
	}
	
	public void toTargetButtonActionPerformed(ActionEvent event){
		// TODO fill action listener
	}

}
