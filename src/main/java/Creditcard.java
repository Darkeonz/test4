public class Creditcard {

   int discount;
   boolean rejected = false;
   boolean today = true;
   String type;

   public String a = "new";
   public String b = "loyal";
   public String c = "coupon";
   public String d = "loyal_coupon";

    public int GetDiscount(String type){

        if (type == "new") {
            discount = 15;
        } else if (type == "loyal") {
            discount = 10;
        } else if (type == "coupon") {
            discount = 20;
        } else if (type == "loyal_coupon") {
            discount = 30;
        } else {
            discount = 0;
        }
        return discount;
    }

    public boolean getDiscountValidation(boolean validated)
    {
        if(validated==true) {
            return rejected;
        } else {
            rejected=true;
            return rejected;
        }
    }
}
