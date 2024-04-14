package Services;

import Human.Chief;
import Restaurant.*;
import Human.Manager;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private final int  orderID;
    private boolean isReady;
    private double cost;
    private static int count=1;
    private static ArrayList<MenuItem> meals=new ArrayList<>();

    public int getOrderID() {
        return orderID;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static void setMeals(ArrayList<MenuItem> meals) {
        Order.meals = meals;
    }

    public Order() {
        this.orderID = count++;
        this.isReady = false;
        this.cost = 0;
        this.meals = null;
    }
    public static void addMeal(int ID){
        int size = Manager.getMenuItems().size();
        int i;
        for (i = 0; i < size; i++) {
            if (Manager.getMenuItems().get(i).getID() == ID)
                break;
        }
        meals.add(Manager.getMenuItems().get(i));
      //  cost += Manager.getMenuItems().get(i).getPrice();
    }
    public static void removeMeal(int ID){
        int size = Manager.getMenuItems().size();
        int i;
        for (i = 0; i < size; i++) {
            if (Manager.getMenuItems().get(i).getID() == ID)
                break;
        }
        meals.remove(Manager.getMenuItems().get(i));
      //  cost -= Manager.getMenuItems().get(i).getPrice();
    }

    public static void addOrder(Table t) throws InterruptedException { // edit func to take int
        int num = t.getReservation().getNumberOfPeoples();
        int i;
        for (i = 1; i <= num; i++) {
        System.out.println(num +"# order");
        Scanner in = new Scanner(System.in);
        t.getOrder().addMeal(in.nextInt());
        }
        // add order to table
        Thread.sleep(10000);
        Chief.prepareOrder(t); // edit chief to take int
    }
    public static void modifyOrder(Table t, int oldMeal, int newMeal) { // edit func to take int
        int num = t.getReservation().getNumberOfPeoples();
        int i;
        for (i = 1; i <= num; i++) {
            if (oldMeal == meals.get(i).getID()) break;
        }
        meals.remove(i);
        addMeal(newMeal);
    }
}
