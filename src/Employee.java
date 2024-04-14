public class Employee extends Person {
    private int employeeID;
    private String email;
    private String password;
    private int salary;
    private String rank;

    public Employee(String name, int age, String address, int phone, int employeeID, String email, String password, int salary, String rank) {
        super(name, age, address, phone);
        this.employeeID = employeeID;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.rank = rank;
    }

    @Override
    public void print() {
        System.out.println("Employee{employeeID= " + employeeID + ", email= " + email + ", password= " + password + ", salary= " + salary + ", rank= " + rank + '}');
    }
}
