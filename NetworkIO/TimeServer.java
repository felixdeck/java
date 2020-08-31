package NetworkIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeServer {
	
	public void run() {
		final int PORT = 37;
		try(Socket s = new ServerSocket(PORT).accept()){
			OutputStream out = s.getOutputStream();
			out.write((int)currentTime());
		}
		catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	long currentTime() {
		long timeToAdd = (long)2208988800.;
		return System.currentTimeMillis()/1000+timeToAdd;
	}
	
	public static void main(String[] args) {
		(new TimeServer()).run();
	}
}
