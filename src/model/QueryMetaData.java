package model;

import java.util.List;

public class QueryMetaData {

	private List<String> selectColumns;
	
	private String tableName;

	private List<Predicate> conditions;

	public List<String> getSelectColumns() {
		return selectColumns;
	}

	public void setSelectColumns(List<String> selectColumns) {
		this.selectColumns = selectColumns;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Predicate> getConditions() {
		return conditions;
	}

	public void setConditions(List<Predicate> conditions) {
		this.conditions = conditions;
	}

}
