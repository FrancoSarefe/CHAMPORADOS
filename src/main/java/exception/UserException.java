package exception;

public class UserException extends Exception{
	

	private static final long serialVersionUID = -2397012533045245997L;
	public static final String ERROR_FIND_ID="Exception occcured while finding Account via ID";
	public static final String ERROR_FIND_NAME="Exception occcured while finding Account via Name";
	public static final String ERROR_INSERT_ACCOUNT="Exception occured while inserting new Account";
	
	public UserException(String message, Throwable cause){
		super(message, cause);
	}

}
