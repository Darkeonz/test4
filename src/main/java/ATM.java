public class ATM {

    public Customer insert(Customer customer)
    {
        if (customer.validated==true)
        {
            return customer;

        } else {

            return null;
        }
    }

    public double deposit(Customer customer, double depositAmount)
    {
        double income = customer.income;

        if(depositAmount<1)
        {
            return  0;
        } else {
            income += depositAmount;

            double up  = updatebalance(customer, income);
            return up;

        }

    }

    public double withddraw(Customer customer, double extractAmount)
    {
        double income = customer.income;
        if(income<extractAmount)
        {
            return 0;
        } else {
            income = income - extractAmount;
            double up  = updatebalance(customer, income);
            return up;
        }
    }

    public double purchase(Customer customer, double purchase, String discountType)
    {
        if(customer.validated==true && purchase>0)
        {
            Creditcard creditcard = new Creditcard();

            int discountRate = creditcard.GetDiscount(discountType);
            double discountRate2 = (double)discountRate;
            double purchaseAmount = purchase * (discountRate2/100);
            double totpurchase = purchase - purchaseAmount;
            System.out.println(purchaseAmount);
            double income = customer.income - totpurchase;
            updatebalance(customer, income);
            return totpurchase;


        } else {
            return 0;
        }
    }

    public double updatebalance(Customer customer, double income)
    {

        double c = customer.income = income;
        return c;
    }


    public double showBalance(Customer customer)
    {
       return  customer.income;
    }

    public double showMontlyInterest(Account account, Customer customer)
    {
        double acc = account.GetMonthlyInterest(customer.income);
        return acc;
    }

    public double showYearlyInterest(Account account, Customer customer)
    {
        double acc = account.GetYearlyInterest(customer.income);
        return acc;
    }

}
