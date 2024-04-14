package Human;

import java.util.Date;
import Services.Reservation;
import Services.Order;

public class Customer extends Person {
    private int customerId;
    private Reservation reservation;
    private Date date;

    public Customer(String name, int age, String address, int phone, int customerId, Reservation reservation) {
        super(name, age, address, phone);
        this.customerId = customerId;
        this.reservation = reservation;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Customer{" + " customerId= " + customerId + ", reservation= " + reservation + '}');
    }
    public void checkIn(Date d) {
    }

    public Date checkOut() {
        return new Date();
    }

    public void cancelReservation(Reservation r) {
    }

    public void modifyOrder(Order o) {
    }

    public Date lastVisit() {
        return checkOut();
    }

}
