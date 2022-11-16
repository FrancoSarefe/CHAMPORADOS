package service;

import java.util.List;

import entity.BalanceEntity;
import exception.DataAccessException;
import exception.ServiceException;
import repository.BalanceRepository;

public class PersonService {
    private BalanceRepository balanceRepository;

    public PersonService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<BalanceEntity> getBalanceCatalog() {
        try {
            return balanceRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }

}
