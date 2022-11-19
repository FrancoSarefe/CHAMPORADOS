package service;

import java.util.Date;
import java.util.List;

import entity.UserEntity;
import exception.DataAccessException;
import exception.ServiceException;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUserList() {
        try {
            return userRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }
    
    public boolean findEmail(String companyEmail) {
    	try {
            return userRepository.findEmail(companyEmail);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }
    
    public String findEmailAndPassword(String companyEmail, String password) {
    	try {
            return userRepository.findEmailAndPassword(companyEmail, password);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }
    
    public boolean insertUser(String userNumber, String companyEmail, String password, Date dateCreated, Boolean isAdmin, String personNumber) {
    	try {
            return userRepository.insertUser(userNumber, companyEmail, password, dateCreated, isAdmin, personNumber);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }

}
