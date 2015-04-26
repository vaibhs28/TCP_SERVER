package query;

import java.util.ArrayList;
import java.util.List;

import model.EqualTo;
import model.GreaterThan;
import model.LessThan;
import model.NotEqualTo;
import model.Predicate;
import model.QueryMetaData;
import exception.InvalidSyntaxException;

// select name, id from actors where age > 40; 
public class QueryParser {

	private String query;

	public QueryParser(String q) {
		query = q;
	}

	public QueryMetaData parse() throws InvalidSyntaxException {
		QueryMetaData qData = new QueryMetaData();
		List<String> select = new ArrayList<String>();
		List<String> selectRequired = new ArrayList<String>();
		qData.setSelectColumns(select);
		qData.setRequiredColumns(selectRequired);
		boolean isValid = false;
		String[] tokens = query.split(" ");
		int i = 0;
		removeBlankToken(tokens);
		// printTokens(tokens);
		if (!tokens[i++].equals("select")) {
			throw new InvalidSyntaxException(
					"Invalid syntax : missing select statement");
		}

		while (i < tokens.length) {
			if (tokens[i].equalsIgnoreCase("from")) {
				isValid = true;
				i++;
				if (i >= tokens.length) {
					throw new InvalidSyntaxException(
							"Invalid syntax : missing table name");
				}
				qData.setTableName(tokens[i++]);
				if (i >= (tokens.length)) {
					break;
				} else if (!tokens[i++].equalsIgnoreCase("where")) {
					throw new InvalidSyntaxException(
							"Invalid syntax : missing where statement");
				} else {
					
					if ((tokens.length - i) != 3) {
						throw new InvalidSyntaxException("Invalid condition ");
					} else {
						selectRequired.add(tokens[i]);
						qData.setConditions(createCondition(tokens, i));
						break;
					}
				}
			} else {
				if (tokens[i].equals("*")) {
					qData.setSelectAll(true);
					i++;
				} else if (tokens[i].contains(",") && i < tokens.length) {
					select.addAll(removeBlankTokens(tokens[i++].split(",")));
				} else {
					select.add(tokens[i++]);
				}
			}
		}
		selectRequired.addAll(select);
		if (!isValid) {
			throw new InvalidSyntaxException(
					"Invalid syntax : missing from statement");
		}
		return qData;
	}

	private List<Predicate> createCondition(String[] tokens, int i) {
		List<Predicate> conitions = new ArrayList<Predicate>();
		String col, value, op;
		col = tokens[i];
		op = tokens[++i];
		value = tokens[++i];
		if (op.equals("=")) {
			conitions.add(new EqualTo(col, value));
		} else if (op.equals("!=")) {
			conitions.add(new NotEqualTo(col, value));
		} else if (op.equals("<")) {
			conitions.add(new LessThan(col, value));
		} else if (op.equals(">")) {
			conitions.add(new GreaterThan(col, value));
		}
		return conitions;
	}

	private String[] removeBlankToken(String[] split) {
		return removeBlankTokens(split).toArray(new String[0]);
	}

	private List<String> removeBlankTokens(String[] split) {
		List<String> tokens = new ArrayList<String>();
		for (String t : split) {
			if (t.equals(" ") || t.isEmpty())
				continue;
			tokens.add(t);
		}
		return tokens;
	}

	@SuppressWarnings("unused")
	private void printTokens(String[] split) {
		for (String string : split) {
			System.out.print("|" + string);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		try {
			new QueryParser("select name, id from actors where age > 40")
					.parse();
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
	}
}
