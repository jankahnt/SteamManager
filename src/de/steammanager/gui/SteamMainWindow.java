package de.steammanager.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class SteamMainWindow extends JFrame{
	
	private static final int MARGIN = 10;
	private static final int LINE_HEIGHT = 25;
	private static final int LABEL_WIDTH = 45;
	private static final int BUTTON_WIDTH = 40;
	
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
    private JButton lookupSourceDir;
    private JButton lookupTargetDir;
	
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
		
		lookupSourceDir = new JButton("…");
		lookupTargetDir = new JButton("…");
		
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
		
		lookupSourceDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				lookupSourceButtonActionPerformed(event);
			}
		});
		lookupTargetDir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				lookupTargetButtonActionPerformed(event);
			}
		});
		
		
		addComponentListener(new ComponentListener() {
			@Override
			public void componentShown(ComponentEvent event) {}			
			@Override
			public void componentResized(ComponentEvent event) {
				steamMainWindowResized(event);
			}
			@Override
			public void componentMoved(ComponentEvent event) {}
			@Override
			public void componentHidden(ComponentEvent event) {}
		});
		
		sourceScrollPane.setViewportView(sourceList);
		
		targetScrollPane.setViewportView(targetList);
		
		add(mainPanel);		
		mainPanel.setLayout(null);
		
		mainPanel.add(sourceLabel);
		mainPanel.add(sourceText);
		mainPanel.add(lookupSourceDir);
		mainPanel.add(targetLabel);
		mainPanel.add(targetText);
		mainPanel.add(lookupTargetDir);
		mainPanel.add(sourceScrollPane);
		mainPanel.add(targetScrollPane);
		mainPanel.add(toSourceButton);
		mainPanel.add(toTargetButton);
		
		setTitle("SteamManager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(50, 50);
		setMinimumSize(new Dimension(640, 400));
	}

	public void toSourceButtonActionPerformed(ActionEvent event){
		System.out.println("toSourceButton pushed");	
	}
	
	public void toTargetButtonActionPerformed(ActionEvent event){
		System.out.println("toTargetButton pushed");
	}
	
	public void lookupSourceButtonActionPerformed(ActionEvent event){
		System.out.println("lookupSourceButton pushed");
	}
	
	public void lookupTargetButtonActionPerformed(ActionEvent event){
		System.out.println("lookupTargetButton pushed");
	}
	
	public void steamMainWindowResized(ComponentEvent event){
		int textFieldWidth = (contentPane.getWidth() /2) - BUTTON_WIDTH - LABEL_WIDTH - MARGIN;
		int scrollPaneHeight = contentPane.getHeight() - ((3 * MARGIN) + LINE_HEIGHT);
		
		sourceLabel.setBounds(contentPane.getX() + MARGIN, contentPane.getY() + MARGIN,
				LABEL_WIDTH, LINE_HEIGHT);
		sourceText.setBounds(sourceLabel.getX() + MARGIN + sourceLabel.getWidth(), sourceLabel.getY(), 
				textFieldWidth, LINE_HEIGHT);
		lookupSourceDir.setBounds(sourceText.getX() + sourceText.getWidth(), sourceText.getY(),
				BUTTON_WIDTH / 2, LINE_HEIGHT);
		targetLabel.setBounds(lookupSourceDir.getX() + MARGIN + lookupSourceDir.getWidth(), 
				sourceLabel.getY(), LABEL_WIDTH, LINE_HEIGHT);
		targetText.setBounds(targetLabel.getX() + MARGIN + targetLabel.getWidth(), targetLabel.getY(), 
				sourceText.getWidth(), LINE_HEIGHT);
		lookupTargetDir.setBounds(targetText.getX() + targetText.getWidth(), targetText.getY(), 
				BUTTON_WIDTH / 2, LINE_HEIGHT);
		sourceScrollPane.setBounds(sourceText.getX(), sourceText.getY() + sourceText.getHeight() + MARGIN, 
				sourceText.getWidth() + lookupSourceDir.getWidth(), scrollPaneHeight);
		targetScrollPane.setBounds(targetText.getX(), targetText.getY() + targetText.getHeight() + MARGIN, 
				targetText.getWidth() + lookupTargetDir.getWidth(), scrollPaneHeight);
		toSourceButton.setBounds(sourceScrollPane.getX() + sourceScrollPane.getWidth() + MARGIN, 
				sourceScrollPane.getHeight()/2 - (MARGIN + LINE_HEIGHT * 2), LABEL_WIDTH, LINE_HEIGHT * 2);
		toTargetButton.setBounds(toSourceButton.getX(), toSourceButton.getY() + toSourceButton.getHeight() + MARGIN, 
				toSourceButton.getWidth(), toSourceButton.getHeight());
	}
	

}
