package Restaurant;

import Services.Order;
import Services.Reservation;

public class Table {
    protected Order Order;
    private int tableNum=0;
    private boolean isReserved;
    protected Order order;
    private Reservation reservation;

    public Table(){
        this.tableNum ++;
        this.isReserved = false;
    }

    public int getTableNum() {
        return tableNum;
    }
    public boolean isReserverd (){
        return isReserved;
    }

    public Order getOrder() {
        return order;
    }

    public Reservation getReservation() {
        return reservation;
    }
    public void addReservation (Reservation reservation){
        this.reservation = reservation;
        isReserved = true;
    }
    public void addOrder (Order order){
        this.order = order;
    }
}