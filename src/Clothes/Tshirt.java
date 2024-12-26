package src.Clothes;

public class Tshirt extends Abstract_Clothes {
    public Tshirt( double price , String color, int ID) {
        super(price, color, ID);
        this.bodyPart = "Upper Body";
        this.model = "Tshirt";
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){this.model= model;}
}
