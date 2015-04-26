package query;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Predicate;
import model.QueryMetaData;
import model.Response;
import model.Row;
import model.Table;
import reader.CSVFileReader;
import exception.InvalidSyntaxException;

public class QueryExecutor {

	private String query;

	public QueryExecutor(String query) {
		this.query = query;
	}

	public Response execute() {
		Response response = new Response();
		QueryMetaData metaData = null;
		try {
			metaData = new QueryParser(query).parse();
			Table table = new CSVFileReader(getFilePath(metaData.getTableName()
					+ ".csv"), metaData.getRequiredColumns(),
					metaData.isSelectAll()).read();
			Table outputTable = new Table(
					metaData.isSelectAll() ? table.getColumnHeaders()
							: metaData.getSelectColumns());
			for (int i = 0; i < table.getRowCount(); i++) {
				boolean isValidRow = true;
				if (metaData.getConditions() != null) {
					for (Predicate condition : metaData.getConditions()) {
						if (!condition.evaluate(table, i)) {
							isValidRow = false;
						}
					}
				}
				if (isValidRow) {
					List<String> values = new ArrayList<String>();
					for (String col : outputTable.getColumnHeaders()) {
						values.add(table.getValue(col, i));
					}
					outputTable.addRow(new Row(values));
				}
			}
			response.setSuccess(true);
			response.setTable(outputTable);
		} catch (InvalidSyntaxException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		// System.out.println(response.toString());
		return response;
	}

	private String getFilePath(String fileName) throws InvalidSyntaxException {
		URL url = getClass().getResource(fileName);
		if (url != null) {
			File file = new File(url.getPath());
			if (!file.isFile()) {
				throw new InvalidSyntaxException("Invalid file name ");
			}
		} else {
			throw new InvalidSyntaxException("Invalid file name ");
		}
		return url.getPath();
	}

	public static void main(String[] args) {
		new QueryExecutor("select name, id from actors where age > 40")
				.execute();
	}
}
