package Services;

import Human.Customer;
import Human.Manager;
import Restaurant.Table;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
private  int reservationId;
private static int count=0;
private LocalDate date;
private int numberOfPeople;
private final static ArrayList<Reservation> reservations=new ArrayList<>();

    public Reservation(LocalDate date, int numberOfPeople) {
        this.reservationId=++count;
        this.date = date;
        this.numberOfPeople = numberOfPeople;
    }



    public int getReservationId() {
        return reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setID(int ID) {
        this.reservationId = ID;
    }

    public void setnumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
    public static void cancelReservation(){
        Scanner input= new Scanner(System.in);
        int size = reservations.size();
        int i;
        boolean invalidReservation = true;

        do {
            System.out.println("Enter ID of Reservation to be cancelled: ");
            int id= input.nextInt();
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id)
            {
                invalidReservation=false;
            }
            if(!invalidReservation)
            {
                reservations.remove(i);
                for (Table table: Manager.getTables()) {
                    if (table.getReservation().getReservationId() == id) {
                        table.removeReservation();
                        break;
                    }
                }
                System.out.println("Reservation cancelled");
                System.out.println("************************************************************");
                break;
            }
            else {
                System.out.println("Entered Reservation ID not valid");
            }
        }
        }while(invalidReservation);
    }
    public static void changeReservation(int id,LocalDate d){
        int size = reservations.size(); // if size =0 throw exception
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id){
                break;}
        }
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id)
                break;
        }
        reservations.get(i).setnumberOfPeople(n);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,LocalDate d,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getReservationId() == id)
                break;
        }
        reservations.get(i).setnumberOfPeople(n);
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }

    public static void printReservation()
    {
        for(Reservation r: reservations)
        {
            System.out.println("Reservation ID: "+r.getReservationId());
            System.out.println("Number of people: "+r.getNumberOfPeople());
            System.out.println("Reservation date: "+ r.getDate());
            System.out.println("************************************************************");
        }
    }
}
