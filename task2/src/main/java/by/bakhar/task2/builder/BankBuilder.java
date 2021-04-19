package by.bakhar.task2.builder;

import by.bakhar.task2.entity.Bank;
import by.bakhar.task2.exception.BankException;

import java.util.HashSet;
import java.util.Set;

public abstract class BankBuilder {
    protected Set<Bank> banks;

    public BankBuilder() {
        banks = new HashSet<>();
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public abstract void buildBanks(String xmlPath) throws BankException;
}
