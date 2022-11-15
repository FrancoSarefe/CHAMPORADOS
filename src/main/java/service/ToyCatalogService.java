package service;

import java.util.List;

import entity.ToyEntity;
import exception.DataAccessException;
import exception.ServiceException;
import repository.ToyRepository;

public class ToyCatalogService {
    private ToyRepository toyRepository;

    public ToyCatalogService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public List<ToyEntity> getToyCatalog() {
        try {
            return toyRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

}
