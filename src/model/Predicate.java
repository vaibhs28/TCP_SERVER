package model;

public interface Predicate {

	boolean evaluate(Table table, int rowNum);
}
