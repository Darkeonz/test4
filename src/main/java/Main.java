public class Main {

    public static void main(String[] args) {

        Customer jakob = new Customer("Jakob","Pedersen",1500,"loyal_coupon", true);
        Account account = new Account();
        account.GetMonthlyInterest(jakob.income);
        Creditcard creditcard = new Creditcard();
        creditcard.GetDiscount(jakob.customerType);
        creditcard.getDiscountValidation(jakob.validated);


        System.out.println( "rejected " + creditcard.getDiscountValidation(jakob.validated) + " The monthly interest rate for " + jakob.firstname
                + " is " + account.GetMonthlyInterest(account.balance) + " and creditcard discount-rate of "
                + creditcard.GetDiscount(jakob.customerType));

        ATM atm = new ATM();

        double dep = atm.deposit(jakob,500);

        System.out.println(" deposit " +  dep + " withdraw " +  atm.withddraw(jakob,200) +
        " purchase " + atm.purchase(jakob, 300,jakob.customerType) + " balance " + atm.showBalance(jakob));

    }
}
