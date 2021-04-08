package by.bakhar.task2.entity;

import java.time.Year;
import java.util.Objects;

public class TraditionalBank extends Bank {
    private int countOfBranch;

    public TraditionalBank(String id, String name, String country, String depositor, double amountOnDeposit, int profitability, Year timeConstraint, DepositType depositType, int countOfBranch) {
        super(id, name, country, depositor, amountOnDeposit, profitability, timeConstraint, depositType);
        this.countOfBranch = countOfBranch;
    }

    public TraditionalBank() {
    }

    public int getCountOfBranch() {
        return countOfBranch;
    }

    public void setCountOfBranch(int countOfBranch) {
        this.countOfBranch = countOfBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TraditionalBank)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TraditionalBank that = (TraditionalBank) o;
        return countOfBranch == that.countOfBranch;
    }

    @Override
    public String toString() {
        return "TraditionalBank " + super.toString() +
                ", countOfBranch= " + countOfBranch;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += (13 * countOfBranch) % 101;
        return result;
    }
}
