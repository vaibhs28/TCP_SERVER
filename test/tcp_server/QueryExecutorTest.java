package tcp_server;

import java.util.Arrays;
import java.util.List;

import model.Response;

import org.junit.Assert;
import org.junit.Test;

import query.QueryExecutor;

public class QueryExecutorTest {

	private static List<String> invalidQueries = Arrays.asList(
			"select",
			"select name, id", "select name, id from",
			"select name, id from actors where age",
			"select name, id from actors where age > ",
			"select name, id from act where age > 40"
			);

	private static List<String> validQueries = Arrays.asList(
			"select name, id from actors where age > 40",
			"select name, id from actors where id = 4",
			"select * from actors",
			"select * from students",
			"select name from actors",
			"select id,name,age from actors"
			);

	@Test
	public void testWithInvalidQueries() {
		for (String q : invalidQueries) {
			Response r = executeQuery(q);
			System.out.println("Input query: " + q);
			Assert.assertEquals(false, r.isSuccess());
			System.out.println(r.getMessage());
		}
	}
	
	@Test
	public void testWithValidQueries() throws Exception {
		for (String q : validQueries) {
			Response r = executeQuery(q);
			System.out.println("Input query: " + q);
			Assert.assertEquals(true, r.isSuccess());
			System.out.println(r.getTable());
		}
	}

	private Response executeQuery(String query) {
		return new QueryExecutor(query).execute();
	}

}
