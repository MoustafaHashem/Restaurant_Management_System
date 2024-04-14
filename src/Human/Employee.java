package Human;

import java.util.Date;

public class Employee extends Person {
    private static int count = 10;
    private Date joinedDate;
    private final String employeeID;
    private final String email;
    private String password;
    private int salary;
    private String rank;

    public Employee(String name, int age, String address, int phone, String password, int salary, String rank) {
        super(name, age, address, phone);
        this.employeeID = Integer.toString(joinedDate.getYear()) + Integer.toString(count);
        this.email = employeeID+"@Gusteau.ASU";
        if (checkPassword(password)) this.password = password;
        //Error
        this.salary = salary;
        this.rank = rank;
        count++;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
        public void print() {
        super.print();
        System.out.println("Employee{employeeID= " + employeeID + ", email= " + email + ", password= " + password + ", salary= " + salary + ", rank= " + rank + '}');
    }
    public static boolean checkPassword(String p) {
        if (p.length() >= 8) return true;
        return false;
    }
}
