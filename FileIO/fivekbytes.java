package FileIO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fivekbytes {

	public static void main(String[] args) {
		try(FileOutputStream file = new FileOutputStream(
				"\\C:\\Users\\deckenf\\eclipse-workspace-java\\file.txt")){
			Long t1 = System.nanoTime();
			for(int i=0; i<500000;i++) {
				file.write(0x00000001);
			}
			file.flush();
			Long td1 = System.nanoTime()-t1;
			System.out.println("Time with generall write() method: " + td1);
			Long t3 = System.nanoTime();
			BufferedOutputStream bFile = new BufferedOutputStream(file);
			for(int i=0; i<500000;i++) {
				bFile.write(0x00000001);
			}
			bFile.flush();
			Long td2 = System.nanoTime()-t3;
			System.out.println("Time with decorated write() method: " + td2);
		}catch(IOException e) {
			System.out.println("IO Exception");
		}

	}

}
