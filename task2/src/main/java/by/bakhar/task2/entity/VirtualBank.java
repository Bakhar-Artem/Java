package by.bakhar.task2.entity;

import java.time.Year;

public class VirtualBank extends Bank {
    private final static String WEB_SITE = "https://bakhar.com/product";
    private String website;

    public VirtualBank(String id, String name, String country, String depositor, double amountOnDeposit, int profitability, Year timeConstraint, DepositType depositType, String website) {
        super(id, name, country, depositor, amountOnDeposit, profitability, timeConstraint, depositType);
        this.website = website;
    }

    public VirtualBank() {
        this.website = WEB_SITE;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        VirtualBank that = (VirtualBank) o;
        return website.equals(that.website);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += (13 * website.hashCode()) % 101;
        return result;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Virtual bank ").append(super.toString()).append(", ").append("website ").append(website);
        return stringBuilder.toString();
    }
}
