package model;

public class EqualTo implements Predicate {

	private String col;
	private String value;

	public EqualTo(String col, String value) {
		this.col = col;
		this.value = value;
	}

	@Override
	public boolean evaluate(Table table, int rowNum) {
		return table.getValue(col, rowNum).equals(value);
	}

	
}
