import java.util.ArrayList;

public class Order {
    private final int  orderID;
    private boolean isReady;
    private double cost;
    private static int count=1;
    private ArrayList<MenuIteme> meals=new ArrayList<>();

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
    public void addMenuIteme(MenuIteme mi){
        meals.add(mi);
        cost=cost+mi.getPrice();
    }
    public void removeMenuIteme(MenuIteme mi){
        meals.remove(mi);
        cost=cost-mi.getPrice();
    }
}