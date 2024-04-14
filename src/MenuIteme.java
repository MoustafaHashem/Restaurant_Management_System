public class MenuIteme {
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

    public MenuIteme(MenuSection menuSection,String title, double price) {
        this.title = title;
        this.ID = count++;
        this.price = price;
        this.menuSection=menuSection;
    }
    public void updatePrice(double p){
        setPrice(p);
    }

    public MenuSection getMenuSection() {
        return menuSection;
    }

    public int getID() {
        return ID;
    }
}
