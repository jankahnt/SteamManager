package de.steammanager.files;

public class TestFileManager {

	public static void main(String[] args) {
		FileManager sourcefm = new FileManager("/home/jfk1987/Dokumente/Programmierung/java/Test/Quelle/");
		FileManager targetfm = new FileManager("/home/jfk1987/Dokumente/Programmierung/java/Test/Ziel");

		for(String folder : sourcefm.getFolderNameList()){
			System.out.println(folder);
		}
	}

}
