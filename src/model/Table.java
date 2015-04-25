package model;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private List<String> columnHeaders;

	private List<Row> rows = new ArrayList<Row>();

	private int rowCount = 0;

	public Table(List<String> colHeaders) {
		columnHeaders = colHeaders;
	}

	public void addRow(Row row) {
		rows.add(row);
		rowCount++;
	}

	public String getValue(String colName, int rowNum) {
		int colIndex = columnHeaders.indexOf(colName);
		return rows.get(rowNum).getValue(colIndex);
	}

	public List<String> getColumnHeaders() {
		return columnHeaders;
	}

	public void setColumnHeaders(List<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}

	@Override
	public String toString() {
		return "Table [columnHeaders=" + columnHeaders + "\nrows=" + rows
				+ ", rowCount=" + rowCount + "]";
	}

	public int getRowCount() {
		return rowCount;
	}

}
