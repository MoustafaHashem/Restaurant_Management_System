package Human;

import java.time.LocalDate;
import java.util.Scanner;


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
    public  void setSalary(double salary) {
        Scanner in = new Scanner(System.in);
        boolean invalidId = true;
        String continueInput="";

            if (this instanceof Manager) {
                do {
                System.out.println("Enter ID of employee to set salary: ");
                String id= in.next();
                int i;
                for (i = 0; i < Manager.getEmployees().size(); i++) {
                    if (Manager.getEmployees().get(i).getEmployeeID().equals(id)) {
                        invalidId = false;
                    }
                }
                if (!invalidId) {
                    Manager.getEmployees().get(i).salary = salary;
                    System.out.println("Salary of employee "+ Manager.getEmployees().get(i).getName()+" is now: "+Manager.getEmployees().get(i).getSalary());
                    System.out.println("************************************************************");
                } else {
                    System.out.println("Entered ID doesn't belong to an existing employee");
                    System.out.println("Do you wish to re-try entering the ID (YES/NO)?");
                    continueInput=in.next();
                    System.out.println("************************************************************");
                }
                }while(invalidId && continueInput.equalsIgnoreCase("YES"));
            }
            else {
                System.out.println("You don't have an access to change salaries of Staff");
                System.out.println("************************************************************");
                return;
            }

    }


    public String getRank() {
        return rank;
    }

    //Manager only can set rank
    public void setRank(String rank) {
        Scanner in = new Scanner(System.in);
        boolean invalidId = true;
        String continueInput="";

        if (this instanceof Manager) {
            do {
                System.out.println("Enter ID of employee to set rank: ");
                String id= in.next();
                int i;
                for (i = 0; i < Manager.getEmployees().size(); i++) {
                    if (Manager.getEmployees().get(i).getEmployeeID().equals(id)) {
                        invalidId = false;
                    }
                }
                if (!invalidId) {
                    Manager.getEmployees().get(i).rank = rank;
                    System.out.println("Rank of employee "+ Manager.getEmployees().get(i).getName()+" is now: "+Manager.getEmployees().get(i).getRank());
                    System.out.println("************************************************************");
                } else {
                    System.out.println("Entered ID doesn't belong to an existing employee");
                    System.out.println("Do you wish to re-try entering the ID (YES/NO)?");
                    continueInput=in.next();
                    System.out.println("************************************************************");
                }
            }while(invalidId && continueInput.equalsIgnoreCase("YES"));
        }
        else {
            System.out.println("You don't have an access to change ranks of Staff");
            System.out.println("************************************************************");
            return;
        }

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
