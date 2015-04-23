package request;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class RequestHandler implements Runnable {

	private Socket client;

	private StringBuffer buff;

	public RequestHandler(Socket server) {
		this.client = server;
	}

	@SuppressWarnings("deprecation")
	public void run() {

		try {
			DataInputStream clientInput = new DataInputStream(
					client.getInputStream());
			PrintStream clientOutput = new PrintStream(client.getOutputStream());
			while (true) {
				String line = "";
				buff = new StringBuffer();
				while ((line = clientInput.readLine()) != null
						&& !line.equalsIgnoreCase("stop")) {
					buff.append(line);
					if (line.endsWith(";"))
						break;
				}
				if (line.equalsIgnoreCase("stop")) {
					break;
				}
				System.out.println("Server Console : Query " + buff.toString());
				clientOutput.println("Query :" + buff.toString());
			}
			client.close();
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

	
}
