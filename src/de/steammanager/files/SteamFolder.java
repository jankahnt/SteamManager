package de.steammanager.files;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SteamFolder {
	
	private Map<String, File> folderList;
	
	public SteamFolder(){
		folderList = new ConcurrentHashMap<String, File>();
	}
	
	public void addFolder(File folder){
		if(!folderList.containsKey(folder.getName())){
			folderList.put(folder.getName(), folder);
		}
	}

	public void removeFolder(File folder){
		if(folderList.containsKey(folder.getName())){
			folderList.remove(folder.getName());
		}
	}
	
	public void removeFolder(String folderName){
		if(folderList.containsKey(folderName)){
			folderList.remove(folderName);
		}
	}
	
	public void clearFolderList(){
		if(!folderList.isEmpty()){
			folderList.clear();
		}
	}
	
	public String[] getFolderListAsStringArray(){
		String[] folderNameArray = new String[folderList.size()];
		int i = 0;
		for(String folderName : folderList.keySet()){
			folderNameArray[i] = folderName;
			i++;
		}
		Arrays.sort(folderNameArray);
		return folderNameArray;
	}
	
	public int getSteamFolderSize(){
		return folderList.size();
	}
	
	public String getFolderPath(String folderName){
		return folderList.get(folderName).getPath();
	}
	
	public File getFolderFile(String folderName){
		return folderList.get(folderName);
	}
}
