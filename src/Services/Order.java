package Services;

import Restaurant.MenuItem;
import java.util.ArrayList;

public class Order {
    private final int  orderID;
    private boolean isReady;
    private double cost;
    private static int count=1;
    private ArrayList<MenuItem> meals=new ArrayList<>();

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



    public Order() {
        this.orderID = count++;
        this.isReady = false;
        this.cost = 0;
        this.meals = null;
    }
    public void addMenuItem(MenuItem mi){
        meals.add(mi);
        cost=cost+mi.getPrice();
    }
    public void removeMenuItem(MenuItem mi){
        meals.remove(mi);
        cost=cost-mi.getPrice();
    }
    /*
    puplic static void addOrder(Table t) {
    int x = t.numberofpeo;
    for (int i = 0; i < x; i++) {
    t.order.addMeal(menuItems[input])
    t.order.cost = t.order.cost + menuitems[input.price]

    }
    delay
    chief make the order
    */
}