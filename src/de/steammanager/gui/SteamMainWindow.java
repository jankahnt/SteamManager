package de.steammanager.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.steammanager.files.FileManager;
import de.steammanager.files.SteamFolder;



@SuppressWarnings("serial")
public class SteamMainWindow extends JFrame{
	
	private static final int MARGIN = 10;
	private static final int LINE_HEIGHT = 30;
	private static final int LABEL_WIDTH = 45;
	private static final int BUTTON_WIDTH = 30;
	
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
    private JFileChooser lookupDirDialog;
    
    private SteamFolder sourceSteamFolder;
    private SteamFolder targetSteamFolder;
    private FileManager fileManager;
	
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
		
		lookupDirDialog = new JFileChooser();
		lookupDirDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
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
		
		sourceText.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent event) {
				sourceTextFieldChanged(event);
			}			
			@Override
			public void insertUpdate(DocumentEvent event) {
				sourceTextFieldChanged(event);			
			}			
			@Override
			public void changedUpdate(DocumentEvent event) {
				sourceTextFieldChanged(event);			
			}
		});
		targetText.getDocument().addDocumentListener(new DocumentListener() {		
			@Override
			public void removeUpdate(DocumentEvent event) {
				targetTextFieldChanged(event);
			}			
			@Override
			public void insertUpdate(DocumentEvent event) {
				targetTextFieldChanged(event);
			}			
			@Override
			public void changedUpdate(DocumentEvent event) {
				targetTextFieldChanged(event);
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

	public void toTargetButtonActionPerformed(ActionEvent event){
		System.out.println("toTargetButton pushed");
	}
	
	public void toSourceButtonActionPerformed(ActionEvent event){
		System.out.println("toSourceButton pushed");	
	}
		
	public void lookupSourceButtonActionPerformed(ActionEvent event){
		if(lookupDirDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			sourceText.setText(lookupDirDialog.getSelectedFile().getPath());
		}
	}
	
	public void lookupTargetButtonActionPerformed(ActionEvent event){
		if(lookupDirDialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			targetText.setText(lookupDirDialog.getSelectedFile().getPath());
		}
	}
	
	public void sourceTextFieldChanged(DocumentEvent event){
		if(!sourceText.getText().isEmpty()){
			fileManager = new FileManager(sourceText.getText());
			sourceSteamFolder = fileManager.getSteamFolder();
			sourceList.setListData(sourceSteamFolder.getFolderListAsStringArray());
		}
	}
	
	public void targetTextFieldChanged(DocumentEvent event){
		if(!targetText.getText().isEmpty()){
			fileManager = new FileManager(targetText.getText());
			targetSteamFolder = fileManager.getSteamFolder();
			targetList.setListData(targetSteamFolder.getFolderListAsStringArray());
		}
	}
	
	public void steamMainWindowResized(ComponentEvent event){
		int textFieldWidth = (contentPane.getWidth() /2) - BUTTON_WIDTH - LABEL_WIDTH - 3 * MARGIN;
		int scrollPaneHeight = contentPane.getHeight() - ((3 * MARGIN) + LINE_HEIGHT);
		
		sourceLabel.setBounds(contentPane.getX() + MARGIN, contentPane.getY() + MARGIN,
				LABEL_WIDTH, LINE_HEIGHT);
		sourceText.setBounds(sourceLabel.getX() + MARGIN + sourceLabel.getWidth(), sourceLabel.getY(), 
				textFieldWidth, LINE_HEIGHT);
		lookupSourceDir.setBounds(sourceText.getX() + sourceText.getWidth(), sourceText.getY(),
				BUTTON_WIDTH, LINE_HEIGHT);
		targetLabel.setBounds(lookupSourceDir.getX() + MARGIN + lookupSourceDir.getWidth(), 
				sourceLabel.getY(), LABEL_WIDTH, LINE_HEIGHT);
		targetText.setBounds(targetLabel.getX() + MARGIN + targetLabel.getWidth(), targetLabel.getY(), 
				sourceText.getWidth(), LINE_HEIGHT);
		lookupTargetDir.setBounds(targetText.getX() + targetText.getWidth(), targetText.getY(), 
				BUTTON_WIDTH, LINE_HEIGHT);
		sourceScrollPane.setBounds(sourceText.getX(), sourceText.getY() + sourceText.getHeight() + MARGIN, 
				sourceText.getWidth() + lookupSourceDir.getWidth(), scrollPaneHeight);
		targetScrollPane.setBounds(targetText.getX(), targetText.getY() + targetText.getHeight() + MARGIN, 
				targetText.getWidth() + lookupTargetDir.getWidth(), scrollPaneHeight);
		toTargetButton.setBounds(sourceScrollPane.getX() + sourceScrollPane.getWidth() + MARGIN, 
				sourceScrollPane.getHeight()/2 - (MARGIN + LINE_HEIGHT * 2), LABEL_WIDTH, LINE_HEIGHT * 2);
		toSourceButton.setBounds(toTargetButton.getX(), toTargetButton.getY() + toTargetButton.getHeight() + MARGIN, 
				toTargetButton.getWidth(), toTargetButton.getHeight());
	}
	

}
