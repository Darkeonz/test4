import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @Test
    void insert() {
        ATM atm = new ATM();
        Customer Andreas = new Customer("Andreas","Leonhard",1500,"loyal_coupon", true);
        atm.insert(Andreas);
        assertNotNull(Andreas);
    }

    @Test
    void deposit() {
        ATM atm = new ATM();
        Customer Andreas = new Customer("Andreas","Leonhard",1500,"loyal_coupon", true);

        assertEquals(1600,atm.deposit(Andreas,100));
    }

    @Test
    void withddraw() {
    }

    @Test
    void purchase() {
    }

    @Test
    void updatebalance() {
    }

    @Test
    void showBalance() {
    }

    @Test
    void showMontlyInterest() {
    }

    @Test
    void showYearlyInterest() {
    }


    @Test
    void hamcrestTest()
    {
        Customer Hans = new Customer("Hans","Hansen",15000,"new",true);
        Hans.validated=true;
        Creditcard creditcard = new Creditcard();
        creditcard.getDiscountValidation(Hans.validated=true);
        ATM atm = new ATM();

        assertThat(false, is(creditcard.getDiscountValidation(Hans.validated=true)));
        assertThat(true, is(creditcard.getDiscountValidation(Hans.validated=false)));
        assertThat(16000.0, is(atm.deposit(Hans,1000)));
        assertThat(15000.0, is(atm.withddraw(Hans,1000)));

    }
}