package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.UserEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class UserRepository {
	
    private final static String TOY_FIND_ALL = "SELECT * FROM CHAMP_User";
 

    private JdbcConnectionManager jdbcConnectionManager;

    public UserRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<UserEntity> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<UserEntity> users = new ArrayList<>();
            while (resultSet.next()) {
                UserEntity user = new UserEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getBoolean(4), resultSet.getString(5), resultSet.getString(6));
                users.add(user);
            }

            return users;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_users: " + e.getMessage());
        }
    }

   
}
