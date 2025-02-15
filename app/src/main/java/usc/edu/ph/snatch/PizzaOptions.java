package usc.edu.ph.snatch;

public class PizzaOptions {
    private String name;
    private int categoryID;
    private int price;
    private int imageID;

    public String getName(){
        return name;
    }

    public int getCategoryID(){
        return categoryID;
    }

    public int getPrice(){
        return price;
    }
    public int getImageID(){
        return imageID;
    }
    public PizzaOptions(String name, int categoryID, int price, int imageID){
        this.name = name;
        this.categoryID = categoryID;
        this.price = price;
        this.imageID = imageID;
    }
}
