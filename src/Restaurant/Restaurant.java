package Restaurant;

import Human.Staff;
import java.util.ArrayList;

public interface Restaurant {
      String NAME="Gusteau";
      String LOCATION="France";
      int STARS=5;
     ArrayList<Staff> employees=new ArrayList<>();
     ArrayList<Table> tables=new ArrayList<>();
     ArrayList<Menu> menus=new ArrayList<>();
     ArrayList<MenuSection> menuSections=new ArrayList<>();
     ArrayList<MenuItem> menuItems=new ArrayList<>();

    public void addMenu(Menu m);
    public void addMenuSection(MenuSection ms);
    public void addMenuItem(MenuItem mi);
    public void addTable(Table t);
    public void addEmployee(Staff e);
    public void removeEmployee(String id);
}
