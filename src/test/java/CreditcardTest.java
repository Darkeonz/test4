
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class CreditcardTest {

    Creditcard creditcard = new Creditcard();
    /* Repeated test */

    /*@RepeatedTest(5)*/
    @ParameterizedTest
    @ValueSource(strings = { "new", "loyal", "coupon","loyal_coupon" })
    void getDiscount(String type) {
        assertTrue(StringUtils.isNotBlank(type));
        assertFalse(toString().isEmpty());

        assertTrue(15==creditcard.GetDiscount(creditcard.a));
        assertEquals(10,creditcard.GetDiscount(creditcard.b));
        assertEquals(20,creditcard.GetDiscount(creditcard.c));
        assertEquals(30,creditcard.GetDiscount(creditcard.d));
        assertEquals(0,creditcard.GetDiscount(""));

    }

    @ParameterizedTest
    public Collection ParameterInterestrate()
    {
        /*return Arrays.asList(new Object[][] {{15,"new"},{10,"loyal"},{20,"coupon"},{30,"loyal_coupon"}});*/
        return Arrays.asList(new Object[] {15,10,20,30});
    }

    @ParameterizedTest
    public Collection ParameterCustomerTypes()
    {
        /*return Arrays.asList(new Object[][] {{15,"new"},{10,"loyal"},{20,"coupon"},{30,"loyal_coupon"}});*/
        return Arrays.asList(new Object[] {"new", "loyal", "coupon","loyal_coupon"});
    }
    
    @Test
    @DisplayName("First Parameterized test")
    void matchingParameter()
    {
        Collection thelist = ParameterInterestrate();
        Collection clist = ParameterCustomerTypes();

        Object[] arr = thelist.toArray();
        Object[] arr2 = clist.toArray();

        assertEquals(arr[0], creditcard.GetDiscount(arr2[0].toString()),"Should be equal");
        assertEquals(arr[1], creditcard.GetDiscount(arr2[1].toString()),"Should be equal");
        assertEquals(arr[2], creditcard.GetDiscount(arr2[2].toString()),"Should be equal");
        assertEquals(arr[3], creditcard.GetDiscount(arr2[3].toString()),"Should be equal");


    }
    

    @TestFactory
    List<DynamicTest> customerTypes()
    {
        return Arrays.asList(
                DynamicTest.dynamicTest("First dynamics ",()->assertEquals(15,creditcard.GetDiscount(creditcard.a))),

                DynamicTest.dynamicTest("Second dynamics ",()->assertTrue(15==creditcard.GetDiscount(creditcard.a)))
        );
    }

    /*4 different version of parameterized test*/

    @ParameterizedTest
    @ValueSource(strings = {"new", "loyal", "coupon","loyal_coupon" })
    void getDiscount_valuesource(String type) {
        assertFalse(toString().isEmpty());
        /*Creditcard creditcard = new Creditcard();*/
        /*creditcard.GetDiscount(a);*/
        assertTrue(15==creditcard.GetDiscount(creditcard.a));
        assertEquals(10,creditcard.GetDiscount(creditcard.b));
        assertEquals(20,creditcard.GetDiscount(creditcard.c));
        assertEquals(30,creditcard.GetDiscount(creditcard.d));
        assertEquals(0,creditcard.GetDiscount(""));

    }


    @ParameterizedTest
    @CsvSource({"new, 15", "loyal,10", "coupon,20","loyal_coupon,30" })
    void getDiscount_CSVsource(String type, int index) {
        assertNotNull(type);
        assertNotEquals(0, index);

        creditcard.GetDiscount(type);

        String[] arrtype= {creditcard.a, creditcard.b, creditcard.c, creditcard.d};

        /*creditcard.a*/
        assertEquals(15,creditcard.GetDiscount(creditcard.a));

    }

    @ParameterizedTest
    @MethodSource("inputvalues")
    void testinginputvalues(String expected, int input) {
        creditcard.GetDiscount(expected);
        assertEquals(input,creditcard.GetDiscount(expected));
        //assertEquals(input, creditcard.GetDiscount(expected));
    }

    public static Collection<Object[]> inputvalues()
    {
        return Arrays.asList(new Object[][]
                {
                        { "new", 15},
                        { "loyal", 10 },
                        { "coupon", 20 },
                        {"loyal_coupon", 30}
                });
    }

    @Test
    void methodForHamcrest()
    {
        Customer Hans = new Customer("Hans","Hansen",15000,"new",true);
        Hans.validated=true;
        creditcard.getDiscountValidation(Hans.validated=true);

        assertTrue(false==creditcard.getDiscountValidation(Hans.validated=true));

        Account account = new Account();
        account.GetYearlyInterest(Hans.income);

        assertEquals(7,account.GetYearlyInterest(Hans.income));
    }

    @Test
    void hamcrestTest()
    {
        Customer Hans = new Customer("Hans","Hansen",15000,"new",true);
        Hans.validated=true;
        creditcard.getDiscountValidation(Hans.validated=true);

        assertThat(false, is(creditcard.getDiscountValidation(Hans.validated=true)));
        assertThat(true, is(creditcard.getDiscountValidation(Hans.validated=false)));

    }



}