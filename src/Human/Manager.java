package Human;

import Restaurant.*;
import java.util.ArrayList;

public class Manager extends Staff implements Restaurant {


    public Manager(String name, int age, String address, String phone, String password, int salary, String rank ) {
        super(name, age, address, phone, password, salary, rank);
    }

    public void addMenu(Menu m){getMenus().add(m);}

    public void addMenuSection(MenuSection ms){
        getMenuSections().add(ms);
    }

    public void addMenuItem(MenuItem mi){
        getMenuItems().add(mi);
    }

    public void addTable(Table t){
        getTables().add(t);
    }

    public void addEmployee(Staff e){
        getEmployees().add(e);
    }
    public void removeEmployee(String id){
        int size = getEmployees().size();
        int i;
        for (i = 0; i < size; i++) {
            if (0 == getEmployees().get(i).getEmployeeID().compareTo(id))
                break;
        }
        // if i = size exception handling
        getEmployees().remove(i);
    }

    @Override
    public ArrayList<Staff> getEmployees() {
        return employees;
    }

    public static ArrayList<Table> getTables() {
        return tables;
    }

    @Override
    public ArrayList<Menu> getMenus() {
        return menus;
    }

    @Override
    public ArrayList<MenuSection> getMenuSections() {
        return menuSections;
    }

    public static ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
