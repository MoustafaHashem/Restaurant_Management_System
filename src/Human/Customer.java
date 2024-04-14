package Human;

import java.util.Date;
import Services.Reservation;
import Services.Order;

public class Customer extends Person {
    private static int count = 1;
    private final int customerId;
    private Reservation reservation;
    private Date checkInDate;
    private Date checkOutDate;

    public Customer(String name, int age, String address, int phone, Reservation reservation) {
        super(name, age, address, phone);
        this.customerId = count++;
        this.reservation = reservation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Customer{" + " customerId= " + customerId + ", reservation= " + reservation + '}');
    }
    public void checkIn() {
        checkInDate = new Date();
    }

    public void checkOut() {
        checkOutDate = new Date();
    }

    public void cancelReservation(Reservation r) {
        //r.id = xxxxx;
    }
}
