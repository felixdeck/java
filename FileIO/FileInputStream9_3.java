package FileIO;

import java.io.BufferedInputStream;
import java.io.IOException;


public class FileInputStream9_3 {
	public static void main(String[] args) {
		try(BufferedInputStream in = new BufferedInputStream(System.in)){
			while(true) {
			Integer readData = in.read();
			Integer readDataBefore = readData;
			while(readData!=-1) {
				if(readData.equals(readDataBefore)) {
					//System.out.println(String.valueOf(Character.toChars(readData)));
					System.out.println(readData);
				}
				break;
			}
			
			}
		}
		catch(IOException e) {
			System.out.println("IOE");
		}
		finally {
			System.out.println("ENDE");
		}
				
	}		
}

