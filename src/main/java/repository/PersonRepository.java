package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.PersonEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class PersonRepository {
	
    private final static String TOY_FIND_ALL = "SELECT * FROM Person";
 

    private JdbcConnectionManager jdbcConnectionManager;

    public PersonRepository(JdbcConnectionManager jdbcConnectionManager) {
        this.jdbcConnectionManager = jdbcConnectionManager;
    }

    public List<PersonEntity> findAll() {
        try {
            final Connection connection = jdbcConnectionManager.getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(TOY_FIND_ALL);

            final ResultSet resultSet = findAllQuery.executeQuery();
            final List<PersonEntity> persons = new ArrayList<>();
            while (resultSet.next()) {
                PersonEntity person = new PersonEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7));
                persons.add(person);
            }

            return persons;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_persons: " + e.getMessage());
        }
    }

   
}
