package NetworkIO;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionHandler extends Thread{
	private Socket clientSocket;
	
	public ConnectionHandler(Socket client) {
		clientSocket = client;
	}
	
	/**
	 * Verscuht einen neuen 
	 */
	@Override
	public void run() {
		
		try(Reader reader = new InputStreamReader(clientSocket.getInputStream(), "ASCII")) {
			OutputStream out = clientSocket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "ASCII");
			while(true) {
				writer.write("HEllo"+"\r\n");
				writer.flush();
//				if(reader.ready()) {
//					break;
//				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

		catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

	}

}
