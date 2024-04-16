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
    public  static void makeReservation(LocalDate d, int n){
        Scanner in=new Scanner(System.in);

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
            System.out.println("Let's start making your reservation :)");
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
            System.out.println("Reservation ID:  "+r.getReservationId());
            System.out.println("************************************************************");
            System.out.println("Available tables for making a reservation: ");
            System.out.println();
            for(Table table:availableTables)
            {
                System.out.println("Table "+ table.getTableNum());
            }
            do {
                System.out.println("\nWhich table do you want to make your reservation?");
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
                    Manager.getTables().get(wantedTable).setIsReserved(true);
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
