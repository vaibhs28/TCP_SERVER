package model;

public class NotEqualTo implements Predicate {

	private EqualTo equalTo;

	public NotEqualTo(String col, String value) {
		equalTo = new EqualTo(col, value);
	}

	@Override
	public boolean evaluate(Table table, int rowNum) {
		return !equalTo.evaluate(table, rowNum);
	}

}
