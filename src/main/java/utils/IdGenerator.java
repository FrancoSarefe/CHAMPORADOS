package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenerator {
	private static final String USER_LAST_ROW = "SELECT user_number FROM CHAMP_User WHERE id = (SELECT MAX(id) FROM CHAMP_User)";
	private static final String PERSON_LAST_ROW = "SELECT person_number FROM Person WHERE id = (SELECT MAX(id) FROM Person)";
	private static final String BALANCE_LAST_ROW = "SELECT wallet_number FROM Balance WHERE id = (SELECT MAX(id) FROM Balance)";
	
	private Connection connection;
    
    public IdGenerator(Connection connection) {
    	this.connection = connection;
    }
	
	public String generateId(String table) {
		StringBuilder stringBuilder = new StringBuilder();
		PreparedStatement query = null;
		String lastRowId = null;
		
		try{
			if(table.equals("User")) {
				stringBuilder.append("USR-");
				query = connection.prepareStatement(USER_LAST_ROW);
	            
			} else if(table.equals("Person")) {
				stringBuilder.append("PER-");
				query = connection.prepareStatement(PERSON_LAST_ROW);
				
			} else if(table.equals("Balance")) {
				stringBuilder.append("WAL-");
				query = connection.prepareStatement(BALANCE_LAST_ROW);
				
			}
			
			Integer lastIdPlusOne = null;
			
			final ResultSet resultSet = query.executeQuery();
            if (resultSet.next()) {
            	lastRowId = resultSet.getString(1);
            	lastIdPlusOne = Integer.parseInt(lastRowId.split("-")[1]) + 1;
            	
            } else {
            	lastIdPlusOne = 1;
            	
            }
            
            stringBuilder.append(lastIdPlusOne.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stringBuilder.toString();
	}
}
