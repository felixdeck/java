package FileIO;

import java.io.File;

public class FileIO {

	public static void main(String[] args) {
		String path = "C:\\Windows";
		File pathObj = new File(path);
		if(pathObj.exists()) {
			if(pathObj.isDirectory()) {
				System.out.println("Pfad existiert und es ist ein Directory!");
			}
		}
		File[] files= pathObj.listFiles();
		for(File f: files) {
			System.out.println("File: " + f.getName());
		}
	}

}
