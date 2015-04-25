package model;

public class LessThan implements Predicate {

	private String col;
	private String value;

	public LessThan(String col, String value) {
		this.col = col;
		this.value = value;
	}

	@Override
	public boolean evaluate(Table table, int rowNum) {
		return Integer.parseInt(table.getValue(col, rowNum)) < Integer
				.parseInt(value);
	}

}
