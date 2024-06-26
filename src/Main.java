import Human.Staff;
import Human.Manager;
import Restaurant.*;
import Services.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Manager mousatafa=new Manager("Moustafa",20,"El-Obour City","01097963663",10000,"High");
        Staff kemo=new Staff("kareem",21,"Faisal City","01115393580", 1000,"medium");
        mousatafa.addEmployee(new Staff("micheal",21,"El-Marg City","01229082038", 500,"low"));
        mousatafa.addEmployee(kemo);
        mousatafa.addMenu(new Menu("main menu"));
        mousatafa.addMenuSection(new MenuSection(mousatafa.getMenus().get(0),"Grilled"));
        mousatafa.addMenuSection(new MenuSection(mousatafa.getMenus().get(0),"Fried" ));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"Chicken",100));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"Meat",150));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(0),"Kebab",300));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"Fried chicken",150));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"Fish",75));
        mousatafa.addMenuItem(new MenuItem(mousatafa.getMenuSections().get(1),"Meat",200));
//       for (int i=0;i<5;i++) {
//           mousatafa.addTable(new Table());
//       }
//        for (int i=0;i<5;i++) {
//            Manager.getTables().get(i).print();
//        }
//
//        System.out.println("---------------------------------------------");
//        for (int i=0;i<mousatafa.getEmployees().size();i++) {
//            mousatafa.getEmployees().get(i).print();
//        }
//        //mousatafa.removeEmployee();
//        for (int i=0;i<mousatafa.getEmployees().size();i++) {
//            mousatafa.getEmployees().get(i).print();
//        }
//        System.out.println("---------------------------------------------");
//        for (int i=0;i<mousatafa.getMenus().size();i++) {
//            mousatafa.getMenus().get(i).print();
//        }
//        System.out.println("---------------------------------------------");
//        for (int i=0;i<mousatafa.getMenuSections().size();i++) {
//            mousatafa.getMenuSections().get(i).print();
//        }
//        System.out.println("---------------------------------------------");
//        for (int i=0;i<mousatafa.getMenuItems().size();i++) {
//            mousatafa.getMenuItems().get(i).print();
//        }
//        System.out.println("---------------------------------------------------------------------------------");
//            Reservation.makeReservation(LocalDate.now(),1);
//            Reservation.cancelReservation();
//            try{
//                Order.addOrder(1);
//            } catch(InputMismatchException e){
//                System.out.println("Invalid input: please enter an integer");
//            }
//        //Bill.payment(1);
//        System.out.println("hey");
        Menu.sortMenuItems();
        //Arrays.sort(Manager.getMenuItems().toArray());
        Menu.printAllMenuItems();
        }
}
