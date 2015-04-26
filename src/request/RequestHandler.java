package request;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import model.Response;
import model.Table;
import query.QueryExecutor;

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
				String query = "";
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
				query = buff.toString().substring(0, buff.length() - 1);
				QueryExecutor queryExecutor = new QueryExecutor(query);
				Response response = queryExecutor.execute();
				if (response.isSuccess()) {
					writeOutputTable(clientOutput, response.getTable());
				}
				else{
					clientOutput.println(response.getMessage() + "\n");
				}
			}
			client.close();
		} catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}

	private void writeOutputTable(PrintStream clientOutput, Table table) {
		if(table.getRowCount() == 0){
			clientOutput.println("No record found");
			return;
		}
		StringBuffer colHeader = new StringBuffer();
		StringBuffer formattedLine = new StringBuffer();
		for (String col : table.getColumnHeaders()) {
			colHeader.append("\t" + col + " | ");
		}
		for (int i = 0; i < colHeader.length(); i++) {
			formattedLine.append(" - ");
		}
		clientOutput.println(colHeader.toString());
		clientOutput.println(formattedLine.toString());

		for (int i = 0; i < table.getRowCount(); i++) {
			StringBuffer row = new StringBuffer();
			for (String col : table.getColumnHeaders()) {
				row.append("\t" + table.getValue(col, i) + " | ");
			}
			clientOutput.println(row.toString());
		}
	}

}
