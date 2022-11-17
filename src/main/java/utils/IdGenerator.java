package utils;

public class IdGenerator {
	private static final String USER_LAST_ROW = "SELECT * FROM CHAMP_User ORDER BY ID DESC LIMIT 1";
	private static final String PERSON_LAST_ROW = "SELECT * FROM Person ORDER BY ID DESC LIMIT 1";
	private static final String BALANCE_LAST_ROW = "SELECT * FROM Balance ORDER BY ID DESC LIMIT 1";
}
