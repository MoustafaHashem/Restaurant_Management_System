import java.util.ArrayList;

public class Restaurant {
    private final String name;
    private final String location;
    private final int stars;
    private ArrayList<Employee> employees=new ArrayList<>();
    private ArrayList<Table> tables=new ArrayList<>();
    private ArrayList<Menu> menus=new ArrayList<>();
    private ArrayList<MenuSection> menuSections=new ArrayList<>();
    private ArrayList<MenuItem> menuItems=new ArrayList<>();

    public Restaurant(String name, String location, int stars) {
        this.name = name;
        this.location = location;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getStars() {
        return stars;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public ArrayList<MenuSection> getMenuSections() {
        return menuSections;
    }

    public void setMenuSections(ArrayList<MenuSection> menuSections) {
        this.menuSections = menuSections;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
