package Services;

import Restaurant.*;
import Human.Manager;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private double cost=0;
    private final ArrayList<MenuItem> meals=new ArrayList<>();

    public double getCost() {
        return cost;
    }
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
    public void setCost(double cost) throws IllegalArgumentException {
        if(cost<=0){
            throw new IllegalArgumentException("cost can't be less than zero");
        }
        else{
            this.cost = cost;
        }
    }



    public  ArrayList<MenuItem> getMeals() {
        return meals;
    }

    static int searchMenuItem(int ID) {
        int size = Manager.getMenuItems().size();
        if(size<=ID){
            System.out.println("ID not available in menu");
            return -1;
        }
        else {
            int i;
            for (i = 0; i < size; i++) {
                //   System.out.println("chek id ");
                if (Manager.getMenuItems().get(i).getID() == ID)
                    break;
            }
            return i;
        }
    }
    static int searchTableNum(int tableNum){
        int x = Manager.getTables().size();
        // System.out.println("check 2");
        if(x<tableNum) {
            System.out.println("Table number not available");
            return -1;
        }
        else{
            int y;
            for (y = 0; y < x; y++) {
                //  System.out.println("check 3"+Manager.getTables().get(y).getTableNum());
                if (tableNum == Manager.getTables().get(y).getTableNum()) break;
            }
            return y;
        }
    }




    public static MenuItem addMeal(int ID) {
      //  System.out.println("search for meal");
        int i = searchMenuItem(ID);
        // System.out.println("chek 1 ");
        return Manager.getMenuItems().get(i);

    }
    public static MenuItem removeMeal(int ID){
        int i = searchMenuItem(ID);
        return Manager.getMenuItems().get(i);

    }

    public static void addOrder(int tableNum) throws InterruptedException { // edit func to take int
        Order order=new Order();
        //System.out.println("check 1");
           int y = searchTableNum(tableNum);

       // System.out.println("find table");
        int num = Manager.getTables().get(y).getReservation().getNumberOfPeople();
        int i;
        for (i = 1; i <= num; i++) {
        System.out.println(i +"# order");
        Scanner in = new Scanner(System.in);
            System.out.println("enter id for meal");
            MenuItem mi=addMeal(in.nextInt());
           order.meals.add(mi);
            try{
                order.setCost(order.getCost()+mi.getPrice());
            }catch(IllegalArgumentException e){
                System.out.println("Cost has to be positive");
            }
            System.out.println("meal added");
        }
        System.out.println("order is cooking");

        // add order to table
        Manager.getTables().get(y).addOrder(order);
        Thread.sleep(10000);
        System.out.println("order is cooked");
    }
    public static void modifyOrder(int tableNum, int oldMeal, int newMeal) { // edit func to take int
        int y = searchTableNum(tableNum);
        int num = Manager.getTables().get(y).getReservation().getNumberOfPeople();
        int i;
        for (i = 1; i <= num; i++) {
            if (oldMeal == Manager.getTables().get(y).getOrder().getMeals().get(i).getID()) {
                break;
            }
        }
        try{
            Manager.getTables().get(y).getOrder().setCost(Manager.getTables().get(y).getOrder().getCost()-Manager.getTables().get(y).getOrder().getMeals().get(i).getPrice());
        }catch (IllegalArgumentException r){
            System.out.println("Cost has to be positive");
        }
        Manager.getTables().get(y).getOrder().getMeals().remove(i);
        MenuItem mi=addMeal(newMeal);
        Manager.getTables().get(y).getOrder().getMeals().add(mi);
        try{
            Manager.getTables().get(y).getOrder().setCost(Manager.getTables().get(y).getOrder().getCost()+mi.getPrice());
        }catch (IllegalArgumentException t){
            System.out.println("Cost has to be positive");
        }
    }
//    public static MenuItem addMeal(int ID){
//        //  System.out.println("search for meal");
//        int size = Manager.getMenuItems().size();
//        int i;
//        for (i = 0; i < size; i++) {
//            //   System.out.println("chek id ");
//            if (Manager.getMenuItems().get(i).getID() == ID)
//                break;
//        }
//        // System.out.println("chek 1 ");
//        return Manager.getMenuItems().get(i);
//
//    }
//    public static MenuItem removeMeal(int ID){
//        int size = Manager.getMenuItems().size();
//        int i;
//        for (i = 0; i < size; i++) {
//            if (Manager.getMenuItems().get(i).getID() == ID)
//                break;
//        }
//        return Manager.getMenuItems().get(i);
//
//    }
//
//    public static void addOrder(int tableNum) throws InterruptedException { // edit func to take int
//        Order order=new Order();
//        //System.out.println("check 1");
//        int x = Manager.getTables().size();
//        // System.out.println("check 2");
//        int y;
//        for (y = 0; y < x; y++) {
//            //  System.out.println("check 3"+Manager.getTables().get(y).getTableNum());
//            if (tableNum == Manager.getTables().get(y).getTableNum()) break;
//        }
//        // System.out.println("find table");
//        int num = Manager.getTables().get(y).getReservation().getNumberOfPeople();
//        int i;
//        for (i = 1; i <= num; i++) {
//            System.out.println(i +"# order");
//            Scanner in = new Scanner(System.in);
//            System.out.println("enter id for meal");
//            MenuItem mi=addMeal(in.nextInt());
//            order.meals.add(mi);
//            order.setCost(order.getCost()+mi.getPrice());
//            System.out.println("meal added");
//        }
//        System.out.println("order is cooking");
//
//        // add order to table
//        Manager.getTables().get(y).addOrder(order);
//        Thread.sleep(10000);
//        System.out.println("order is cooked");
//    }
//    public static void modifyOrder(int tableNum, int oldMeal, int newMeal) { // edit func to take int
//        int x = Manager.getTables().size();
//        int y;
//        for (y = 0; y < x; y++) {
//            if (tableNum == Manager.getTables().get(y).getTableNum()) break;
//        }
//        int num = Manager.getTables().get(y).getReservation().getNumberOfPeople();
//        int i;
//        for (i = 1; i <= num; i++) {
//            if (oldMeal == Manager.getTables().get(y).getOrder().getMeals().get(i).getID()) {
//                break;
//            }
//        }
}
