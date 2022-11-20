package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.PersonEntity;
import exception.DataAccessException;

public class PersonRepository {
	
    private final static String PERSON_FIND_ALL = "SELECT person_number, first_name, middle_name, last_name, birth_date, contact_number FROM Person";
    private final static String PERSON_FIND_NUMBER = PERSON_FIND_ALL + " WHERE person_number = ?";
    private static final String INSERT_PERSON = "INSERT INTO Person(person_number, first_name, middle_name, last_name, birth_date, contact_number) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE_PERSON = "UPDATE Person SET first_name = ?, middle_name = ?, last_name = ?, birth_date = ?, contact_number = ? WHERE person_number = ?";
    private static final String DELETE_PERSON = "DELETE FROM Person WHERE person_number = ?";
    
    private Connection connection;
    private PreparedStatement query;
    private ResultSet resultSet;
    
    public PersonRepository(Connection connection) {
    	this.connection = connection;
    }

    public List<PersonEntity> findAll() {
        try {
            query = connection.prepareStatement(PERSON_FIND_ALL);

            resultSet = query.executeQuery();
            final List<PersonEntity> persons = new ArrayList<>();
            while (resultSet.next()) {
                PersonEntity person = new PersonEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                persons.add(person);
            }

            return persons;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_persons: " + e.getMessage());
        }
    }
    
    public PersonEntity findByPersonNumber(String personNumber) {
        try {
            query = connection.prepareStatement(PERSON_FIND_NUMBER);
            query.setString(1, personNumber);

            resultSet = query.executeQuery();
            
            PersonEntity personEntity = null;
            if (resultSet.next()) {
                personEntity = new PersonEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            }

            return personEntity;
        } catch (Exception e) {
            throw DataAccessException.instance("failed_to_retrieve_person: " + e.getMessage());
        }
    }

    public boolean insertPerson(String personNumber, String firstName, String middleName, String lastName, String birthDate, String contactNumber) {
		try {
            query = connection.prepareStatement(INSERT_PERSON);
            
			query.setString(1, personNumber);
			query.setString(2, firstName);
			query.setString(3, middleName);
			query.setString(4, lastName);
			query.setString(5, birthDate);
			query.setString(6, contactNumber);

			query.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_insert_person: " + e.getMessage());
			
		}

	}
    
    public boolean updatePerson(String personNumber, String firstName, String middleName, String lastName, String birthDate, String contactNumber) {
		try {
            query = connection.prepareStatement(UPDATE_PERSON);
            
			query.setString(1, firstName);
			query.setString(2, middleName);
			query.setString(3, lastName);
			query.setString(4, birthDate);
			query.setString(5, contactNumber);
			query.setString(6, personNumber);

			query.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_update_person: " + e.getMessage());
			
		}

	}
    
    public boolean deletePerson(String personNumber) {
		try {
            query = connection.prepareStatement(DELETE_PERSON);
			query.setString(1, personNumber);

			query.executeUpdate();
			
			return true;
            
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_delete_person: " + e.getMessage());
			
		}

	}
   
}
