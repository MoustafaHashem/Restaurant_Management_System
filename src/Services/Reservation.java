package Services;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
private  int ID;
private static int count=0;
private Date date;
private int numberOfPeoples;
private static ArrayList<Reservation> reservations=new ArrayList<>();

    public Reservation(Date date, int numberOfPeoples) {
        this.ID=++count;
        this.date = date;
        this.numberOfPeoples = numberOfPeoples;
    }

    public int getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNumberOfPeoples(int numberOfPeoples) {
        this.numberOfPeoples = numberOfPeoples;
    }
    public static void cancelReservation(int id){
        r.setID(0);
    }
    public static void changeReservation(int id,Date d){
        r.setDate(d);
    }
    public  static void changeReservation(int id,int n){
        r.setNumberOfPeoples(n);
    }
    public  static void changeReservation(int id,Date d,int n){
        r.setNumberOfPeoples(n);
        r.setDate(d);
    }
    public  static void makeReservation(Date d,int n){
        reservations.add(new Reservation(d,n));

        System.out.println("reservationID = "+r.getID());
    }
}
