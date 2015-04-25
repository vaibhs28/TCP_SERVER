package model;

import java.util.List;

public class Row {

	private List<String> values;

	public Row(List<String> rowValues) {
		setValues(rowValues);
	}
	
	public String getValue(int colIndex){
		return values.get(colIndex);
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> rowValues) {
		this.values = rowValues;
	}

	@Override
	public String toString() {
		return "Row [values=" + values + "]\n";
	}

	
}
