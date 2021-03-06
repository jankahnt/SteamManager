package de.steammanager.files;

import java.io.File;

public class FileManager {

	private File targetDirFile;
	private SteamFolder steamFolder;
	
	public FileManager(){
		steamFolder = new SteamFolder();
	}
	
	public FileManager(String targetDir){
		steamFolder = new SteamFolder();
		this.targetDirFile = new File(targetDir);
	}

	public File getTargetDirFile() {
		return targetDirFile;
	}

	public void setTargetDirFile(File targetDirFile) {
		this.targetDirFile = targetDirFile;
	}
	
	public SteamFolder getSteamFolder(){
		for(File folder : targetDirFile.listFiles()){
			if(folder.isDirectory()){
				steamFolder.addFolder(folder);
			}
		}
		return steamFolder;
	}
	
	public Boolean copyFolder(SteamFolder sourcefolder, SteamFolder targetFolder, String gameFolder){
		
		System.out.println("Moving: " + sourcefolder.getFolderPath(gameFolder) + 
				" To: " + targetFolder.getFolderPath(gameFolder));
		return true;
	}

}
