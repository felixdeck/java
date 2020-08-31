package StudentenDB;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ConnectionHandler extends Thread{
	
	static public enum COMMAND {QUIT, DUMP, DUMP_LASTNAME, FIND, INSERT}
	private Socket clientSocket;
	final private String CRNL = "\r\n";
	
	/**
	 * Initialisierung des client Attributes mit übergebenem Client-Socket. 
	 * Der Client-Socktet wird benötigt, da in der run-Methode der Server Daten an diesen Socket sendet.
	 * @param client
	 */
	public ConnectionHandler(Socket client) {
		clientSocket = client;
	}
	/** 4. Wenn der Threaded Server eine neue Verbindung aufgebaut hat, wird die run Methode ausgeführt */
	@Override
	public void run() {
		
		try(Reader reader = new InputStreamReader(clientSocket.getInputStream(), "ASCII")) {	
			OutputStream out = clientSocket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "ASCII");
			writer.write("Hello!\r\n");
			writer.flush();
			while(true) {
				readClientData(reader, writer);
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
	
	private void readClientData(Reader reader, Writer writer) {
		char[] cbuf = null;
		COMMAND cmd;
		try{
			if(reader.read(cbuf) != -1) {
				String sbuf = cbuf.toString();
				cmd = getCommand(sbuf);
				switch(cmd) {
				case QUIT:
					writer.write("Bye!\r\n");
					writer.flush();
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	private COMMAND getCommand(String commandLineString) {
		if(commandLineString.contains("QUIT")){
			return COMMAND.QUIT;
		}
		else if(commandLineString.contains("DUMP")) {
			return COMMAND.DUMP;
		}
		else if(commandLineString.contains("DUMP/")) {
			return COMMAND.DUMP_LASTNAME;
		}
		else if(commandLineString.contains("FIND")) {
			return COMMAND.FIND;
		}
		else if(commandLineString.contains("INSERT")) {
			return COMMAND.INSERT;
		}
		else {
			return COMMAND.QUIT;
		}
	}
	public static void main(String[] args) {

	}

}
