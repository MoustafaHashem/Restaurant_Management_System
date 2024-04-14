package Services;

import Human.Customer;
import Restaurant.Table;

import java.util.Scanner;

public class Bill extends Table {
    private double bill;
    private Customer customer;
    private String paymentType;

    public Bill(String paymentType){
        bill=0;
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBill() {
        return bill;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void payment(String paymentType){
        if (paymentType.equals("cash")){
            cash(super.Order.getCost());
        }
        else if (paymentType.equals("visa")){
            Scanner scan = new Scanner(System.in);
            int password = scan.nextInt();
            visa(password,super.Order.getCost());
        }
        else{
            System.out.println("invalide payment method");
        }
    }
    public void cash(double c){
        bill =c ;
    }
    public void visa (int password,double c){
        bill = c;
    }

}
