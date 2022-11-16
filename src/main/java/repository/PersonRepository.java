package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.PersonEntity;
import exception.DataAccessException;
import jdbc.JdbcConnectionManager;

public class PersonRepository {
	
    private final static String PERSON_FIND_ALL = "SELECT * FROM Person";
    private static final String INSERT_PERSON = "INSERT INTO Person(person_number, first_name, middle_name, last_name, birth_date, contact_number, company_email) VALUES (?,?,?,?,?,?,?)";

    public List<PersonEntity> findAll() {
        try {
        	final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();

            final PreparedStatement findAllQuery = connection.prepareStatement(PERSON_FIND_ALL);

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

    public boolean insertPerson(String personNumber, String firstName, String middleName, String lastName, Date birthDate, String contactNumber, String companyEmail) {
		try {
			final Connection connection = JdbcConnectionManager.instance().initiate().getConnection();

            final PreparedStatement insertQuery = connection.prepareStatement(INSERT_PERSON);
            
			insertQuery.setString(1, personNumber);
			insertQuery.setString(2, firstName);
			insertQuery.setString(3, middleName);
			insertQuery.setString(4, lastName);
			insertQuery.setDate(5, (java.sql.Date) birthDate);
			insertQuery.setString(6, contactNumber);
			insertQuery.setString(7, companyEmail);

			insertQuery.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_insert_user: " + e.getMessage());
			
		}

	}
   
}
