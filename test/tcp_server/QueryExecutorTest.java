package tcp_server;

import java.util.Arrays;
import java.util.List;

import model.Response;

import org.junit.Test;

import query.QueryExecutor;

public class QueryExecutorTest {

	private static List<String> queries = Arrays.asList(
			"select",
			"select name, id", "select name, id from",
			"select name, id from actors where age",
			"select name, id from actors where age > ",
			"select name, id from actors where age > 40",
			"select name, id from actors where id = 4",
			"select * from actors",
			"select * from students",
			"select name from actors",
			"select id,name,age from actors"
			);

	@Test
	public void testExecuteQuery() throws Exception {
		for (String q : queries) {
			Response r = executeQuery(q);
			System.out.println("Input query: " + q);
			if (r.isSuccess()) {
				System.out.println(r.getTable());
			} else {
				System.out.println(r.getMessage());
			}
		}
	}

	private Response executeQuery(String query) {
		return new QueryExecutor(query).execute();
	}

	// public static void main(String[] args) {
	// try {
	// new QueryExecutorTest().testExecuteQuery();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
