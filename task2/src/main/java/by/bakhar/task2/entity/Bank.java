package by.bakhar.task2.entity;

import java.time.Year;

public abstract class Bank {
    private String id;
    private String name;
    private String country;
    private String depositor;
    private Double amountOnDeposit;
    private int profitability;
    private Year timeConstraint;
    private DepositType depositType;

    public Bank(String id, String name, String country, String depositor, double amountOnDeposit, int profitability, Year timeConstraint, DepositType depositType) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.depositor = depositor;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.timeConstraint = timeConstraint;
        this.depositType = depositType;
    }

    public Bank() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public double getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(Double amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }

    public int getProfitability() {
        return profitability;
    }

    public void setProfitability(int profitability) {
        this.profitability = profitability;
    }

    public Year getTimeConstraint() {
        return timeConstraint;
    }

    public void setTimeConstraint(Year timeConstraint) {
        this.timeConstraint = timeConstraint;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bank bank = (Bank) o;
        return Double.compare(bank.amountOnDeposit, amountOnDeposit) == 0 && profitability == bank.profitability &&
                id.equals(bank.id) && name.equals(bank.name)
                && country.equals(bank.country) && depositor.equals(bank.depositor)
                && timeConstraint.equals(bank.timeConstraint) &&
                depositType == bank.depositType;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += (13 * id.hashCode()) % 101;
        result += (13 * name.hashCode()) % 101;
        result += (13 * country.hashCode()) % 101;
        result += (13 * depositor.hashCode()) % 101;
        result += (13 * amountOnDeposit.hashCode()) % 101;
        result += (13 * profitability) % 101;
        result += (13 * timeConstraint.hashCode()) % 101;
        result += (13 * depositType.hashCode()) % 101;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("id ").append(id);
        stringBuilder.append(", name ").append(name);
        stringBuilder.append(", country ").append(country);
        stringBuilder.append(", depositor ").append(depositor);
        stringBuilder.append(", amount on deposit ").append(amountOnDeposit);
        stringBuilder.append(", profitability ").append(profitability);
        stringBuilder.append(", time constraint ").append(timeConstraint);
        stringBuilder.append(", deposit type ").append(depositType);
        return stringBuilder.toString();
    }
}
