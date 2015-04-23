package tcpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import request.RequestHandler;

public class TCPServer {

	private static int port = 6543;
	private static ServerSocket listener;

	public static void startServer() {
		try {
			listener = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("Error while starting server : " + e);
			e.printStackTrace();
			return;
		}
		Socket clientSocket;
		while (true) {
			try {
				clientSocket = listener.accept();
			} catch (IOException e) {
				System.out.println("Error while accepting new connection : "
						+ e);
				e.printStackTrace();
				return;
			}
			RequestHandler request = new RequestHandler(clientSocket);
			new Thread(request).start();
		}
	}

	public static void main(String[] args) {
		TCPServer.startServer();
	}
}
