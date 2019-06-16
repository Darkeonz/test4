import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @org.junit.jupiter.api.Test
    void getMonthlyInterest() {

        double a = 1000;
        double b = 1001;
        double c = 0;
        double d = -1;
        double e = 99;
        double f = 500;

        Account account = new Account();
        account.GetMonthlyInterest(a);
        assertEquals(5.0,account.GetMonthlyInterest(a));
        assertNotEquals(5.0,account.GetMonthlyInterest(d));
    }

    @Test
    public void checkZeroMinus()
    {
        double c = 0;
        double d = -1;
        Account account = new Account();
        account.GetMonthlyInterest(c);
        assertEquals(3,account.GetMonthlyInterest(c));
        assertTrue(0==account.GetMonthlyInterest(d));
        assertTrue(5==account.GetMonthlyInterest(999.9));
        assertFalse(7==account.GetMonthlyInterest(1000));
        assertEquals(7,account.GetMonthlyInterest(4500));
        assertEquals(3,account.GetMonthlyInterest(100));
        assertNotEquals(3,account.GetMonthlyInterest(101));
    }

    @Test
    public void balanceupdate()
    {
        Customer Andreas = new Customer("Andreas","Leonhard",1500,"loyal_coupon", true);
        Account account = new Account();
        account.getBalance(Andreas,200);

        assertEquals(1300,account.getBalance(Andreas,200));
    }


    @RepeatedTest(5)
    public void creditcardGetDiscount(RepetitionInfo repetitionInfo)
    {
        String a = "new";
        String b = "loyal";
        String c = "coupon";
        String d = "loyal_coupon";

        repetitionInfo.getTotalRepetitions();

        Creditcard creditcard = new Creditcard();
        creditcard.GetDiscount(a);
        assertTrue(15==creditcard.GetDiscount(a));
        assertEquals(10,creditcard.GetDiscount(b));
        assertEquals(20,creditcard.GetDiscount(c));
        assertEquals(30,creditcard.GetDiscount(d));
        assertEquals(0,creditcard.GetDiscount(""));
    }


    List<Integer> numbers = Arrays.asList(-1, 0, 999,1000 ,4500, 100,101);

    @ParameterizedTest
    public Collection Interestrate()
    {
        return Arrays.asList(new Object[] {15,10,20,30});
    }


    @ParameterizedTest
    @CsvSource({"new, 15", "loyal, 10", "coupon,20","loyal_coupon,30"})
    void testInterestrate(String input, int expected) {

    }

}