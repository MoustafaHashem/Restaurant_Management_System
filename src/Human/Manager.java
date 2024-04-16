package Human;

import Restaurant.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Staff implements Restaurant {
    public Manager(String name, int age, String address, String phone, double salary, String rank ) {
        super(name, age, address, phone, salary, rank);
    }

    public static ArrayList<Staff> getEmployees() {
        return employees;
    }
    public static ArrayList<Table> getTables() {
        return tables;
    }
    public static ArrayList<Menu> getMenus() {
        return menus;
    }
    public static ArrayList<MenuSection> getMenuSections() {
        return menuSections;
    }
    public static ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    //under progress
//    public Table searchTable(int tableNumber){
//        //Code option1:
//    //        int size=this.getTables().size();
//    //        for(int i=0;i<size;i++)
//    //        {
//    //            if(tableNumber==this.getTables().get(i).getTableNum())
//    //                return this.getTables().get(i);
//    //        }
//    //        return null;
//        //Code option2:
//        for(Table table: this.getTables())
//        {
//            if(table.getTableNum()==tableNumber)
//                return table;
//        }
//        return null;
//    }

//    public Table searchMenuItem(int tableNumber) {
//
//    }
//    public Table searchMenuSection(int tableNumber) {
//
//    }
//    public Table searchEmployee(int tableNumber) {
//
//    }

    //Adding a new menu
    @Override
    public void addMenu(Menu m){getMenus().add(m);}

    //Add a new Menu section
    @Override
    public void addMenuSection(MenuSection ms){
        getMenuSections().add(ms);
    }

    //Add Menu item
    @Override
    public void addMenuItem(MenuItem mi){
        getMenuItems().add(mi);
    }

    //Add a new table
    @Override
    public void addTable(Table t){
        getTables().add(t);
    }

    //Adding/hiring a new employee
    @Override
    public void addEmployee(Staff e){
        getEmployees().add(e);
    }

    //Removing/firing an existing employee
    //modified
    @Override
    public void removeEmployee() {
        Scanner input = new Scanner(System.in);
        boolean idExists = false;
        String continueInput;
        String id="";
        do {
            System.out.println("Enter ID of the employee desired to be removed: ");
            id= input.next();
            int size = getEmployees().size();
            int i;
            for (i = 0; i < size; i++) {
                if (0 == getEmployees().get(i).getEmployeeID().compareTo(id)) {
                    idExists = true;
                    break;
                }
            }
            if(idExists)
            {
                getEmployees().remove(i);
                System.out.println("Employee "+getEmployees().get(i).getName() +" whose ID is: "+id+" has been removed successfully");
                System.out.println("Do you wish to remove another employee (YES/NO)?");
                continueInput=input.next();
            }
            else {
                System.out.println("The entered ID doesn't belong to an existing employee");
                System.out.println("Do you wish to re-try entering the ID of the employee desired to be removed (YES/NO)?");
                continueInput=input.next();
            }
        }while(continueInput.equalsIgnoreCase("YES"));

    }
}
