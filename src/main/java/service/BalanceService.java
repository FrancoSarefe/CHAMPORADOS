package service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import entity.BalanceEntity;
import exception.DataAccessException;
import exception.ServiceException;
import repository.BalanceRepository;

public class BalanceService {
    private BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<BalanceEntity> getBalanceList() {
        try {
            return balanceRepository.findAll();
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }

    }
    
    public boolean insertBalance(String walletNumber, BigDecimal amount, String userNumber) {
    	try {
            return balanceRepository.insertBalance(walletNumber, amount, userNumber);
        } catch (DataAccessException e) {
            throw ServiceException.instance(e.getMessage());
        }
    }

}
