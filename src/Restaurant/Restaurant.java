package Restaurant;

import Human.Employee;
import Restaurant.Menu;

import java.util.ArrayList;

public interface Restaurant {
      String NAME="Gusteau";
      String LOCATION="France";
      int stars=5;
     ArrayList<Employee> employees=new ArrayList<>();
     ArrayList<Table> tables=new ArrayList<>();
     ArrayList<Menu> menus=new ArrayList<>();
     ArrayList<MenuSection> menuSections=new ArrayList<>();
     ArrayList<MenuItem> menuItems=new ArrayList<>();



     ArrayList<Employee> getEmployees() ;


     ArrayList<Table> getTables();


     ArrayList<Menu> getMenus();


     ArrayList<MenuSection> getMenuSections();


     ArrayList<MenuItem> getMenuItems();

}
