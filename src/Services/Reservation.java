package Services;

import Human.Manager;
import Restaurant.Table;

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
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setID(0);
    }
    public static void changeReservation(int id,Date d){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setDate(d);
    }
    public  static void changeReservation(int id,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
    }
    public  static void changeReservation(int id,Date d,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
        reservations.get(i).setDate(d);
    }
    public  static void makeReservation(Date d, int n, int tableNum){
        Reservation r = new Reservation(d,n);
        reservations.add(r);
        System.out.println("reservationID = "+r.getID());
        int size = Manager.getTables().size();
        int i;
        for (i = 0; i < size; i++) {
            if (Manager.getTables().get(i).getTableNum() == tableNum)
                break;
        }
        Manager.getTables().get(i).addReservation(r);
    }
}
