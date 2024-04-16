package Human;

import java.time.LocalDate;


public class  Staff extends Person {
    private static int count = 10;
    private final LocalDate joinedDate;
    private final String employeeID;
    private final String email;
    private String password;
    private double salary;
    private String rank;

    public Staff(String name, int age, String address, String phone, double salary, String rank) {
        super(name, age, address, phone);
        this.joinedDate = LocalDate.now();
        this.employeeID = joinedDate.getYear() + Integer.toString(count);
        this.email = employeeID+"@Gusteau.ASU";
         this.password = employeeID;
        this.salary = salary;
        this.rank = rank;
        count++;
    }

    public LocalDate getJoinedDate() {
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
        if (checkPassword(password))
            this.password = password;
       else
            System.out.println("Password must be 8 characters or more\n");
    }

    public double getSalary() {
        return salary;
    }

    //Manager only can set salary
    public static void setSalary(String id,double salary) {
        int i;
        for(i=0;i<Manager.getEmployees().size();i++) {
            int x=Manager.getEmployees().get(i).getEmployeeID().compareTo(id);
          if(x==0)break;
        }
              // exception handling
        Manager.getEmployees().get(i).salary=salary;
    }


    public String getRank() {
        return rank;
    }

    //Manager only can set rank
    public void setRank(String rank) {
        if(this instanceof Manager)
        this.rank = rank;
        else
            System.out.println("You don't have an access to change ranks of Staff");
    }

    @Override
        public void print() {
        super.print();
        System.out.println("Employee ID: " + employeeID + "\nEmail: " + email + "\nPassword: " + password + "\nSalary: " + salary + "\nRank: " + rank + "\nJoinedDate: "+joinedDate);
        System.out.println("************************************************************");
    }
    public void printAllEmployees() {
        for(Staff employee:Manager.getEmployees()) {
            System.out.println("Employee ID: " + employeeID + "\nEmail: " + email + "\nPassword: " + password + "\nSalary: " + salary + "\nRank: " + rank + "\nJoinedDate: " + joinedDate);
            System.out.println("************************************************************");
        }
    }
    public static boolean checkPassword(String p) {
        return p.length() >= 8;
    }
}
