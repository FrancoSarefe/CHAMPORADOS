package service;

import java.util.Date;
import java.util.List;

import entity.BalanceEntity;
import entity.PersonEntity;
import exception.DataAccessException;
import exception.ServiceException;
import repository.BalanceRepository;
import repository.PersonRepository;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getPersonList() {
        try {
            return personRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
    
    public boolean insertPerson(String personNumber, String firstName, String middleName, String lastName, String birthDate, String contactNumber) {
    	try {
            return personRepository.insertPerson(personNumber, firstName, middleName, lastName, birthDate, contactNumber);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }

}
