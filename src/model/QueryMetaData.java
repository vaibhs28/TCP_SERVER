package model;

import java.util.List;

public class QueryMetaData {

	private List<String> selectColumns;

	private List<String> requiredColumns;

	private String tableName;

	private List<Predicate> conditions;
	
	private boolean selectAll;

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

	public List<String> getRequiredColumns() {
		return requiredColumns;
	}

	public void setRequiredColumns(List<String> requiredColumns) {
		this.requiredColumns = requiredColumns;
	}

	@Override
	public String toString() {
		return "QueryMetaData [selectColumns=" + selectColumns
				+ ", requiredColumns=" + requiredColumns + ", tableName="
				+ tableName + ", conditions=" + conditions + "]";
	}

	/**
	 * @return the selectAll
	 */
	public boolean isSelectAll() {
		return selectAll;
	}

	/**
	 * @param selectAll the selectAll to set
	 */
	public void setSelectAll(boolean selectAll) {
		this.selectAll = selectAll;
	}

}
