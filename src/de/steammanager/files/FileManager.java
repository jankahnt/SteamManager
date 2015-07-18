package de.steammanager.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	private String[] folderNameList;
	private String targetDir;
	private File targetDirFile;
	private List<File> folderFileList;
	
	public FileManager(){
		
	}
	
	public FileManager(String targetDir){
		this.targetDir = targetDir;
		this.targetDirFile = new File(targetDir);
	}

	public String[] getFolderNameList() {
		return folderNameList;
	}

	public void setFolderNameList(String[] folderNameList) {
		this.folderNameList = folderNameList;
	}

	public String getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}
	
	public File getTargetDirFile() {
		return targetDirFile;
	}

	public void setTargetDirFile(File targetDirFile) {
		this.targetDirFile = targetDirFile;
	}

	public List<File> getFolderFileList() {
		return folderFileList;
	}

	public void setFolderFileList(List<File> folderFileList) {
		this.folderFileList = folderFileList;
	}

	public int readTargetDir(){
		int folderCount = 0;
		File[] completeList;
		List<String> tmpList;
		
		completeList = targetDirFile.listFiles();
		tmpList = new ArrayList<String>();
		for(File file : completeList){
			if(file.isDirectory()){
				tmpList.add(file.getName());
				folderFileList.add(file);
			}
		}
		folderNameList = new String[tmpList.size()];
		tmpList.toArray(folderNameList);
		folderCount = folderNameList.length;
		
		return folderCount;
	}
	
	public Boolean copyFolder(String fileName, String targetPath){
		return true;
	}

}
