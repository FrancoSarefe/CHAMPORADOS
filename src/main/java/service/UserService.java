package service;

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

    public List<UserEntity> getUserCatalog() {
        try {
            return userRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

}
