package NetworkIO;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
	public void run() {
		
		final String HOSTNAME = "localhost";
		final int PORT = 37;
		
		try(InputStream instream = new Socket(HOSTNAME,PORT).getInputStream()){
			long retval = readBytes(instream);
			System.out.println(retval/(365.25*24*3600)+1970);
		}
		catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * reads the Time with time protocol. Returns the time in seconds.
	 * @param in
	 * @return
	 * @throws IOException
	 */
	long readBytes(InputStream in) throws IOException{
		long t = 0;
		
			for(int i = 0; i < 4; i++) {
				t = (t << 8);
				t |= in.read();
			}
			return t;

	}
	
	public static void main(String[] args) {
		(new TimeClient()).run();
	}

}
