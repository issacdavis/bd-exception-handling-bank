package com.amazon.ata.handlingexceptions;

import java.math.BigDecimal;

import com.amazon.ata.handlingexceptions.exceptions.InsufficientFundsException;
import com.amazon.ata.handlingexceptions.exceptions.InvalidInputException;

/**
 * This class represents a checking bank account, which includes methods that 
 * allow money to be deposited or withdrawn from the account.
 */
public class CheckingAccount implements BankAccount {
    
    /**
     * Identification number associated with the account
     */
    private String accountId;
    
    /**
     * Amount of money in the account.
     */
    private BigDecimal balance;
    
    /*
     * Validator helper class for validating input.
     */
    private Validator validator = new Validator();

    public CheckingAccount(String accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    /**
     * Deposit amount to account.
     * 
     * @param amount of money to deposit
     * @return value of account after the deposit
     */
    @Override
    public BigDecimal deposit(BigDecimal amount) throws InvalidInputException{
        // TODO: Implement
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException("Invalid input");
        }
        this.balance = balance.add(amount);
        return this.balance;
    }

    /**
     * Withdraw amount from account.
     * 
     * @param amount of money to withdraw
     * @return value of account after the withdraw
     * @throws InsufficientFundsException if account does not have enough funds to withdraw amount
     */
    @Override
    public BigDecimal withdraw(BigDecimal amount) throws InsufficientFundsException, InvalidInputException {
        // TODO: implement
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidInputException("Does not exists");
        }
        if (amount.compareTo(this.balance) > 0) {
            throw new InsufficientFundsException("Insufficient Funds");
        }
        this.balance = balance.subtract(amount);
        return this.balance;
    }

    @Override
    public BigDecimal getBalance() {
        // TODO: implement
        return this.balance;
    }
}
