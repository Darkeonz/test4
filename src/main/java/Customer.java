public class Customer {

    public String firstname;
    public String lastname;
    public double income;
    public String customerType;
    public boolean validated = true;

    public Customer(String firstname, String lastname, double income, String customerType, boolean validated)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.income = income;
        this.customerType = customerType;
        this.validated = validated;
    }

}
