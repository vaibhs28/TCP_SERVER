package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Row;
import model.Table;

public class CSVFileReader {

	private String fileName;

	private List<String> columnHeaders;

	private Map<String, Integer> colIndex;

	private Table table;

	public CSVFileReader(String fName, List<String> columns) {
		fileName = fName;
		columnHeaders = columns;
	}

	public Table read() {
		BufferedReader br = null;
		table = new Table(columnHeaders);
		colIndex = new HashMap<String, Integer>();
		try {
			br = new BufferedReader(new FileReader(fileName));
			readHeaders(br);
			readRows(br);
		} catch (FileNotFoundException e) {
			System.out.println("CSV file " + fileName + " not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading file " + fileName);
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Error while closing file");
					e.printStackTrace();
				}
			}
		}
		return table;
	}

	private void readRows(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			List<String> rowValues = new ArrayList<String>();
			for (String string : columnHeaders) {
				rowValues.add(values[colIndex.get(string)]);
			}
			table.addRow(new Row(rowValues));
		}
	}

	private void readHeaders(BufferedReader br) throws IOException {
		String line;
		if ((line = br.readLine()) != null) {
			String[] headers = line.split(",");
			for (int i = 0; i < headers.length; i++) {
				if (columnHeaders.contains(headers[i])) {
					colIndex.put(headers[i], i);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<String> columns = Arrays.asList("id", "name", "age");
		System.out.println(new CSVFileReader("E:\\V\\Workspace\\tcp_server\\csv_files\\actors.csv", columns).read());
	}
}
