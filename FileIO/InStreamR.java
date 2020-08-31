package FileIO;

import java.io.FileInputStream;
import java.io.IOException;

public class InStreamR {
	public static byte[] b;
	public static StringBuffer buff = new StringBuffer();
	public static void main(String[] args) {
		try(FileInputStream fin = new FileInputStream("C:\\Users\\deckenf\\eclipse-workspace-java\\FileIO\\web.html")){
			char len;
			System.out.println("Total Filesize:" + fin.available());
			while((len = (char)fin.read(b))!=-1) {
				System.out.print(len);
				
			}
		}
		catch(IOException e){
			System.out.println("IOE");
		}
		
		String strBuff = buff.toString();
		System.out.println(strBuff);		
		}
}

