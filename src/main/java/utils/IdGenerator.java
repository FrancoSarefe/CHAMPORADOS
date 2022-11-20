package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdGenerator {
	private static final String USER_LAST_ROW = "SELECT user_number FROM CHAMP_User WHERE id = (SELECT MAX(id) FROM CHAMP_User)";
	private static final String PERSON_LAST_ROW = "SELECT person_number FROM Person WHERE id = (SELECT MAX(id) FROM Person)";
	private static final String BALANCE_LAST_ROW = "SELECT wallet_number FROM Balance WHERE id = (SELECT MAX(id) FROM Balance)";
	private static final String PRODUCT_LAST_ROW = "SELECT product_number FROM Product WHERE id = (SELECT MAX(id) FROM Product)";
	private static final String CART_ITEM_LAST_ROW = "SELECT cart_item_number FROM Cart_Item WHERE id = (SELECT MAX(id) FROM Cart_Item)";
	private static final String TRANSACTION_LAST_ROW = "SELECT transaction_number FROM Transaction WHERE id = (SELECT MAX(id) FROM Transaction)";
	
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
				
			} else if(table.equals("Product")) {
				stringBuilder.append("PRD-");
				query = connection.prepareStatement(PRODUCT_LAST_ROW);
				
			} else if(table.equals("Cart_Item")) {
				stringBuilder.append("CRT-");
				query = connection.prepareStatement(CART_ITEM_LAST_ROW);
				
			} else if(table.equals("Transaction")) {
				stringBuilder.append("TRN-");
				query = connection.prepareStatement(TRANSACTION_LAST_ROW);
				
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
