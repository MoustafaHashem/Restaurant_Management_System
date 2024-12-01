package Restaurant;

import java.util.Arrays;
import java.util.Collections;

import static Restaurant.Restaurant.menuItems;

public class Menu {
    private final String title;

    public String getTitle() {
        return title;
    }

    public Menu(String title) {
        this.title = title;
    }
    public static void sortMenuItems(){
        MenuItem[] arrMenuItems = new MenuItem[menuItems.size()];
        menuItems.toArray(arrMenuItems);
        Arrays.sort(arrMenuItems);
        menuItems.clear();
        menuItems.addAll(Arrays.asList(arrMenuItems));
    }
    public void print() {
        System.out.println("Menu{" + "title=" + title + '}');
    }
    public static void printAllMenuItems(){
        for(MenuItem m:menuItems)
        {
            System.out.println("MenuItem{" + "title= " + m.getTitle() + ", ID= " + m.getID() + ", price= " + m.getPrice() + '}');
        }
        System.out.println("************************************************************");
    }
}
