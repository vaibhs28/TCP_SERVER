package model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private List<String> columnHeaders;

	private List<Row> rows = new ArrayList<Row>();

	public Table(List<String> colHeaders) {
		columnHeaders = colHeaders;
	}

	public void addRow(Row row) {
		rows.add(row);
	}

	public List<String> getColumnHeaders() {
		return columnHeaders;
	}

	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

	@Override
	public String toString() {
		return "Table [columnHeaders=" + columnHeaders + "\n rows=" + rows
				+ "]";
	}

}
