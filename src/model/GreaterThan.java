package model;

public class GreaterThan implements Predicate {

	private String col;
	private String value;

	public GreaterThan(String col, String value) {
		this.col = col;
		this.value = value;
	}

	@Override
	public boolean evaluate(Table table, int rowNum) {
		return Integer.parseInt(table.getValue(col, rowNum)) > Integer
				.parseInt(value);
	}

}
