package test.by.bakhar.task2.stax;

import by.bakhar.task2.builder.BankBuilder;
import by.bakhar.task2.builder.StaxBankBuilder;
import by.bakhar.task2.entity.Bank;
import by.bakhar.task2.entity.DepositType;
import by.bakhar.task2.entity.TraditionalBank;
import by.bakhar.task2.entity.VirtualBank;
import by.bakhar.task2.exception.BankException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;


public class StaxBankBuilderTest {

    @Test
    public void testBuildBanks() throws BankException {
        BankBuilder staxBankBuilder = new StaxBankBuilder();
        staxBankBuilder.buildBanks("src\\main\\resources\\test\\bank.xml");
        Set<Bank> actual = staxBankBuilder.getBanks();
        Set<Bank> expected = new HashSet<>();
        expected.add(new VirtualBank("v4", "Famcs", "Belarus", "Qwerty", 0.5, 64, Year.parse("2030"), DepositType.URGENT, "https://www.edu.com"));
        expected.add(new VirtualBank("v2", "Famcs", "Belarus", "Artem", 0.5, 64, Year.parse("2030"), DepositType.SAVING, "https://www.edu.com"));
        expected.add(new TraditionalBank("t1", "Famcs", "Belarus", "Grisha", 0.5, 64, Year.parse("2030"), DepositType.CALCULATED, 5));
        expected.add(new TraditionalBank("t2", "Famcs", "Belarus", "Vasya", 0.5, 64, Year.parse("2030"), DepositType.SAVING, 7));
        Assert.assertEquals(actual, expected);
    }
    @Test(expectedExceptions = BankException.class)
    public void testBankException() throws BankException {
        BankBuilder staxBankBuilder = new StaxBankBuilder();
        staxBankBuilder.buildBanks("src\\main\\resources\\test\\exception.xml");
    }
}