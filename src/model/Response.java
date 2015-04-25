package model;

public class Response {

	private boolean isSuccess;

	private String message;

	private Table table;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	@Override
	public String toString() {
		return "Response [isSuccess=" + isSuccess + ", message=" + message
				+ ", table=" + table + "]";
	}

}
