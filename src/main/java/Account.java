public class Account {

    public double balance;
    public double interest;

 
    public double GetMonthlyInterest(double balance)
    {
        if (balance>=0 && balance<=100 )
        {
            interest=3;
        }
        else if (balance>100 && balance<=1000)
        {
            interest=5;
        }
        else if(balance>1000)
        {
            interest=7;
        }
        else
        {
            interest = 0;
        }
        return interest;
    }

    public double GetYearlyInterest(double balance)
    {
        if (balance>=0 && balance<=100 )
        {
            interest=3;
        }
        else if (balance>100 && balance<=1000)
        {
            interest=5;
        }
        else if(balance>1000)
        {
            interest=7;
        }
        else
        {
            interest = 0;
        }
        return interest;
    }

    public double getBalance(Customer customer,double amount)
    {
        if(customer.income<amount)
        {
            return 0;
        } else {
            double balance = customer.income - amount;
            return balance;
        }

    }
}
