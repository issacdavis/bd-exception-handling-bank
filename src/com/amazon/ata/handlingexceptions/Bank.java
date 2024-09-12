package com.amazon.ata.handlingexceptions;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.amazon.ata.handlingexceptions.exceptions.InvalidInputException;
import com.amazon.ata.handlingexceptions.exceptions.TransactionException;
import com.amazon.ata.handlingexceptions.exceptions.InsufficientFundsException;

/**
 * This class represents a bank, which includes the functionality to transfer from
 * one BankAccount to another.
 */
public class Bank {
    private Logger log = LogManager.getLogger(Bank.class);

    /**
     * Transfer money from one account to another. 
     * 
     * @param fromAccount BankAccount to withdraw amount from
     * @param toAccount BankAccount to deposit amount into
     * @param amount of money to transfer.
     * @return true if transfer was successful, false if transfer fails due to insufficient funds
     */
    public boolean transfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) throws InvalidInputException, TransactionException {
        // TODO: implement
        try {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            return true;
        } catch (InvalidInputException e) {
            System.out.println(amount + " is an Invalid Input");
            throw e;
        } catch (TransactionException e) {
            if (amount.compareTo(fromAccount.getBalance()) > 0) {
                return false;
            }
        }
        return true;
    }
}
