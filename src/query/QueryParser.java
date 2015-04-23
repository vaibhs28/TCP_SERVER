package query;

import java.util.ArrayList;
import java.util.List;

import exception.InvalidSyntaxException;
import model.QueryMetaData;

// select name, id from actors where age > 40; 
public class QueryParser {

	private String query;

	public QueryParser(String q) {
		query = q;
	}

	public QueryMetaData parse() throws InvalidSyntaxException {
		String[] tokens = query.split(" ");

		removeBlankToken(tokens);
		if (tokens[0] != "select") {
			throw new InvalidSyntaxException("Invalid syntax : missing select statement");
		}

		return null; 
	}

	private String[] removeBlankToken(String[] split) {
		List<String> tokens = new ArrayList<String>();
		for (String t : split) {
			if (t.equals(" ") || t.isEmpty()) 
				continue;
			tokens.add(t);
		}
		return tokens.toArray(new String[0]);
	}

	public static void main(String[] args) {
		try {
			new QueryParser("abc,    bcd from  table").parse();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
	}
}
