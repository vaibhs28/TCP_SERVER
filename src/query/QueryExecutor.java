package query;

import model.QueryMetaData;
import model.Response;

public class QueryExecutor {

	private String query;
	
	public QueryExecutor(String q){
		query = q;
	}
	
	public Response execute(){
		QueryMetaData metaData = parseQuery();
		return null;
	}
	
	private QueryMetaData parseQuery() {
		return null;
	}
}
