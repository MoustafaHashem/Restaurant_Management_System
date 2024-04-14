package Human;

import Restaurant.*;
import java.util.ArrayList;

public class Manager extends Employee implements Restaurant {


    public Manager(String name, int age, String address, int phone, String password, int salary, String rank ) {
        super(name, age, address, phone, password, salary, rank);
    }

    public void addMenu(Menu m){getMenus().add(m);}
    public void removeMenu(Menu m){
        getMenus().remove(m);
    }
    public void addMenuSection(MenuSection ms){
        getMenuSections().add(ms);
    }
    public void removeMenuSection(MenuSection ms){
        getMenuSections().remove(ms);
    }
    public void addMenuItem(MenuItem mi){
        getMenuItems().add(mi);
    }
    public void removeMenuItem(MenuItem mi){
        getMenuItems().remove(mi);
    }
    public void addTable(Table t){
        getTables().add(t);
    }
    public void removeTable(Table t){
        getTables().remove(t);
    }
    public void addEmployee(Employee e){
        getEmployees().add(e);
    }
    public void removeEmployee(Employee e){
        getEmployees().remove(e);
    }

    @Override
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public ArrayList<Table> getTables() {
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

    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}