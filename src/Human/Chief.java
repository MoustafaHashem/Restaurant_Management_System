package Human;

import Restaurant.Table;

public class Chief extends Employee {
    public Chief(String name, int age, String address, int phone, int employeeID, String email, String password, int salary, String rank) {
        super(name, age, address, phone, password, salary, rank);
    }
    public static void prepareOrder(Table t) {
        t.getOrder().setReady(true);
    }
}
