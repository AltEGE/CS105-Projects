package Clothes;

public abstract class Abstract_Clothes {
    protected double price;
    protected String color;

    protected String bodyPart;
    protected String model;

    protected int ID;

    public Abstract_Clothes(double price, String color, int ID) {
        this.price = price;
        this.color = color;
        this.ID = ID;
    }

    public void getInfo(){
        System.out.println("ID : " + ID + "\n"
                + "Your item is " + color + " " + model + "\n"
                + "Model price is " + price );
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {this.price = price;}

    public String getColor() {return color;}
    public void setColor(String color) {
        this.color = color;
    }


    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
