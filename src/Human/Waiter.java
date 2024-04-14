package Human;

import Restaurant.Table;

public class Waiter extends Employee {
    public Waiter(String name, int age, String address, int phone, int employeeID, String email, String password, int salary, String rank) {
        super(name, age, address, phone, employeeID, email, password, salary, rank);
    }

    public void addOrder(Table t) {

    }
}
