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
private int numberOfPeoples;
private final static ArrayList<Reservation> reservations=new ArrayList<>();

    public Reservation(LocalDate date, int numberOfPeoples) {
        this.reservationId=++count;
        this.date = date;
        this.numberOfPeoples = numberOfPeoples;
    }



    public int getID() {
        return reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public int getNumberOfPeoples() {
        return numberOfPeoples;
    }

    public void setID(int ID) {
        this.reservationId = ID;
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
        reservations.remove(i);
        int x = Manager.getTables().size();
        int y;
        for (y = 0; y < x; y++) {
            if (Manager.getTables().get(y).getReservation().getID() == id) {
                Manager.getTables().get(y).removeReservation();
                break;
            }
        }
        System.out.println("cancelled");
    }
    public static void changeReservation(int id,LocalDate d){
        int size = reservations.size(); // if size =0 throw exception
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id){
                break;}
        }
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
        System.out.println("changed");
    }
    public  static void changeReservation(int id,LocalDate d,int n){
        int size = reservations.size();
        int i;
        for (i = 0; i < size; i++) {
            if (reservations.get(i).getID() == id)
                break;
        }
        reservations.get(i).setNumberOfPeoples(n);
        reservations.get(i).setDate(d);
        System.out.println("changed");
    }
    public  static void makeReservation(LocalDate d, int n){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name: ");
            String name=in.nextLine();
        System.out.println("Enter age: ");
            int age=in.nextInt();
        System.out.println("Enter address: ");
            String address=in.next();
        System.out.println("Enter phone: ");
            String phone=in.next();
        Customer c = new Customer(name,age,address,phone);
        Reservation r = new Reservation(d,n);
        reservations.add(r);
        System.out.println("Reservation ID:  "+r.getID());
        int size = Manager.getTables().size();
        int i;
        ArrayList <Table> availableTables = new ArrayList<>();
        int wantedTable;
        boolean invalidTable=true;
        for (i = 0; i < size; i++) {
                if(!Manager.getTables().get(i).isReserved())
                {
                    availableTables.add(Manager.getTables().get(i));
                }
            }
        if (!availableTables.isEmpty())
        {
            System.out.println("************************************************************");
            System.out.println("Available tables for making a reservation: ");
            for(Table table:availableTables)
            {
                System.out.println("\nTable "+ table.getTableNum());
            }
            do {
                System.out.println("Which table do you want to make your reservation?");
                wantedTable = in.nextInt();
                for (Table table:availableTables) {
                    if (table.getTableNum() == wantedTable) {
                        invalidTable = false;
                        break;
                    }
                }
                if(!invalidTable)
                {
                    Manager.getTables().get(wantedTable).addReservation(r);
                    c.checkIn();
                    Manager.getTables().get(wantedTable).setCustomer(c);
                    System.out.println("Reservation done successfully");
                    System.out.println("************************************************************");
                }
                else {
                    System.out.println("Please enter a valid table number from the available tables listed above");
                }
            }while(invalidTable);

        }
        else
        {
            System.out.println("No available tables for making a reservation at the restaurant at the moment");
            System.out.println("************************************************************");
        }
    }
}
