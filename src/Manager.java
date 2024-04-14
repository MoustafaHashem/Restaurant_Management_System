
public class Manager extends Employee{
    Restaurant my_Restaurant;

    public Manager(String name, int age, String address, int phone, int employeeID, String email, String password, int salary, String rank, Restaurant my_Restaurant) {
        super(name, age, address, phone, employeeID, email, password, salary, rank);
        this.my_Restaurant = my_Restaurant;
    }

    public void addMenu(Menu m){
        my_Restaurant.getMenus().add(m);
    }

    public void removeMenu(Menu m){
        my_Restaurant.getMenus().remove(m);
    }
    public void addMenuSection(MenuSection ms){
        my_Restaurant.getMenuSections().add(ms);
    }
    public void removeMenuSection(MenuSection ms){
        my_Restaurant.getMenuSections().remove(ms);
    }
    public void addMenuItem(MenuItem mi){
        my_Restaurant.getMenuItems().add(mi);
    }
    public void removeMenuItem(MenuItem mi){
        my_Restaurant.getMenuItems().remove(mi);
    }
    public void addTable(Table t){
        my_Restaurant.getTables().add(t);
    }
    public void removeTable(Table t){
        my_Restaurant.getTables().remove(t);
    }
    public void addEmployee(Employee e){
        my_Restaurant.getEmployees().add(e);
    }
    public void removeEmployee(Employee e){
        my_Restaurant.getEmployees().remove(e);
    }

}
