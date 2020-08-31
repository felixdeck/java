package StudentenDB;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class StudentServer {
	final int PORT = 4242;
	public void run() {	
		try(ServerSocket serverSocket = new ServerSocket(PORT)){	/* 1. Erstelle ServerSocketObjekt auf dem auf neue 
																	Anfragen gehorcht werden soll. */
			while(true) {
			(new ConnectionHandler(serverSocket.accept())).start();	/* 2. Wenn neue Clientanfrage auftaucht, 
			allokiere neuen Speicher für ConnectionHandler Objekt. mit start() wird dessen run()-Methode ausgeführt
			*/
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
			

	void handleConnection(Socket client) {	

	}
	
	public static Long currentTime() {
		long timeToAdd = (long)2208988800.;
		return System.currentTimeMillis()/1000+timeToAdd;
	}
	
	public static void main(String[] args) {
		(new StudentServer()).run();
	}
}