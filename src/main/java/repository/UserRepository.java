package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.UserEntity;
import exception.UserException;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class UserRepository {
	
    private final static String USER_FIND_ALL = "SELECT * FROM CHAMP_User";
    private final static String USER_FIND_EMAIL = "SELECT company_email FROM CHAMP_User WHERE company_email = ?";
    private static final String INSERT_USER = "INSERT INTO CHAMP_User(user_number, company_email, password, date_created, is_admin, person_number) VALUES (?,?,?,?,?,?)";
    
    private Connection connection;
    private PreparedStatement query;
    private ResultSet resultSet;
    
    public UserRepository(Connection connection) {
    	this.connection = connection;
    }

    public List<UserEntity> findAll() {
        try {
            query = connection.prepareStatement(USER_FIND_ALL);

            resultSet = query.executeQuery();
            final List<UserEntity> users = new ArrayList<>();
            while (resultSet.next()) {
                UserEntity user = new UserEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getBoolean(5), resultSet.getString(6));
                users.add(user);
            }

            return users;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_users: " + e.getMessage());
        }
    }
    
    public boolean findEmail(String companyEmail) {
    	try {
            query = connection.prepareStatement(USER_FIND_EMAIL);
            query.setString(1, companyEmail);

            resultSet = query.executeQuery();
            if (resultSet.next()) {
                return true;
            }

            return false;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_users: " + e.getMessage());
        }
    }

    public boolean insertUser(String userNumber, String companyEmail, String password, Date dateCreated, Boolean isAdmin, String personNumber) {
		try {
            query = connection.prepareStatement(INSERT_USER);
            
			query.setString(1, userNumber);
			query.setString(2, companyEmail);
			query.setString(3, password);
			query.setString(4, dateCreated.toString());
			query.setString(5, isAdmin.toString());
			query.setString(6, personNumber);

			query.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_insert_user: " + e.getMessage());
			
		}

	}
}
