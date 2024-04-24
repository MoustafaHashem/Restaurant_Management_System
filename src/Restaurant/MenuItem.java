package Restaurant;

import Human.Manager;
import Restaurant.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;

import static Restaurant.Restaurant.menuItems;

public class MenuItem implements Comparable {
    private final String title;
    private final int ID;
    private static int count;
    private double price;
    private final MenuSection menuSection;

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem(MenuSection menuSection, String title, double price) {
        this.title = title;
        this.ID = count++;
        this.price = price;
        this.menuSection = menuSection;
    }
    public void updatePrice(double p){
        setPrice(p);
    }

    public MenuSection getMenuItem() {
        return menuSection;
    }

    public int getID() {
        return ID;
    }
    @Override
    public int compareTo(Object m) {
        int returnValue=0;

//            if (this.getTitle().compareTo(((MenuItem)m).getTitle()) > 0){
//                returnValue= 1;
//            }
//            else if(this.getTitle().compareTo(((MenuItem)m).getTitle()) < 0){
//                returnValue= -1;
//            }
        if (this.getPrice()>((MenuItem)m).getPrice() ){
            returnValue= 1;
        }
        else if(this.getPrice()< ((MenuItem)m).getPrice() ){
            returnValue= -1;
        }

        return returnValue;
    }

    public void print() {
        menuSection.print();
        System.out.println("MenuItem{" + "title= " + title + ", ID= " + ID + ", price= " + price + '}');
    }


}
