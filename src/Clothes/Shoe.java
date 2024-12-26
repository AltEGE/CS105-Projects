package src.Clothes;

public class Shoe extends Abstract_Clothes {
    public Shoe(double price,String color, int ID) {
        super(price, color, ID);
        this.bodyPart = "Feet Part";
        this.model = "Shoe";
    }

    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}
}
