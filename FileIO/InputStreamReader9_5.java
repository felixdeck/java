package FileIO;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamReader9_5 {

	public static void main(String[] args) {
		try(InputStream inStream = new FileInputStream("\\C:\\Users\\deckenf\\Documents\\Studium\\Semester 5\\"
				+ "JAVA für C++ Entwickler\\example.txt")){
			try(Reader inputStreamReader = new InputStreamReader(inStream,"utf-8")){
				//char[] cbuf = null;
				int retval = inputStreamReader.read();
				while(retval != -1) {
					char c = (char)retval;
					System.out.println(c);
					retval = inputStreamReader.read();
				}
				
			}
			catch(IOException e) {
				System.out.println("IO Exception in creating StreamReader Object");
			}
		}
		catch(IOException e) {
			System.out.println("IOException in creating InputStream File");
		}
	}
}
