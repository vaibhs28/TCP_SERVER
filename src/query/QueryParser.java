package query;

import java.util.ArrayList;
import java.util.List;

import model.QueryMetaData;

// select name, id from actors where age > 40; 
public class QueryParser {

	private String query;

	public QueryParser(String q) {
		query = q;
	}

	public QueryMetaData parse() {
		String[] tokens = query.split(" ");

		removeBlankToken(tokens);
		if (tokens[0] != "select") {
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
		return (String[]) tokens.toArray();
	}

	public static void main(String[] args) {
		new QueryParser("select abc,    bcd from  table").parse();
	}
}
